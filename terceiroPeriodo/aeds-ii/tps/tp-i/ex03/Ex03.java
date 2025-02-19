// package ex03;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Ex03{

	public static Integer strcmp(String word1, String word2){

		//Variáveis
		Integer resp = 0;

		int wl1 = word1.length(),
			wl2 = word2.length(),
			minorLength = (wl1 > wl2) ? wl2 : wl1;

		//Código	

		//Verifica se a palavra 1 é maior que a palavra 2
		for(int i = 0; i < minorLength; i++){
			if(word1.charAt(i) > word2.charAt(i))
				resp = 1;
			else if(word1.charAt(i) < word2.charAt(i))
				resp = -1;
		}

		//Se a palavra 1 for igual a palavra 2 mas os tamanhos forem diferentes, identificar o maior
		if(resp == 0 && wl1 != wl2){
			if(wl1 > wl2)
				resp = 1;
			else
				resp = -1;
		}

		//Retorno da função
		return resp;
	}

	public static String Cifra(String word){

		//Variáveis 
		Integer wordLength = word.length();
		char[] wordChar = new char[wordLength];

		//Código
		
		//No char de array, adicionar a letra do índice mais 3 posições
		for(int i = 0; i < wordLength; i++){
			if(word.charAt(i) == '\uFFFD')
				wordChar[i] = '\uFFFD';
			else
				wordChar[i] = (char) (word.charAt(i) + 3);
		}

		//Retorno da função
		return new String(wordChar);
	}

	public static void main(String[] args) throws UnsupportedEncodingException{

		//Variáveis
		Scanner sc = new Scanner(new InputStreamReader(System.in, "UTF-8"));

		String word = sc.nextLine();

		//Código

		//Enquanto a palavra for diferente de FIM, faça o ciframento e imprima na tela
		while(strcmp(word,"FIM") != 0){

			String wordCifra = Cifra(word);

			System.out.println(wordCifra);

			word = sc.nextLine();	
		}

		//Fechando o Scanner
		sc.close();
	}
}
