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

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Integer testCases = sc.nextInt();

		for(int i = 0; i < testCases; i++){

			Integer totalReindeer = sc.nextInt();
			Integer sledReindeer = sc.nextInt();

			Reindeer[] reindeer = new Reindeer[totalReindeer];

			readReindeer(reindeer,sc);

			reindeer[0].print();

		}

		sc.close();
	}
}
