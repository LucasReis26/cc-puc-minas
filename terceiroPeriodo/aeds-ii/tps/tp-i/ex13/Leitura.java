package ex13;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Leitura{
	public static String getHtml(String endereco){
		URL url;
		InputStream is = null;
		BufferedReader br;
		String resp = "", line;

		try {
			url = new URL(endereco);
			is = url.openStream();  // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				resp += line + "\n";
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 

		try {
			is.close();
		} catch (IOException ioe) {
			// nothing to see here

		}

		return resp;
	} 
	public static int strcmp(String w1, String w2){
		int len1 = w1.length(),
			len2 = w2.length(),
			minLen = (len1 < len2) ? len1 : len2,
			resp = 0;

		for(int i = 0; i < minLen; i++){
			if(w1.charAt(i) < w2.charAt(i)){
				resp = -1;
				i = minLen;
			}else if(w1.charAt(i) > w2.charAt(i)){
				resp = 1;
				i = minLen;
			}
		}

		if(resp == 0 && len1 != len2){
			resp = (len1 < len2) ? -1 : 1;
		}

		return resp;
	}
	public static void contarOcorrencias(String w, int[] dados){
		int len = w.length();
		for(int i = 0; i < len; i++){
			switch(w.charAt(i)){
				case 'a':
					dados[0]++;
					break;
				case 'e':
					dados[1]++;
					break;
				case 'i':
					dados[2]++;
					break;
				case 'o':
					dados[3]++;
					break;
				case 'u':
					dados[4]++;
					break;
				case 'á':
					dados[5]++;
					break;
				case 'é':
					dados[6]++;
					break;
				case 'í':
					dados[7]++;
					break;
				case 'ó':
					dados[8]++;
					break;
				case 'ú':
					dados[9]++;
					break;
				case 'à':
					dados[10]++;
					break;
				case 'è':
					dados[11]++;
					break;
				case 'ì':
					dados[12]++;
					break;
				case 'ò':
					dados[13]++;
					break;
				case 'ù':
					dados[14]++;
					break;
				case 'ã':
					dados[15]++;
					break;
				case 'õ':
					dados[16]++;
					break;
				case 'â':
					dados[17]++;
					break;
				case 'ê':
					dados[18]++;
					break;
				case 'î':
					dados[19]++;
					break;
				case 'ô':
					dados[20]++;
					break;
				case 'û':
					dados[21]++;
					break;
				case '<':
					if(w.charAt(i + 1) == 'b' && w.charAt(i + 2) == 'r' && w.charAt(i + 3) == '>'){
						dados[23]++;
					}
					else if(w.charAt(i + 1) == 't' && w.charAt(i + 2) == 'a' && w.charAt(i + 3) == 'b' && w.charAt(i + 4) == 'l' && w.charAt(i + 5) == 'e' && w.charAt(i + 6) == '>'){
						dados[24]++;
						dados[0]--;
						dados[1]--;
					}
					break;
			}
			char[] vogais = {'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'ã', 'ẽ', 'ĩ', 'õ', 'ũ', 'à', 'è', 'ì', 'ò', 'ò', 'ù', 'â', 'ê', 'î', 'ô', 'û'};
			int vogaisLen = vogais.length;

			boolean consoante = false;
			for(int j = 0; j < vogaisLen; j++){
				if(Character.toLowerCase(w.charAt(i)) != vogais[j] && Character.toLowerCase(w.charAt(i)) >= 97 && Character.toLowerCase(w.charAt(i)) <= 122)
					consoante = true;
				else{
					consoante = false;
					j = vogaisLen;
				}
			}

			if(consoante)
				dados[22]++;
		}
	}
	public static void main(String[] args){
		Scanner sc  = new Scanner(System.in,"UTF-8");

		String pageName = sc.nextLine();

		while(strcmp(pageName,"FIM") != 0){
			String url = sc.nextLine();

			String url_HTML = getHtml(url);

			int[] dados = new int[26];

			contarOcorrencias(url_HTML,dados);

			System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) á(%d) é(%d) í(%d) ó(%d) ú(%d) à(%d) è(%d) ì(%d) ò(%d) ù(%d) ã(%d) õ(%d) â(%d) ê(%d) î(%d) ô(%d) û(%d) consoante(%d) <br>(%d) <table>(%d) %s\n",dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8], dados[9], dados[10], dados[11], dados[12], dados[13], dados[14], dados[15], dados[16], dados[17], dados[18], dados[19], dados[20], dados[21], dados[22], dados[23], dados[24], pageName);

			pageName = sc.nextLine();
		}

		sc.close();
	}
}
