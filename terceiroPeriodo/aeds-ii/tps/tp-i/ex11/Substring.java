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
		int[] freq = new int[128];
		for(int i = 0; i < 128; i++){
			freq[i] = -1;
		}
		int len = w.length(),
			maxLen = 0,
			left = 0;

		for(int right = 0; right < len; right++){
			freq[w.charAt(right)]++;

			while(freq[w.charAt(right)] > 0){
				freq[w.charAt(left)]--;

				left++;
			}

			maxLen = (maxLen < (right - left + 1)) ? (right - left + 1) : maxLen;
		}

		return maxLen;
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
