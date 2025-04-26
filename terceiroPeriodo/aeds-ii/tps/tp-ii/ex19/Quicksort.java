package ex19;

import java.util.Random;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Quicksort{
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

	public static void quicksortrec(Integer[] array, Integer esq, Integer dir,long[] mov, long[] comp){
		Integer i = esq;
		Integer j = dir;
		Integer pivo = array[(esq + dir) / 2];
		while(i <= j){
			while(array[i] < pivo){
				comp[0]++;
				i++;
			}
			comp[0]++;
			while(array[j] > pivo){
				comp[0]++;
				j--;
			}
			comp[0]++;
			if(i <= j){
				mov[0]++;
				swap(array,i,j);
				i++;
				j--;
			}
		}
		if(j > esq){
			quicksortrec(array,esq,j,mov,comp);
		}
		if(dir > i){
			quicksortrec(array,i,dir,mov,comp);
		}
	}
	public static void quicksort(Integer[] array, Integer len, File arquivo){
		try(FileWriter fw = new FileWriter(arquivo)){
			
			long inicio = System.currentTimeMillis();
			long[] mov = {0};
			long[] comp = {0};

			quicksortrec(array,0,len - 1, mov, comp);

			long fim = System.currentTimeMillis();
			long duracao = fim - inicio;

			fw.write(comp[0] + "\t" + mov[0] + "\t" + duracao);
			fw.flush();
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){


		File file100 = new File("./quicksort_array100.txt");
		File file1000 = new File("./quicksort_array1000.txt");
		File file10000 = new File("./quicksort_array10000.txt");
		File file100000 = new File("./quicksort_array100000.txt");

		Integer array100[] = new Integer[100];
		Integer array1000[] = new Integer[1000];
		Integer array10000[] = new Integer[10000];
		Integer array100000[] = new Integer[100000];

		preencheArray(array100,100);
		preencheArray(array1000,1000);
		preencheArray(array10000,10000);
		preencheArray(array100000,100000);

		quicksort(array100, 100, file100);
		quicksort(array1000, 1000, file1000);
		quicksort(array10000, 10000, file10000);
		quicksort(array100000, 100000, file100000);
	}
}
