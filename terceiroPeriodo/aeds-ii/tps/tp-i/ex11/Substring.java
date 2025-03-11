package ex11;

import java.util.Scanner;

public class Substring{
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
			if(wlen1 < wlen2)
				resp = -1;
			else
				resp = 1;
		}
		return resp;
	}
	public static Integer subCount(String w){
		Integer maior = 0,
				count = 1,
				wlen = w.length(),
				lastCharacter = 0;
		boolean notFound = false;

		char[] wchar = w.toCharArray();

		for(int i = 0; i < wchar.length; i++){
			for(int j = i + 1; j < wchar.length; j++){
				if(w.charAt(i) != w.charAt(j)){
					count++;
					lastCharacter = i;
					notFound = true;
				}else{
					i = lastCharacter;
					notFound =false;
					if(maior < count)
						maior = count;
					j = wlen;
					count = 1;
				}
				
			}
			if(notFound){
				maior = (maior < count) ? count : maior;
				i = wchar.length;
			}
		}
		maior = (maior < count) ? count : maior;


		return maior;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in,"UTF-8");

		String w = sc.nextLine();

		while(strcmp(w,"FIM") != 0){
			System.out.println(subCount(w));
			w = sc.nextLine();
		}

		sc.close();
	}
}
