package ex01.assets;

import ex01.assets.Show;

public class ArvoreBinaria{
	private No raiz;

	public ArvoreBinaria(){
		raiz = null;
	}

	private boolean pesquisar(int x, No i){
		boolean resp;

		if(i == null){
			resp = false;
		}else if(x == i.getElemento()){
			resp = true;
		}else if(x < i.elemento){
			resp = pesquisar(x, i.getEsq());
		}else{
			resp = pesquisar(x,i.getDir());
		}

		return resp;
	}

	public boolean pesquisar(int x){
		return pesquisar(x,raiz);
	}

	private void caminharCentral(No i){
		if(i != null){
			caminharCentral(i.getEsq());
			System.out.println(i.getElemento() + " ");
			caminharCentral(i.getDir());
		}
	}

	private void caminharPre(No i){
		if(i != null){
			System.out.println(i.getElemento() + " ");
			caminharPre(i.getEsq());
			caminharPre(i.getDir());
		}
	}

	private void caminharPos(No i){
		if(i != null){
			caminharPos(i.getEsq());
			caminharPos(i.getDir());
			System.out.println(i.getElemento() + " ");
		}
	}

	public void caminharCentral(){
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	public void caminharPre(){
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}

	public void caminharPos(){
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}

	private void inserir(int x, No i) throws Exception{
		if(i == null){
			i = new No(x);
		}else if(x < i.getElemento()){
			i.setEsq(inserir(x,i.getEsq()));
		}else if(x > i.getElemento()){
			i.setDir(inserir(x,i.getDir()));
		}else{
			throw new Exception("Erro ao inserir!");
		}

		return i;
	}

	public void inserir(int x){
		raiz = inserir(i,raiz);
	}
}
