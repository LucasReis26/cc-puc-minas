package ex1766.java;

import java.util.Scanner;

class Reindeer{

	public String name;
	public Integer weight;
	public Integer yearsOld;
	public Double height;

	public Reindeer(){
		this.name = "";
		this.weight = 0;
		this.yearsOld = 0;
		this.height = 0.0;
	}

	public Reindeer(String name, Integer weight, Integer yearsOld, Double height){
		this.name = name;
		this.weight = weight;
		this.yearsOld = yearsOld;
		this.height = height;
	}

	public void print(){
		System.out.println(this.name);
	}
}

public class Ex1766{

	public static void readReindeer(Reindeer[] array, Scanner sc){

		Integer len = array.length;

		for(int i = 0; i < len; i++){

			String name = sc.next();
			Integer weight = sc.nextInt();
			Integer yearsOld = sc.nextInt();
			Double height = sc.nextDouble();

			array[i] = new Reindeer(name,weight,yearsOld,height);
		}
	}

	public static void checkBigger(Reindeer[] array, Integer bigger, Integer j){
		Integer ans = bigger;
		Boolean v = false;

		if(!v && array[bigger].weight > array[j].weight){
			ans = bigger;
			v = true;
		}

		if(!v && array[bigger].weight != array[j].weight){
			ans = j;
			v = true;
		}

		if(!v && array[bigger].yearsOld < array[j].yearsOld){
			ans = bigger;
			v = true;
		}

		if(!v && array[bigger].yearsOld != array[j].yearsOld){
			ans = j;
			v = true;
		}

		if(!v && array[bigger].height < array[j].height){
			ans = bigger;
			v = true;
		}

		if(!v && array[bigger].height != array[j].height){
			ans = j;
			v = true;
		}

		if(!v && array[bigger].name.compareTo(array[j].name) < 0){
			ans = bigger;
			v = true;
		}

		if(!v && array[bigger].name.compareTo(array[j].name) != 0){
			ans = j;
			v = true;
		}

		return ans;
	}

	public static void sortReindeer(Reindeer[] array){
		Integer len = array.length;

		for(int i = 0; i < len; i++){

			Integer bigger = i;

			for(int j = i+1; j < len; j++){

				i = checkBigger(array,bigger,j);
			}

			Reindeer aux = array[i];
			array[i] = array[bigger];
			array[bigger] = aux;
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Integer testCases = sc.nextInt();

		for(int i = 0; i < testCases; i++){

			Integer totalReindeer = sc.nextInt();
			Integer sledReindeer = sc.nextInt();

			Reindeer[] reindeer = new Reindeer[totalReindeer];

			readReindeer(reindeer,sc);

			sortReindeer(reindeer);
			
			System.out.println("CENARIO {" + (i + 1) + "}");
			for(int j = 0; j < sledReindeer; j++){
				reindeer[j].print
			}
		}

		sc.close();
	}
}
