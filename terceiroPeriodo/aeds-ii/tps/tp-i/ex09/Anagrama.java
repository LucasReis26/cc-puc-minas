// package ex09;

import java.util.Scanner;

public class Anagrama{
	public static Integer strcmp(String word1, String word2){
		Integer wlen1 = word1.length(),
				wlen2 = word2.length(),
				minor = (wlen1 < wlen2) ? wlen1 : wlen2,
				resp = 0;
		for(int i = 0; i < minor; i++){
			if(word1.charAt(i) < word2.charAt(i)){
				resp = -1;
				i = minor;
			}else if(word1.charAt(i) > word2.charAt(i)){
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
	public static Character toLowerCase (Character wchar){

		if(wchar >= 65 && wchar <= 90){
			wchar = (char) (wchar + 32);
		}

		return wchar;
	}
	public static Boolean verifyAnagram(String word1, String word2){

		Integer wlen1 = word1.length(),
				wlen2 = word2.length();

		Boolean resp = true;

		for(int i = 0; i < wlen1; i++){
			Boolean find = false;
			for(int j = 0; j < wlen2; j++){
				Character alvo = toLowerCase(word1.charAt(i));
				if(alvo == toLowerCase(word2.charAt(j)))
					find = true;
			}
			if(!find){
				resp = false;
				i = wlen1;
			}
		}

		return resp;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in,"UTF-8");

		String word1 = sc.next();

		while(strcmp(word1,"FIM") != 0){
			sc.next();
			String word2 = sc.next();

			if(verifyAnagram(word1,word2))
				System.out.println("SIM");
			else
				System.out.println("NÃO");

			word1 = sc.next();
		}

		sc.close();
	}
}
