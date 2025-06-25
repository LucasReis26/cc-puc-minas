package ex01;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import ex01.assets.ArvoreBinaria;
import ex01.assets.Show;

public class Ex01{
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

		ArvoreBinaria ab_shows = new ArvoreBinaria();

		String getId = sc.nextLine();
		while(!getId.equals("FIM")){
			Integer id = Integer.parseInt(getId.substring(1,getId.length()));
			ab_shows.inserir(shows[id - 1].clone());
			getId = sc.nextLine();
		}

		String nome_busca = sc.nextLine();

		while(!nome_busca.equals("FIM")){
			if(ab_shows.pesquisar(nome_busca)) System.out.println("SIM");
			else System.out.println("NAO");

			nome_busca = sc.nextLine();
		}

		filesc.close();
		sc.close();
	}
}
