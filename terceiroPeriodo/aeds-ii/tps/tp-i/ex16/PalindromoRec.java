// package ex16;

import java.util.Scanner;

public class PalindromoRec{
	public static Integer strcmp(String w1, String w2){
		Integer wlen1 = w1.length(),
				wlen2 = w2.length(),
				min = (wlen1 < wlen2) ? wlen1 : wlen2,
				resp = 0;

		for(int i = 0; i < min; i++){
			if(w1.charAt(i) < w2.charAt(i)){
				resp = -1;
				i = min;
			}else if(w1.charAt(i) > w2.charAt(i)){
				resp = 1;
				i = min;
			}
		}
		if(resp == 0 && wlen1 != wlen2){
			resp = (wlen1 < wlen2) ? -1 : 1;
		}
		
		return resp;
	}
	public static boolean ehPalindromo(String w,Integer esq, Integer dir){
		boolean resp = false;
		if(esq >= dir){
			resp = true;
		}else if(w.charAt(esq) == w.charAt(dir)){
			resp = ehPalindromo(w,++esq,--dir);
		}

		return resp;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in,"UTF-8");

		String w = sc.nextLine();
		while(strcmp(w,"FIM") != 0){
			Integer wlen = w.length();
			if(ehPalindromo(w,0,wlen - 1))
				System.out.println("SIM");
			else
				System.out.println("NAO");
			w = sc.nextLine();
		}

		sc.close();
	}
}
