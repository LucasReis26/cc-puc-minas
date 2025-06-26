package ex02.assets;

import ex02.assets.Show;

public class ArvoreSecundaria{
	private No raiz;

	public ArvoreSecundaria(){
		raiz = null;
	}

	private boolean mostrar(String x, No i){
		boolean resp;

		if(i == null){
			resp = false;
		}else if(x.equals(i.getElemento().getTitle())){
			resp = true;
		}else if(x.compareTo(i.getElemento().getTitle()) < 0){
			System.out.print("esq ");
			resp = mostrar(x, i.getEsq());
		}else{
			System.out.print("dir ");
			resp = mostrar(x,i.getDir());
		}

		return resp;
	}

	public boolean mostrar(String x){
		return mostrar(x,raiz);
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
