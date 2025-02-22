// package ex04;

import java.util.Scanner;
import java.util.Random;

public class Alteracao{
	public static Integer strcmp (String word1, String word2){
		Integer resp = 0;

		int wlength1 = word1.length(),
			wlength2 = word2.length(),
			minorLength = (wlength1 < wlength2) ? wlength1 : wlength2;

		for(int i = 0; i < minorLength; i++){
			if(word1.charAt(i) > word2.charAt(i)){
				resp++;
				i = minorLength;
			}
			else if(word1.charAt(i) < word2.charAt(i)){
				resp--;
				i = minorLength;
			}
		}

		if(resp == 0 && wlength1 != wlength2){
			if(wlength1 > wlength2)
				resp++;
			else
				resp--;
		}

		return resp;
	}
    public static String alteraLetra(String word, char first, char second){

        char[] wordChar = new char[word.length()];

        for(int i = 0; i < wordChar.length; i++){
            if(word.charAt(i) == first){
                wordChar[i] = second;
            }else{
                wordChar[i] = word.charAt(i);
            }
        }

        String resp = new String(wordChar);

        return resp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        
        Random gerador = new Random();

        gerador.setSeed(4);

		while(strcmp(word,"FIM") != 0){

			char first = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
			// System.out.println("Caractere sorteado: " + first);

			char second = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
			// System.out.println("Caractere sorteado: " + second);

			System.out.println(alteraLetra(word, first, second));

			word = sc.nextLine();

		}

        sc.close();
    }
}
