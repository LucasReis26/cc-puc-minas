package ex01.assets;

import ex01.assets.Show;

public class ArvoreBinaria{
	private Show[] array;
	private int tam;

	public Lista(){
		array = new Show[1368];
		tam = 0;
	}

	public void inserirInicio(Show show){
		for(int i = tam; i > 0; i--){
			array[i] = array[i - 1];
		}
		array[0] = show;
		tam++;
	}

	public void inserir(Show show, int posicao) {
		for(int i = tam; i > posicao; i--){
			array[i] = array[i - 1];
		}
		array[posicao] = show;
		tam++;
	}

	public void inserirFim(Show show){
		array[tam++] = show;
	}

	public Show removerInicio(){
		Show tmp = array[0];
		for(int i = 0; i < tam - 1; i++){
			array[i] = array[i + 1];
		}
		tam--;
		return tmp;
	}

	public Show remover(int posicao) {
		// mostrar();
		Show tmp = array[posicao];
		for(int i = posicao; i < tam - 1; i++){
			array[i] = array[i + 1];
		}
		tam--;
		return tmp;
	}

	public Show removerFim(){
		return array[--tam];
	}

	public void mostrar(){
		System.out.print("[ ");
		for(int i = 0; i < tam; i++){
			System.out.print(array[i].getShow_id() + " ");
		}
		System.out.println("]");
	}

	public void mostraRestantes(){
		for(int i = 0; i < tam; i++){
			array[i].imprimir();
		}
	}
}
