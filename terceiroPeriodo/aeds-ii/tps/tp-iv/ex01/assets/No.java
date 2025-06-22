package ex01.assets;

import ex01.assets.Show;

public class No{
	private Show elemento;
	private No dir;
	private No esq;

	public No(Show elemento){
		this.elemento = elemento;
		dir = esq = NULL;
	}

	public Show getElemento() {
		return elemento;
	}

	public void setElemento(Show elemento) {
		this.elemento = elemento;
	}

	public No getDir() {
		return dir;
	}

	public void setDir(No dir) {
		this.dir = dir;
	}

	public No getEsq() {
		return esq;
	}

	public void setEsq(No esq) {
		this.esq = esq;
	}
}
