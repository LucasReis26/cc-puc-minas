// package ex01;

import java.util.Scanner;

public class Palindromo{

	static Integer strcmp(String word1, String word2){

		int len1 = word1.length(),
			len2 = word2.length(),
			end = (len1 > len2) ? len2 : len1,
			resp = 0;

		for(int i = 0; i < end; i++){
			if(word1.charAt(i) > word2.charAt(i)){
				resp = 1;
				i = end;
			}else if(word1.charAt(i) < word2.charAt(i)){
				resp = -1;
				i = end;
			}
		}

		if(resp == 0 && len1 != len2){
			if(len1 > len2)
				resp = 1;
			else
				resp = -1;
		}

		return resp;
	}

    static Boolean ehPalindromo(String word){

        Boolean resp = false;

        for(int i = 0, j = word.length() - 1; i < word.length(); i++, j--){
            if(word.charAt(i) == word.charAt(j)){
                resp = true;
            }else{
                i = word.length();
                resp = false;
            }
        }

        return resp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

		while(strcmp(word,"FIM") != 0){
			if(ehPalindromo(word)){
				System.out.println("SIM");
			}else{
				System.out.println("NAO");
			}
			word = sc.nextLine();
		}


        sc.close();        
    }
}
