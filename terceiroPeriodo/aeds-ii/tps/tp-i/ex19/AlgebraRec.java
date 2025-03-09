// package ex19;

import java.util.Scanner;

public class AlgebraRec{
	public static void putValues(char[] cExpression, Integer[] varValues, Integer i, Integer expLen, Integer[] expQuant){
		// System.out.println("Put values " + cExpression[i] + i);
		if(i == expLen)
			return;
		else if(cExpression[i] >= 'A' && cExpression[i] <= 'Z'){
			// System.out.println("Putting values");
			int position = ((int) cExpression[i]) - 65;
			cExpression[i] = ((char) (varValues[position] + 48));
			putValues(cExpression, varValues, ++i, expLen,expQuant);
		}else{
			if(cExpression[i] == '('){
				// System.out.println("Incrementei expressão" + cExpression[i]);
				expQuant[0]++;
				putValues(cExpression, varValues, ++i, expLen, expQuant);
			}else
				// System.out.println("Não incrementei expressão " + cExpression[i]);
			putValues(cExpression, varValues, ++i, expLen,expQuant);
		}
	}
	public static char[] toCharArray(String expression,char[] cExpression, Integer i, Integer len){
		// System.out.println("Doing conversion");
		char[] resp = {' '};
		if(i == len)
			resp = cExpression;
		else{
			cExpression[i] = expression.charAt(i);
			resp = toCharArray(expression,cExpression,++i,len);
		}
		return resp;
	}
	public static char[] toCharArray(String expression){
		// System.out.println("Starting conversion");
		Integer expLen = expression.length();
		char[] cExpression = new char[expLen];
		return toCharArray(expression, cExpression, 0, expLen);
	}
	public static void clearExpression(char[] cExpression, Integer i, Integer[] len, Integer shift){
		// System.out.println(i + "\t" + len[0] + "\t" + shift + "\t" + cExpression.length);
		if(i < len[0]){
			cExpression[i] = cExpression[i + shift];
			// System.out.println(new String(cExpression));
			clearExpression(cExpression, ++i, len, shift);

		}else if(i < cExpression.length){
			cExpression[i] = '\0';
			clearExpression(cExpression,++i,len,shift);
		}
	}
	public static void not(char[] cExpression,Integer i,Integer[] len){
		// System.out.println("Realizando o not");


		if(cExpression[i+1] == '0')
			cExpression[i - 3] = '1';
		else
			cExpression[i - 3] = '0';

		len[0] -= 5;

		clearExpression(cExpression, i - 2, len, 5);
		// System.out.println(new String(cExpression));

	}
	public static boolean verify(char[] cExpression, Integer i){
		// System.out.println("Estou verificando caracteres " + cExpression[i]);
		boolean resp = false;
		if(cExpression[i] == ')')
			resp = true;
		else if(cExpression[i] != '0' && cExpression[i] != '1' && cExpression[i] != ' ' && cExpression[i] != ','){
			// System.out.println("Este é um caractere falso " + cExpression[i]);
			resp = false;
		}
		else{
			// System.out.println("Caractere verdadeiro " + cExpression[i]);
			resp = verify(cExpression, ++i);
		}

		return resp;
	}
	public static int countShift(char[] cExpression, Integer i, Integer count){
		if(cExpression[i] != ')'){
			count = countShift(cExpression, ++i, ++count);
		}
		return count;
	}
	public static int countValues(char[] cExpression, Integer i, Integer count){
		if(cExpression[i] != ')')
			if(cExpression[i] == '0' || cExpression[i] == '1')
				count = countValues(cExpression, ++i, ++count);
			else
				count = countValues(cExpression, ++i, count);
		return count;
	}
	public static void getValues(Integer[] values, char[] cExpression, Integer i, Integer j){
		// System.out.println("values["+j+"] = "+values[j]+" cExpression["+i+"] = "+cExpression[i]);
		if(cExpression[i] == ')'){
			return;
		}else{
			if(cExpression[i] == '0'){
				values[j++] = 0;
				// System.out.println("0 detectado : values["+(j-1)+"] ="+values[j-1]);
			}
			else if(cExpression[i] == '1'){
				values[j++] = 1;
				// System.out.println("1 detectado : values["+(j-1)+"] ="+values[j-1]);
			}
			getValues(values,cExpression, ++i, j);
		}	
	}
	public static boolean verifyAnd(Integer[] values, Integer len, Integer i){
		// System.out.println("values[" + i + "] =" + values[i] + " len = " + len);
		boolean resp = false;
		if(i == len)
			resp = true;
		else if(values[i] == 0)
			resp = false;
		else
			resp = verifyAnd(values, len, ++i);

		return resp;
	}
	public static boolean verifyOr(Integer[] values, Integer len, Integer i){
		// System.out.println("values[" + i + "] =" + values[i] + " len = " + len);
		boolean resp = false;
		if(i >= len){
			// System.out.println("i maior que len");
			resp = false;
		}else if(values[i] == 1){
			// System.out.println("Encontrei 1");
			resp = true;
		}else{
			// System.out.println("Não encontrei nem i maior nem 1");
			resp = verifyOr(values, len, ++i);
		}
		// System.out.println("Retornando");
		return resp;
	}

