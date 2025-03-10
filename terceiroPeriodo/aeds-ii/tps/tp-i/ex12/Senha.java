// package ex12;

import java.util.Scanner;

public class Senha{
	public static int strcmp(String w1, String w2){
		int wlen1 = w1.length(),
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

		if(resp == 0 && wlen1 != wlen2)
			resp = (wlen1 < wlen2) ? -1 : 1;

		return resp;
	}
	public static boolean verificaQuantidade(String w){
		boolean resp = false;

		if(w.length() >= 8)
			resp = true;

		return resp;
	}
	public static boolean verificaMaiuscula(String w){
		boolean resp = false;
		int wlen = w.length();

		for(int i = 0; i < wlen; i++){
			if(w.charAt(i) >= 'A' && w.charAt(i) <= 'Z'){
				resp = true;
				i = wlen;
			}
		}

		return resp;
	}
	public static boolean verificaEspecial(String w){
		boolean resp = false;
		int wlen = w.length();

		for(int i = 0; i < wlen; i++){
			if((w.charAt(i) >= 33 && w.charAt(i) <= 47)
				||
				(w.charAt(i) >= 58 && w.charAt(i) <= 64)
				||
				(w.charAt(i) >= 91 && w.charAt(i) <= 96)
				||
				(w.charAt(i) >= 123 && w.charAt(i) <= 126)){

				resp = true;
				i = wlen;

			}
		}

		return resp;
	}

	public static boolean verificaMinuscula(String w){
		boolean resp = false;

		int wlen = w.length();

		for(int i = 0; i < wlen; i++){
			if(w.charAt(i) >= 'a' && w.charAt(i) <= 'z'){
				resp = true;
				i = wlen;
			}
		}

		return resp;
	}

	public static boolean verificaNumero(String w){
		boolean resp = false;
		int wlen = w.length();

		for(int i = 0; i < wlen; i++){
			if(w.charAt(i) >= '0' && w.charAt(i) <= '9'){
				resp = true;
				i = wlen;
			}
		}

		return resp;
	}
	public static boolean verificaSenha(String w){
		boolean resp = false;

		if(verificaQuantidade(w) && verificaMaiuscula(w) && verificaEspecial(w) && verificaMinuscula(w) && verificaNumero(w))
			resp = true;

		return resp;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String w = sc.nextLine();

		while(strcmp(w,"FIM") != 0){

			if(verificaSenha(w))
				System.out.println("SIM");
			else
				System.out.println("NAO ");

			w = sc.nextLine();
		}

		sc.close();
	}
}
