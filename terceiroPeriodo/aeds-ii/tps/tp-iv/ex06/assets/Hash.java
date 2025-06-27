package ex06.assets;

import ex06.assets.Show;
import ex06.assets.LogStatus;

public class Hash {
	Show tabela[];
	int m;

	public Hash() {
		this(21);
	}

	public Hash(int m) {
		this.m = m;
		this.tabela = new Show[this.m];
		for (int i = 0; i < m; i++) {
			tabela[i] = null;
		}
	}
	private int getAsciiTitle(String elemento){
		int len = elemento.length();
		int resp = 0;

		for(int i = 0; i < len; i++){
			resp += (int) elemento.charAt(i);
		}

		return resp;
	}

	public int h(Show elemento) {
		return getAsciiTitle(elemento.getTitle()) % m;
	}

	public int reh(Show elemento) {
		return (getAsciiTitle(elemento.getTitle()) + 1) % m;
	}

	public int h(String elemento) {
		return getAsciiTitle(elemento) % m;
	}

	public int reh(String elemento) {
		return (getAsciiTitle(elemento) + 1) % m;
	}

	public boolean inserir(Show elemento) {
		boolean resp = false;
		if (elemento != null) {
			int pos = h(elemento);
			if (tabela[pos] == null) {
				tabela[pos] = elemento;
				resp = true;
			} else {
				pos = reh(elemento);
				if (tabela[pos] == null) {
					tabela[pos] = elemento;
					resp = true;
				}
			}
		}
		return resp;
	}

	public boolean pesquisar(String elemento,LogStatus ls) {
		boolean resp = false;
		int pos = h(elemento);
		int posPrint = pos;
		if (tabela[pos].getTitle().compareTo(elemento) == 0) {
			ls.comparacao(1);
			resp = true;
		} else if (tabela[pos] != null) {
			ls.comparacao(2);
			pos = reh(elemento);
			if (tabela[pos].getTitle().compareTo(elemento) == 0) {
				ls.comparacao(1);
				resp = true;
			}
		}

		System.out.print(" (Posicao: " + posPrint +")");

		return resp;
	}
}
