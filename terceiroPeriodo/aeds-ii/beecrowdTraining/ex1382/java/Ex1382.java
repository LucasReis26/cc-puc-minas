package ex1382.java;

import java.util.Scanner;

public class Ex1382{

	public static Integer ordena(Integer[] arr){

		Integer len = arr.length,
				count = 0;

		for(int i = 0; i < len - 1; i++){

			Integer menor = i;

			for(int j = i + 1; j < len; j++){

				if(arr[menor] > arr[j]){

					menor = j;
				}
			}

			Integer tmp = arr[i];
			arr[i] = arr[menor];
			arr[menor] = tmp;
			if(menor != i)
				count++;
		}

		return count;

	}

	public static void preenche(Integer[] arr, Scanner sc){
		Integer len = arr.length;

		for(int i = 0; i < len; i++){

			arr[i] = sc.nextInt();
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Integer instances = sc.nextInt();

		for(int i = 0; i < instances; i++){

			Integer range = sc.nextInt();

			Integer[] array = new Integer[range];

			preenche(array,sc);

			System.out.println(ordena(array));
		}

		sc.close();
	}
}
