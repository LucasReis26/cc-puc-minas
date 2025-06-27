package ex04.assets;

import ex04.assets.Show;
import ex04.assets.LogStatus;
import ex04.assets.NoAN;

public class ArvoreAlvinegra{
	private NoAN raiz;

	public ArvoreAlvinegra() {
		raiz = null;
	}

	public boolean pesquisar(String elemento, LogStatus ls) {
		System.out.print("=>raiz  ");
		return pesquisar(elemento, raiz, ls);
	}

	private boolean pesquisar(String elemento, NoAN i, LogStatus ls) {
		boolean resp;
		if (i == null) {
			resp = false;
			ls.comparacao(1);
		} else if (elemento.compareTo(i.elemento.getTitle()) == 0) {
			resp = true;
			ls.comparacao(2);
		} else if (elemento.compareTo(i.elemento.getTitle()) < 0) {
			System.out.print("esq ");
			resp = pesquisar(elemento, i.esq, ls);
			ls.comparacao(3);
		} else {
			System.out.print("dir ");
			resp = pesquisar(elemento, i.dir, ls);
			ls.comparacao(4);
		}
		return resp;
	}

	public void inserir(Show elemento){
		if (raiz == null) {
			raiz = new NoAN(elemento);

		} else if (raiz.esq == null && raiz.dir == null) {
			if (elemento.getTitle().compareTo(raiz.elemento.getTitle()) < 0) {
				raiz.esq = new NoAN(elemento);
			} else {
				raiz.dir = new NoAN(elemento);
			}
		} else if (raiz.esq == null) {
			if (elemento.getTitle().compareTo(raiz.elemento.getTitle()) < 0) {
				raiz.esq = new NoAN(elemento);

			} else if (elemento.getTitle().compareTo(raiz.dir.elemento.getTitle()) < 0) {
				raiz.esq = new NoAN(raiz.elemento);
				raiz.elemento = elemento;
			} else {
				raiz.esq = new NoAN(raiz.elemento);
				raiz.elemento = raiz.dir.elemento;
				raiz.dir.elemento = elemento;
			}
			raiz.esq.cor = raiz.dir.cor = false;
		} else if (raiz.dir == null) {
			if (elemento.getTitle().compareTo(raiz.elemento.getTitle()) > 0) {
				raiz.dir = new NoAN(elemento);
			} else if (elemento.getTitle().compareTo(raiz.esq.elemento.getTitle()) > 0) {
				raiz.dir = new NoAN(raiz.elemento);
				raiz.elemento = elemento;
			} else {
				raiz.dir = new NoAN(raiz.elemento);
				raiz.elemento = raiz.esq.elemento;
				raiz.esq.elemento = elemento;
			}
			raiz.esq.cor = raiz.dir.cor = false;
		} else {
			inserir(elemento, null, null, null, raiz);
		}
		raiz.cor = false;
	}

	private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
		if (pai.cor == true) {
			if (pai.elemento.getTitle().compareTo(avo.elemento.getTitle()) >  0) { 
				if (i.elemento.getTitle().compareTo(pai.elemento.getTitle()) > 0) {
					avo = rotacaoEsq(avo);
				} else {
					avo = rotacaoDirEsq(avo);
				}
			} else {
				if (i.elemento.getTitle().compareTo(pai.elemento.getTitle()) < 0) {
					avo = rotacaoDir(avo);
				} else {
					avo = rotacaoEsqDir(avo);
				}
			}
			if (bisavo == null) {
				raiz = avo;
			} else if (avo.elemento.getTitle().compareTo(bisavo.elemento.getTitle()) < 0) {
				bisavo.esq = avo;
			} else {
				bisavo.dir = avo;
			}
			avo.cor = false;
			avo.esq.cor = avo.dir.cor = true;
		} 
	}

	private void inserir(Show elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i){
		if (i == null) {
			if (elemento.getTitle().compareTo(pai.elemento.getTitle()) < 0) {
				i = pai.esq = new NoAN(elemento, true);
			} else {
				i = pai.dir = new NoAN(elemento, true);
			}
			if (pai.cor == true) {
				balancear(bisavo, avo, pai, i);
			}
		} else {
			if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
				i.cor = true;
				i.esq.cor = i.dir.cor = false;
				if (i == raiz) {
					i.cor = false;
				} else if (pai.cor == true) {
					balancear(bisavo, avo, pai, i);
				}
			}
			if (elemento.getTitle().compareTo(i.elemento.getTitle()) < 0) {
				inserir(elemento, avo, pai, i, i.esq);
			} else if (elemento.getTitle().compareTo(i.elemento.getTitle()) > 0) {
				inserir(elemento, avo, pai, i, i.dir);
			}
		}
	}

	private NoAN rotacaoDir(NoAN no) {
		NoAN noEsq = no.esq;
		NoAN noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;

		return noEsq;
	}

	private NoAN rotacaoEsq(NoAN no) {
		NoAN noDir = no.dir;
		NoAN noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;
		return noDir;
	}

	private NoAN rotacaoDirEsq(NoAN no) {
		no.dir = rotacaoDir(no.dir);
		return rotacaoEsq(no);
	}

	private NoAN rotacaoEsqDir(NoAN no) {
		no.esq = rotacaoEsq(no.esq);
		return rotacaoDir(no);
	}
}
