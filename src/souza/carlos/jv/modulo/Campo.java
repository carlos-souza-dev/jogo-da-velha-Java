package souza.carlos.jv.modulo;

public class Campo {

	private int linha;
	private int coluna;
	
	private boolean preenchido;
	private boolean xis;
	private boolean bola;
	
	Campo (int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public boolean getPreenchido() {
		return this.preenchido;
	}
	
	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}
	
	void preecherXis() {
		this.preenchido = true;		
		this.xis = !xis;			
	}
	
	void preecherBola() {
		this.preenchido = true;		
		this.bola = !bola;
	}
	
	
	void reiniciar() {
		this.preenchido = false;
		this.xis = false;
		this.bola = false;
	}

	public String toString() {
		if(preenchido && xis) {
			return " X ";
		} else if (preenchido && bola ) {
			return " O ";
		} else {
			return " - ";
		}
	}
}