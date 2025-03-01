// package ex10;

import java.util.Scanner;

public class Contagem{
	public static Integer strcmp(String w1, String w2){
		Integer wlen1 = w1.length(),
				wlen2 = w2.length(),
				minor = (wlen1 < wlen2) ? wlen1 : wlen2,
				resp = 0;

		for(int i = 0; i < minor; i++){
			if(w1.charAt(i) < w2.charAt(i)){
				resp = -1;
				i = minor;
			}else if(w1.charAt(i) > w2.charAt(i)){
				resp = 1;
				i = minor;
			}
		}
		if(resp == 0 && wlen1 != wlen2){
			if(wlen1 < wlen2)
				resp = -1;
			else
				resp = 1;
		}
		return resp;
	}
	public static Integer countWord(String w){
		Integer wlen = w.length(),
				count = 1;

		for(int i = 0; i < wlen; i++){
			if(w.charAt(i) == ' ')
				count++;
		}

		return count;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in,"UTF-8");

		String word = sc.nextLine();

		while(strcmp(word,"FIM") != 0){
			System.out.println(countWord(word));
			word = sc.nextLine();
		}

		sc.close();
	}
}
