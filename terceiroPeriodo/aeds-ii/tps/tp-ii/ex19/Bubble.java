package ex19;

import java.util.Random;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Bubble{
	public static void preencheArray(Integer array[], int len){
		Random random = new Random();
		random.setSeed(4);

		for(int i = 0; i < len; i++){
			array[i] = (Math.abs(random.nextInt()) % 100) + 1;
		}

	}

	public static void swap(Integer[] array, Integer a, Integer b){
		Integer aux = array[a];
		array[a] = array[b];
		array[b] = aux;
	}

	public static void bubblesort(Integer[] array, Integer len, File arquivo){
		try(FileWriter fw = new FileWriter(arquivo)){
			
			long inicio = System.currentTimeMillis();
			long mov = 0;
			long comp = 0;

			for(int i = 0; i < len - 1; i++){
				for(int j = 0; j < len - i - 1; j++){
					comp++;
					if(array[j + 1] < array[j]){
						mov++;
						swap(array,(j+1),j);
					}
				}
			}

			long fim = System.currentTimeMillis();
			long duracao = fim - inicio;

			fw.write(comp + "\t" + mov + "\t" + duracao);
			fw.flush();
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){


		File file100 = new File("./bubble_array100.txt");
		File file1000 = new File("./bubble_array1000.txt");
		File file10000 = new File("./bubble_array10000.txt");
		File file100000 = new File("./bubble_array100000.txt");

		Integer array100[] = new Integer[100];
		Integer array1000[] = new Integer[1000];
		Integer array10000[] = new Integer[10000];
		Integer array100000[] = new Integer[100000];

		preencheArray(array100,100);
		preencheArray(array1000,1000);
		preencheArray(array10000,10000);
		preencheArray(array100000,100000);

		bubblesort(array100, 100, file100);
		bubblesort(array1000, 1000, file1000);
		bubblesort(array10000, 10000, file10000);
		bubblesort(array100000, 100000, file100000);
	}
}
