package ex05.assets;

import ex05.assets.Show;
import ex05.assets.LogStatus;

public class Hash {
	Show tabela[];
	int m1, m2, m, reserva;

	public Hash() {
		this(21, 9);
	}

	public Hash(int m1, int m2) {
		this.m1 = m1;
		this.m2 = m2;
		this.m = m1 + m2;
		this.tabela = new Show[this.m];
		for (int i = 0; i < m1; i++) {
			tabela[i] = null;
		}
		reserva = 0;
	}

	private int getAsciiTitle(String elemento){
		int len = elemento.length();
		int resp = 0;

		for(int i = 0; i < len; i++){
			resp += elemento.charAt(i);
		}

		return resp;
	}

	public int h(Show elemento) {
		return getAsciiTitle(elemento.getTitle()) % m1;
	}

	public int h(String elemento){
		return getAsciiTitle(elemento) % m1;
	}

	public boolean inserir(Show elemento) {
		boolean resp = false;
		if (elemento != null) {
			int pos = h(elemento);
			if (tabela[pos] == null) {
				tabela[pos] = elemento;
				resp = true;
			} else if (reserva < m2) {
				tabela[m1 + reserva] = elemento;
				reserva++;
				resp = true;
			}
		}
		return resp;
	}

	public boolean pesquisar(String elemento,LogStatus ls) {
		boolean resp = false;
		int pos = h(elemento);
		if (tabela[pos].getTitle().compareTo(elemento) == 0) {
			resp = true;
			ls.comparacao(1);
		} else if (tabela[pos] != null) {
			ls.comparacao(2);
			for (int i = 0; i < reserva; i++) {
				if (tabela[m1 + i].getTitle().compareTo(elemento) == 0) {
					resp = true;
					i = reserva;
					ls.comparacao(1);
				}
			}
		}
		System.out.print(" (Posicao: " + pos +")");
		return resp;
	}
}
