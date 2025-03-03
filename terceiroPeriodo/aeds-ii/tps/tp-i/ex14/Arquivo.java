// package ex14;

import java.util.Scanner;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Arquivo{
	public static void main(String[] args) throws IOException{
		Scanner sc =  new Scanner(System.in);
		// String filePath = "/home/cinema/faculdade/cc-puc-minas/terceiroPeriodo/aeds-ii/tps/tp-i/ex14/numeros.txt";
		RandomAccessFile raf = new RandomAccessFile("numeros.txt", "rw");

		Integer num = sc.nextInt();

		for(int i = 0; i < num; i++){
			Double numFile = sc.nextDouble();
			raf.writeDouble(numFile);
		}

		for(int i = num - 1; i >= 0; i--){
			raf.seek(i * (Double.SIZE / 8));
			Double numFile = raf.readDouble();
			if(numFile % 1 == 0)
				System.out.printf("%.0f\n",numFile);
			else
				System.out.println(numFile);
		}	

		sc.close();
	}
}
