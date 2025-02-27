// package ex07;

import java.util.Scanner;

public class Inversao{
	public static int strcmp(String word1, String word2){
		Integer wlength1 = word1.length(),
				wlength2 = word2.length(),
				minor = (wlength1 < wlength2) ? wlength1 : wlength2,
				resp = 0;
		for(int i = 0; i < minor; i++){
			if(word1.charAt(i) > word2.charAt(i)){
				resp = 1;
				i = minor;
			}else if(word1.charAt(i) < word2.charAt(i)){
				resp = -1;
				i = minor;
			}
		}
		if(resp == 0 && wlength1 != wlength2){
			if(wlength1 > wlength2)
				resp = 1;
			else
				resp = -1;
		}
		return resp;
	}

	
	public static char[] tcharr(String word){
		Integer wlength = word.length();
		char[] cword = new char[wlength];
		for(int i = 0; i < wlength; i++){
			cword[i] = word.charAt(i);
		}
		// System.out.print("String em char: ");
		// for(int i = 0; i < wlength; i++){
		// 	System.out.print(cword[i]);
		// }
		// System.out.println();
		return cword;
	}
	public static String inverseString(String word){
		char[] cword = tcharr(word);
		Integer wlength = word.length();
		for(int i = 0, j = wlength - 1 ; i < wlength / 2; i++, j--){
			char tmp;
			// System.out.println("Caractere " + i + " = " + cword[i]);
			// System.out.println("Caractere " + j + " = " + cword[j]);
			tmp = cword[i];
			cword[i] = cword[j];
			cword[j] = tmp;
		}
		// System.out.print("String invertida: ");
		// for(int i = 0; i < wlength; i++){
		// 	System.out.print(cword[i]);
		// }
		// System.out.println();
		return new String(cword);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();

		while(strcmp(word,"FIM") != 0){
			System.out.println(inverseString(word));
			word = sc.nextLine();
		}

		sc.close();
	}
}
