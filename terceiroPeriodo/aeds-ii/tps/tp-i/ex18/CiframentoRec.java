package ex18;

import java.util.Scanner;

public class CiframentoRec{
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
	public static char[] toCharArray(String w){
		Integer wlen = w.length();
		char[] wchar = new char[wlen];

		for(int i = 0; i < wlen; i++)
			wchar[i] = w.charAt(i);

		return wchar;
	}
	public static String cifra(char[] wchar, Integer i, Integer e){
		String resp = "";
		if(i == wchar.length)
			resp = new String(wchar);
		else if(wchar[i] != '\uFFFD'){
			wchar[i] = (char) (wchar[i] + 3);
			resp = cifra(wchar,i + 1,e);
		}
		else{
			resp = cifra(wchar,i + 1,e);
		}
		return resp;

	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in,"UTF-8");

		String w = sc.nextLine();

		while(strcmp(w,"FIM") != 0){

			char[] wchar = toCharArray(w);
			Integer wlen = wchar.length;
			System.out.println(cifra(wchar,0,wlen));

			w = sc.nextLine();
		}

		sc.close();
	}
}
