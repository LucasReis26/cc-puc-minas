package ex02.java;

import java.util.Scanner;

class Paises{
	public String name;
	public Integer ouros;
	public Integer pratas;
	public Integer bronzes;

	public Paises(String name, Integer ouros, Integer pratas, Integer bronzes){
		this.name = name;
		this.ouros = ouros;
		this.pratas = pratas;
		this.bronzes = bronzes;
	}

	public void print(){
		System.out.println(this.name + " " + this.ouros + " " + this.pratas + " " + this.bronzes);
	}
}

public class Ex02{

	public static void ordenador(Paises[] p){
		Integer len = p.length;

		for(int i = 0; i < len - 1; i++){
			boolean swapped = false;
			for(int j = 0; j < len - i - 1; j++){

				Boolean v1 = (p[j].ouros < p[j + 1].ouros),
						v2 = (p[j].pratas < p[j + 1].pratas),
						v3 = (p[j].bronzes < p[j + 1].bronzes),
						v4 = (p[j].ouros == p[j + 1].ouros),
						v5 = (p[j].pratas == p[j + 1].pratas),
						v6 = (p[j].bronzes == p[j + 1].bronzes),
						v7 = (p[j].name.compareTo(p[j+1].name) == -1);

				if(v1){
					swapped = true;
					Paises tmp = p[j];
					p[j] = p[j+1];
					p[j + 1] = tmp;
				}else if(v2){
					swapped = true;
					Paises tmp = p[j];
					p[j] = p[j+1];
					p[j + 1] = tmp;
				}else if(v3){
					swapped = true;
					Paises tmp = p[j];
					p[j] = p[j+1];
					p[j + 1] = tmp;
				}else if(v4 && v5 && v6 && v7){
					swapped = true;
					Paises tmp = p[j];
					p[j] = p[j+1];
					p[j + 1] = tmp;
				}
			}
			if(!swapped){
				i = len;
			}
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Integer numPaises = sc.nextInt();

		Paises[] paises = new Paises[numPaises];

		for(int i = 0; i < numPaises; i++){

			String name = sc.next();

			Integer ouros = sc.nextInt(),
					pratas = sc.nextInt(),
					bronzes = sc.nextInt();

			paises[i] = new Paises(name,ouros,pratas,bronzes);
		}

		ordenador(paises);

		for(int i = 0; i < numPaises; i++){
			paises[i].print();
		}

		sc.close();
	}
}
