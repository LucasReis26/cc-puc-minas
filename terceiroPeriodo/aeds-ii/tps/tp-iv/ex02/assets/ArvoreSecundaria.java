package ex02.assets;

import ex02.assets.Show;
import ex02.assets.LogStatus;

public class ArvoreSecundaria{
	private No raiz;

	public ArvoreSecundaria(){
		raiz = null;
	}

	private boolean mostrar(String x, No i,LogStatus ls){
		boolean resp;

		if(i == null){
			ls.comparacao(1);
			resp = false;
		}else if(x.equals(i.getElemento().getTitle())){
			ls.comparacao(2);
			resp = true;
		}else if(x.compareTo(i.getElemento().getTitle()) < 0){
			ls.comparacao(3);
			System.out.print("esq ");
			resp = mostrar(x, i.getEsq(),ls);
		}else{
			System.out.print("dir ");
			resp = mostrar(x,i.getDir(),ls);
		}

		return resp;
	}

	public boolean mostrar(String x,LogStatus ls){
		return mostrar(x,raiz,ls);
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

	private class No{
		private Show elemento;
		private No dir;
		private No esq;

		public No(Show elemento){
			this.elemento = elemento;
			this.dir = this.esq = null;
		}

		public void setElemento(Show elemento) {
			this.elemento = elemento;
		}

		public Show getElemento() {
			return elemento;
		}

		public void setDir(No dir) {
			this.dir = dir;
		}

		public No getDir() {
			return dir;
		}

		public void setEsq(No esq) {
			this.esq = esq;
		}

		public No getEsq() {
			return esq;
		}
	}
}
