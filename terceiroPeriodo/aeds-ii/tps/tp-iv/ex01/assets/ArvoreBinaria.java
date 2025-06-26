package ex01.assets;

import ex01.assets.Show;

public class ArvoreBinaria{
	private No raiz;

	public ArvoreBinaria(){
		raiz = null;
	}

	private boolean pesquisar(String x, No i){
		boolean resp;

		if(i == null){
			resp = false;
		}else if(x.equals(i.getElemento().getTitle())){
			resp = true;
		}else if(x.compareTo(i.getElemento().getTitle()) < 0){
			System.out.print("esq ");
			resp = pesquisar(x, i.getEsq());
		}else{
			System.out.print("dir ");
			resp = pesquisar(x,i.getDir());
		}

		return resp;
	}

	public boolean pesquisar(String x){
		System.out.print("=>raiz  ");
		return pesquisar(x,raiz);
	}

	private No inserir(Show x, No i){
		if(i == null){
			i = new No(x);
		}else if(x.getTitle().compareTo(i.getElemento().getTitle()) < 0){
			i.setEsq(inserir(x,i.getEsq()));
		}else if(x.getTitle().compareTo(i.getElemento().getTitle()) > 0){
			i.setDir(inserir(x,i.getDir()));
		}

		return i;
	}

	public void inserir(Show x){
		raiz = inserir(x,raiz);
	}
}
