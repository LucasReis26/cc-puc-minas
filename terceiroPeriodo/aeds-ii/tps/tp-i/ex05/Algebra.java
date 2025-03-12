package ex05;

import java.util.Scanner;

public class Algebra{

	public static void main(String[] args){

		char response = ' ';
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
			while(countExpression > 0){
				for(int i = 0; i < belength; i++){
					if(cbExp[i] >= 65 && cbExp[i] <= 90){
						int charValue = cbExp[i];
						cbExp[i] = (char)('0' + binaryValues[charValue - 65]);
					}else if(cbExp[i] == '(' && (cbExp[i + 1] == '0' || cbExp[i + 1] == '1')){

						//Movimentações NOT
						if(cbExp[i - 1] == 't'){
							countExpression--;
							// System.out.println("Estou realizando o not");
							if(cbExp[i + 1] == '0')
								cbExp[i - 3] = '1';
							else
								cbExp[i - 3] = '0';

							belength = belength - 5;
							for(int j = i - 2; j < belength; j++){
								cbExp[j] = cbExp[j + 5];
							}

						//Movimentações AND
						}else if(cbExp[i - 1] == 'd'){
							int countLetters = 1;
							for(int j = i; cbExp[j] != ')'; j++){
								if(cbExp[j] == ',')
									countLetters++;
							}
							int[] values = new int[countLetters];
							int valid = 0;
							int iteracoes = i + 1 + 5 + ((countLetters - 2) * 4);
							for(int j = i + 1; j < iteracoes; j++){
								// System.out.println(cbExp[j]);
								if(cbExp[j] == '0' || cbExp[j] == '1'){
									switch (cbExp[j]){
										case '0':
											values[valid] = 0;
											break;
										case '1':
											values[valid] = 1;
											break;
									}
									valid++;
								}
							}
							if(valid == countLetters){
								countExpression--;
								// System.out.println("Estou realizando o and");
								boolean torf = false;
								for(int j = 0; j < values.length; j++){
									if(values[j] == 0){
										torf = false;
										j = values.length;
									}else
										torf = true;
								}
								if(torf)
									cbExp[i - 3] = '1';
								else
									cbExp[i - 3] = '0';
								belength = belength - (9 + ((values.length - 2) * 4));
								for(int j = i - 2; j < belength; j++){
									cbExp[j] = cbExp[j + (9 + ((values.length - 2) * 4))];
								}
							}

						//Movimentações OR
						}else if(cbExp[i - 1] == 'r'){
							int countLetters = 1;
							for(int j = i; cbExp[j] != ')'; j++){
								if(cbExp[j] == ',')
									countLetters++;
							}
							int[] values = new int[countLetters];
							int valid = 0;
							int iteracoes = i + 1 + 5 + ((countLetters - 2) * 4);
							for(int j = i; j < iteracoes; j++){
								if(cbExp[j] == '0' || cbExp[j] == '1'){
									switch (cbExp[j]){
										case '0':
											values[valid] = 0;
											break;
										case '1':
											values[valid] = 1;
											break;
									}
									valid++;
								}
							}
							if(valid == countLetters){
								countExpression--;
								// System.out.println("Estou realizando o or");
								boolean torf = false;
								for(int j = 0; j < values.length; j++){
									if(values[j] == 0){
										torf = false;
									}else{
										torf = true;
										j = values.length;
									}
								}
								if(torf)
									cbExp[i - 2] = '1';
								else
									cbExp[i - 2] = '0';
								
								belength = belength - (8 + ((values.length - 2) * 4));
								for(int j = i - 1; j < belength; j++){
									cbExp[j] = cbExp[j + (8 + ((values.length - 2) * 4))];
								}
							}
						}
					}
				}
					// bExpression = new String(cbExp);
					// System.out.println(bExpression);
					response = cbExp[0];
			}

			bExpression = new String(cbExp);

			// System.out.println("há " + countExpression + " partes nessa expressão");
			System.out.println(response);
			entryNum = sc.nextInt();
		}

		sc.close();
	}
}
