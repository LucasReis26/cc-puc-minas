package ex04;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import ex04.assets.ArvoreAlvinegra;
import ex04.assets.Show;
import ex04.assets.LogStatus;
import ex04.assets.NoAN;

public class Ex04{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		File arquivo = new File("/tmp/disneyplus.csv");
		Scanner filesc = new Scanner(arquivo,"UTF-8");
		filesc.nextLine();

		Show[] shows = new Show[1368];

		for(int i = 0; i < 1368; i++){
			String line = filesc.nextLine();
			shows[i] = new Show();
			shows[i].ler(line);
		}

		ArvoreAlvinegra aa_shows = new ArvoreAlvinegra();

		String getId = sc.nextLine();
		while(!getId.equals("FIM")){
			Integer id = Integer.parseInt(getId.substring(1,getId.length()));
			aa_shows.inserir(shows[id - 1].clone());
			getId = sc.nextLine();
		}

		try{
			File arquivo_log = new File("./853431_arvoreAlvinegra.txt");
			FileWriter fw = new FileWriter(arquivo_log);
			LogStatus ls = new LogStatus();

			String nome_busca = sc.nextLine();
			ls.iniciar();
			while(!nome_busca.equals("FIM")){
				if(aa_shows.pesquisar(nome_busca,ls)) System.out.println("SIM");
				else System.out.println("NAO");

				nome_busca = sc.nextLine();
			}
			ls.parar();

			fw.write(ls.tempoAlgoritmo() + "\t" + ls.getComparacoes());
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}


		filesc.close();
		sc.close();
	}
}
