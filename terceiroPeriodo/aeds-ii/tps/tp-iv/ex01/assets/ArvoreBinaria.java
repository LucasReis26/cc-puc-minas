package ex01.assets;

import ex01.assets.Show;
import ex01.assets.LogStatus;

public class ArvoreBinaria{
	private No raiz;

	public ArvoreBinaria(){
		raiz = null;
	}

	private boolean pesquisar(String x, No i,LogStatus ls){
		boolean resp;

		if(i == null){
			resp = false;
			ls.comparacao(1);
		}else if(x.equals(i.getElemento().getTitle())){
			resp = true;
			ls.comparacao(2);
		}else if(x.compareTo(i.getElemento().getTitle()) < 0){
			System.out.print("esq ");
			resp = pesquisar(x, i.getEsq(),ls);
			ls.comparacao(3);
		}else{
			System.out.print("dir ");
			resp = pesquisar(x,i.getDir(),ls);
			ls.comparacao(4);
		}

		return resp;
	}

	public boolean pesquisar(String x,LogStatus ls){
		System.out.print("=>raiz  ");
		return pesquisar(x,raiz,ls);
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
