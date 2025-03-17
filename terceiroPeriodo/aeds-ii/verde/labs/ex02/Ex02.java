// package ex02;

import java.util.Scanner;

public class Ex02{
	public static void inversePrint(int i){
		while(i > 9){
			System.out.print(i % 10);
			i /= 10;
		}
		System.out.print(i);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);


		while(sc.hasNextInt()){
			int n1 = sc.nextInt(),
				n2 = sc.nextInt();

			for(int i = n1; i <= n2; i++){
				System.out.print(i);
			}

			for(int i = n2; i >= n1; i--){
				if(i > 9){
					inversePrint(i);	
				}else if(i < 10){
					System.out.print(i);
				}
			}

			System.out.println();
		}

		sc.close();
	}
}
