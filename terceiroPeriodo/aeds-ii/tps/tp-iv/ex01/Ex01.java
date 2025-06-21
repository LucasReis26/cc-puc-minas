package ex01;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.RandomAccessFile;
import ex01.assets.Lista;
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

		Lista lista_shows = new Lista();

		String getId = sc.nextLine();
		while(!getId.equals("FIM")){
			Integer id = Integer.parseInt(getId.substring(1,getId.length()));
			lista_shows.inserirFim(shows[id - 1].clone());
			getId = sc.nextLine();
		}

		int operacoes = sc.nextInt();

		for(int i = 0; i < operacoes; i++){
			String getOp = sc.next();

			if(getOp.equals("II")){
				getId = sc.next();
				Integer id = Integer.parseInt(getId.substring(1,getId.length()));
				lista_shows.inserirInicio(shows[id - 1].clone());
			}else if(getOp.equals("IF")){
				getId = sc.next();
				Integer id = Integer.parseInt(getId.substring(1,getId.length()));
				lista_shows.inserirFim(shows[id - 1].clone());
			}else if(getOp.equals("I*")){
				int pos = sc.nextInt();
				getId = sc.next();
				Integer id = Integer.parseInt(getId.substring(1,getId.length()));
				lista_shows.inserir(shows[id - 1].clone(),pos);
			}else if(getOp.equals("RI")){
				System.out.println("(R) " + lista_shows.removerInicio().getTitle());
			}else if(getOp.equals("RF")){
				System.out.println("(R) " + lista_shows.removerFim().getTitle());
			}else if(getOp.equals("R*")){
				int pos = sc.nextInt();
				System.out.println("(R) " + lista_shows.remover(pos).getTitle());
			}
		}

		lista_shows.mostraRestantes();


		filesc.close();
		sc.close();
	}
}
