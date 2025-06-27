package ex02.assets;

import ex02.assets.Show;
import ex02.assets.ArvoreSecundaria;
import ex02.assets.LogStatus;

public class ArvorePrimaria{
	private No raiz;

	public ArvorePrimaria(){
		raiz = null;
	}

	private boolean mostrar(String x, No i,LogStatus ls){
		boolean resp;

		if(i == null){
			resp = false;
			ls.comparacao(1);
		}else if(i.getA2().mostrar(x,ls)){
			resp = true;
			ls.comparacao(2);
		}else{
			System.out.print(" ESQ ");
			resp = mostrar(x,i.getEsq(),ls);
			
			if(!resp){
				System.out.print(" DIR ");
				resp = mostrar(x,i.getDir(),ls);
			}
		}

		return resp;
	}

	public boolean mostrar(String x,LogStatus ls){
		boolean resp;

		System.out.print("raiz ");
		resp = mostrar(x,raiz,ls);

		return resp;
	}

	private ArvoreSecundaria procuraArvore(int x, No i){
		ArvoreSecundaria resp;
		
		if(x == i.getReleaseMod15()){
			if(i.getA2() != null){
				resp = i.getA2();
			}else{
				i.setA2(new ArvoreSecundaria());
				resp = i.getA2();
			}
		}else if(x < i.getReleaseMod15()){
			resp = procuraArvore(x,i.getEsq());
		}else{
			resp = procuraArvore(x,i.getDir());
		}

		return resp;
	}

	private ArvoreSecundaria procuraArvore(int x){
		ArvoreSecundaria resp = procuraArvore(x,raiz);

		return resp;
	}

	//INSERIR REFERENTE A SHOWS;

	public void inserir(Show x){
		int i = x.getReleaseYear() % 15;
		ArvoreSecundaria a2 = procuraArvore(i);
		a2.inserir(x);
	}

	//INSERIR REFERENTE A NUMEROS INTEIROS

	private No inserir(int x, No i){
		if(i == null){
			i = new No(x);
		}else if(x < i.getReleaseMod15()){
			i.setEsq(inserir(x,i.getEsq()));
		}else if(x > i.getReleaseMod15()){
			i.setDir(inserir(x,i.getDir()));
		}

		return i;
	}

	public void inserir(int x){
		raiz = inserir(x,raiz);
	}

	private class No{
		private int releaseMod15;
		private ArvoreSecundaria a2;
		private No dir;
		private No esq;

		public No(int releaseMod15){
			this.releaseMod15 = releaseMod15;
			this.a2 = null;
			this.dir = this.esq = null;
		}

		public void setReleaseMod15(int releaseMod15) {
			this.releaseMod15 = releaseMod15;
		}

		public int getReleaseMod15() {
			return releaseMod15;
		}

		public void setA2(ArvoreSecundaria a2) {
			this.a2 = a2;
		}

		public ArvoreSecundaria getA2() {
			return a2;
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
