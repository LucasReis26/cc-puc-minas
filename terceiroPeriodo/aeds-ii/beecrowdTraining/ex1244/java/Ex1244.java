package ex1244.java;
import java.util.Scanner;

public class Ex1244{

	public static Integer count(String w){
		Integer count = 1;
		Integer len = w.length();
		for(int i = 0; i < len; i++){
			if(w.charAt(i) == ' ')
				count++;
		}
		return count;
	}

	public static String[] separe(String w, int x){
		String[] resp = new String[x];
		Integer len = w.length(),
				strlen = 0;
		char[] charArray = new char[255];
		for(int i = 0, j = 0, k = 0; i < len; i++){
			if(w.charAt(i) != ' '){
				charArray[j] = w.charAt(i);
				j++;
				strlen++;
				if(i == (len - 1))
					resp[k] = new String(charArray,0,strlen);
			} else {
				resp[k] = new String(charArray,0,strlen);
				strlen = 0;
				j = 0;
				k++;
			}
		}
		return resp;
	}

	public static void organiza(String[] arr){
		Integer arrayLen = arr.length;

		for(int i = 0; i < arr.length - 1; i++){
			boolean swapped = false;
			for(int j = 0; j < arr.length - i - 1; j++){
				if(arr[j + 1].length() > arr[j].length()){

					String tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					swapped = true;
				}
			}
			if(!swapped)
				i = arr.length;
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Integer numCases = sc.nextInt();
		sc.nextLine();

		for(int i = 0; i < numCases; i++){
			String line = sc.nextLine();
			Integer numWord = count(line);
			String[] words = separe(line,numWord);
			organiza(words);
			for(int j = 0; j < numWord; j++){
				if(j < numWord - 1){
					System.out.print(words[j] + " ");
				}else{
					System.out.println(words[j]);
				}
			}
		}

		sc.close();
	}
}
