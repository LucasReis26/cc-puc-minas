package ex13;

import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;

public class Leitura{
	public static int strcmp(String w1, String w2){
		int wlen1 = w1.length(),
			wlen2 = w2.length(),
			minlen = (wlen1 < wlen2) ? wlen1 : wlen2,
			resp = 0;

		for(int i = 0; i < minlen; i++){
			if(w1.charAt(i) < w2.charAt(i)){
				resp = -1;
				i = minlen; //Stop loop
			}else if(w1.charAt(i) > w2.charAt(i)){
				resp = 1;
				i = minlen; //Stop loop
			}
		}
		if(resp == 0 && wlen1 != wlen2){
			resp = (wlen1 < wlen2) ? -1 : 1;
		}

		return resp;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String pageName = sc.nextLine();

		while(strcmp(pageName,"FIM") != 0){

			String urlString = sc.nextLine();

			URL url = new URL(urlString);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			InputStream inputStream = connection.getInputStream();

			Scanner scanner = new Scanner(inputStream);
			StringBuilder content = new StringBuilder();
			while(scanner.hasNext()){
				content.append(scanner.nextLine()).append('\n');
			}
			scanner.close();
			System.out.println(content.toString());

			pageName = sc.nextLine();
		}

		sc.close();
	}
}
