// package ex11;

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
				count = 0,
				wlen = w.length();

		char[] wchar = new char[wlen];

		for(int i = 0, l = 0; i < wlen; i++, l++){
			if(l == 0){
				wchar[l] = w.charAt(i);
				count++;
			}else{
				Boolean found = false;
				for(int j = 0; j < count; j++){
					if(w.charAt(i) == wchar[j]){
						if(maior < count){
							maior = count;
						}
						found = true;
						j = count;
						count = 0;
					}
				}
				if(!found){
					wchar[l] = w.charAt(i);
					count++;
				}
			}
		}
		if(maior < count)
			maior = count;

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
