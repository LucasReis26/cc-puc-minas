package ex05;

import java.util.Scanner;

public class Algebra{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		Integer entryNum = sc.nextInt();

		while(entryNum != 0){

			Integer[] binaryValues = new Integer[entryNum];

			for(int i = 0; i < entryNum; i++){

				binaryValues[i] = sc.nextInt();

			}
			sc.nextLine();

			String bExpression = sc.nextLine();

			Integer countExpression = 0;

			Integer belength = bExpression.length();

			for(int i = 0; i < belength; i++)
				if(bExpression.charAt(i) == '(')
					countExpression++;
			
			char[] cbExp = bExpression.toCharArray();

			for(int i = 0; i < belength; i++){
				if(cbExp[i] >= 65 && cbExp[i] <= 90){
					int charValue = cbExp[i];
					cbExp[i] = (char)('0' + binaryValues[charValue - 65]);
				}
			}

			bExpression = new String(cbExp);

			System.out.println("há " + countExpression + " partes nessa expressão");
			System.out.println(bExpression);
		}

		sc.close();
	}
}
