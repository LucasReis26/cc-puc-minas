// package ex08;

import java.util.Scanner;

public class Soma{
	public static Integer somaDigitos (Integer number){
		Integer resp = 0;

		if(number < 10)
			resp = number;
		else
			resp = somaDigitos(number / 10) + (number % 10);

		return resp;
	}
	public static Integer charToNumber(char number){
		Integer resp = 0;
		switch(number){
			case '0':
				resp = 0;
				break;
			case '1':
				resp = 1;
				break;
			case '2':
				resp = 2;
				break;
			case '3':
				resp = 3;
				break;
			case '4':
				resp = 4;
				break;
			case '5':
				resp = 5;
				break;
			case '6':
				resp = 6;
				break;
			case '7':
				resp = 7;
				break;
			case '8':
				resp = 8;
				break;
			case '9':
				resp = 9;
				break;
		}
		return resp;
	}
	public static Integer pow(Integer num1,  Integer num2){
		Integer pot = num1;
		for(int i = 1; i < num2; i++){
			num1 *= pot;
		}
		return num1;
	}
	public static Integer strcmp(String word1, String word2){
		Integer wlength1 = word1.length(),
				wlength2 = word2.length(),
				minor = (wlength1 < wlength2) ? wlength1 : wlength2,
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
		if(resp == 0 && wlength1 != wlength2){
			if(wlength1 < wlength2)
				resp = -1;
			else
				resp = 1;
		}
		return resp;
	}
	public static Integer stringToNumber(String word){
		Integer resp = 0;
		Integer decimalCount = 0;
		Integer wlength = word.length();
		for(int i = wlength - 1; i >= 0; i--){
			if(i == wlength - 1){
				resp += charToNumber(word.charAt(i));
				// System.out.println("Numero na posicao " + word.charAt(i));
				// System.out.println("Somei " + charToNumber(word.charAt(i)));
				decimalCount++;
			}else{
				resp += charToNumber(word.charAt(i)) * pow(10,decimalCount);
				// System.out.println("Numero na posicao " + word.charAt(i));
				// System.out.println("Somei " + (charToNumber(word.charAt(i)) * pow(10,decimalCount)));
				decimalCount++;
			}
		}
		// System.out.println("Numero resultante: " + resp);
		return resp;
	}
	public static Boolean verifyInteger(String word){
		boolean resp = true; 
		Integer wlength = word.length();
		for(int i = 0; i < wlength; i++){
			if(word.charAt(i) < 48 && word.charAt(i) > 57){
				resp = false;
				i = wlength;
			}
		}
		return resp;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String possibleNumber = sc.nextLine();

		while(strcmp(possibleNumber,"FIM") != 0){

			Integer number = 0;
			if(verifyInteger(possibleNumber))
				number = stringToNumber(possibleNumber);
			else{
				System.out.println("Não é um número");
				return;
			}
			System.out.println(somaDigitos(number));
			possibleNumber = sc.nextLine();
		}

		sc.close();
	}
}
