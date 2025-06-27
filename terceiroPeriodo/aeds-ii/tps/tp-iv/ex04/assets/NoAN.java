package ex04.assets;

import ex04.assets.Show;

public class NoAN{
	public boolean cor;
	public Show elemento;
	public NoAN esq, dir;

	public NoAN() {
		this(null);
	}

	public NoAN(Show elemento) {
		this(elemento, false, null, null);
	}

	public NoAN(Show elemento, boolean cor) {
		this(elemento, cor, null, null);
	}

	public NoAN(Show elemento, boolean cor, NoAN esq, NoAN dir) {
		this.cor = cor;
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}