	public static void and(char[] cExpression,Integer i,Integer[] len, Integer shift){
		// System.out.println("Realizando o and");
		Integer quantValues = countValues(cExpression, i + 1 , 0);
		Integer[] values = new Integer[quantValues];
		getValues(values,cExpression,i,0);
		if(verifyAnd(values, values.length, 0))
			cExpression[i - 3] = '1';
		else
			cExpression[i - 3] = '0';
		len[0] -= shift;
		clearExpression(cExpression, i - 2, len, shift);
		// System.out.println(new String(cExpression));

	}
	public static void or(char[] cExpression, Integer i, Integer[] len, Integer shift){
		// System.out.println("Realizando o or");
		Integer quantValues = countValues(cExpression, i + 1 , 0);
		Integer[] values = new Integer[quantValues];
		getValues(values,cExpression,i,0);
		if(verifyOr(values, values.length, 0))
			cExpression[i - 2] = '1';
		else
			cExpression[i - 2] = '0';
		len[0] -= shift;
		clearExpression(cExpression, i - 1, len, shift);
		// System.out.println(new String(cExpression));

	}
	public static void scanExp(char[] cExpression, Integer i, Integer[] len, Integer[] quant){
		// System.out.println("cExpression[" + i +"] = " + cExpression[i] +" len = " + len[0] );
		if(i >= len[0]){
			return;
		}
		else if(cExpression[i] == '(' && (cExpression[i+1] == '0' || cExpression[i + 1] == '1')){
			if(cExpression[i - 1] == 't'){
				quant[0]--;
				// System.out.println("Uma expressao realizada faltam " + quant[0]);
				not(cExpression,i,len);
			}else if(cExpression[i - 1] == 'd' && verify(cExpression, i+1)){
				quant[0]--;
				// System.out.println("Uma expressao realizada faltam " + quant[0]);
				Integer shift = 4 + countShift(cExpression, i+1, 0);
				and(cExpression,i,len,shift);
			}else if(cExpression[i - 1] == 'r' && verify(cExpression, i+1)){
				quant[0]--;
				Integer shift = 3 + countShift(cExpression, i+1, 0);
				or(cExpression,i,len,shift);
			}else{
				scanExp(cExpression,++i,len,quant);
			}
		}else{
			scanExp(cExpression,++i,len,quant);
		}
		return;
	}
	public static Integer algebraBool(char[] cExpression, Integer[] quant, Integer[] len){
		Integer resp = -1;
		if(quant[0] == 0)
			resp = ((int) cExpression[1]) - 48; 
		else if(resp == -1){
			scanExp(cExpression, 0, len, quant);
			resp = algebraBool(cExpression, quant, len);
		}
		return resp;
	}
	public static Integer algebraBool(String expression, Integer[] varValues){
		Integer resp = 0;

		Integer[] expQuant = {0};
		char[] cExpression = toCharArray(expression);
		// System.out.println("Tamanho do array de char " + cExpression.length);
		Integer[] len = {cExpression.length};
		putValues(cExpression,varValues,0,cExpression.length,expQuant);
		// System.out.println(new String(cExpression));
		System.out.println(algebraBool(cExpression,expQuant,len));
		// System.out.println("A expressão acima tem: "+ expQuant[0] + " pendencias." );
		return resp;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Integer varQuant = sc.nextInt();

		while(varQuant != 0){
			Integer[] varValues = new Integer[varQuant];

			for(int i = 0; i < varQuant; i++){
				varValues[i] = sc.nextInt();
			}

			// sc.nextLine();

			String bExpression = sc.nextLine();

			algebraBool(bExpression, varValues);

			varQuant = sc.nextInt();
		}

		sc.close();
	}
}
