// package ex20;

import java.util.Scanner;

public class IsRec{
	//Função pra comparar duas strings;
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
	public static char toLowerCase(char a){
		char resp = ' ';
		if(a >= 97 && a <= 122)
			resp = a;
		else if(a >= 65 && a <=90)
			resp = (char) (a + 32);
		return resp;
	}
	public static boolean isVogal (String w,Integer i, Integer len){
		char[] vogais = {'a','e','i','o','u'};
		Boolean resp = false;
		char lowerChar = ' ';
		if(i < len){
			lowerChar = toLowerCase(w.charAt(i));
		}
		if(i == len)
			resp = true;
		else if(lowerChar >= 97 && lowerChar <= 122){
			boolean temVogal = false;
			for(int j = 0; j < vogais.length; j++){
				if(lowerChar == vogais[j]){
					temVogal = true;
					j = vogais.length;
				}
			}
			if(temVogal == false)
				resp = false;
			else
				resp = isVogal(w,i + 1,len);
		}
		return resp;
	}
	public static boolean isConsoante (String w,Integer i, Integer len){
		char[] vogais = {'a','e','i','o','u'};
		Boolean resp = false;
		char lowerChar = ' ';
		if(i < len){
			lowerChar = toLowerCase(w.charAt(i));
		}
		if(i == len)
			resp = true;
		else if(lowerChar >= 97 && lowerChar <= 122){
			boolean temConsoante = false;
			for(int j = 0; j < vogais.length; j++){
				if(lowerChar != vogais[j]){
					temConsoante = true;
				}else{
					temConsoante = false;
					j = vogais.length;
				}
			}
			if(temConsoante == false)
				resp = false;
			else
				resp = isConsoante(w,i + 1,len);
		}
		return resp;
	}
	public static boolean isInteiro(String w, Integer i, Integer len){
		boolean resp = false;

		if(i == len)
			resp = true;
		else if(w.charAt(i) >= '0' && w.charAt(i) <= '9')
			resp = isInteiro(w,++i,len);
		
		return resp;
		
	}
	public static boolean isReal(String w, Integer i, Integer len,Integer dp){
		boolean resp = false;
		
		if(i == len)
			if(dp < 2)
				resp = true;
			else
				resp = false;
		else if(w.charAt(i) == '.' || w.charAt(i) == ',')
			resp = isReal(w,i + 1,len,dp + 1);
		else if(w.charAt(i) >= '0' && w.charAt(i) <= '9')
			resp = isReal(w,++i,len,dp);
		
		return resp;
		
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in,"UTF-8");

		String w = sc.nextLine();

		while(strcmp(w,"FIM") != 0){
			if(isVogal(w,0,w.length()))
				System.out.print("SIM");
			else
				System.out.print("NAO");
			if(isConsoante(w,0,w.length()))
				System.out.print(" SIM");
			else
				System.out.print(" NAO");
			if(isInteiro(w,0,w.length()))
				System.out.print(" SIM");
			else
				System.out.print(" NAO");
			if(isReal(w,0,w.length(),0))
				System.out.println(" SIM");
			else
				System.out.println(" NAO");
			w = sc.nextLine();
		}

		sc.close();
	}
}
