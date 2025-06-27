package ex06.assets;

public class LogStatus{
	private Long inicio;
	private Long fim;
	private int comparacoes;

	public LogStatus(){
		comparacoes = 0;
		this.inicio = this.fim = null;
	}

	public void iniciar(){
		this.inicio = System.currentTimeMillis();
	}

	public void parar(){
		this.fim = System.currentTimeMillis();
	}

	public Long tempoAlgoritmo(){
		if(inicio != null && fim != null){
			return fim - inicio;
		}
		return 0L;
	}
	
	public void comparacao(int x){
		comparacoes+=x;
	}

	public int getComparacoes() {
		return comparacoes;
	}
}
