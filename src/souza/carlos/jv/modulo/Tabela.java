package souza.carlos.jv.modulo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tabela {

	private int linhas;
	private int colunas;
	
	private int linha0 = 15;
	private int linha1 = 0;
	private int linha2 = 0;
	private int coluna0 = 0;
	private int coluna1 = 0;
	private int coluna2 = 0;
	private int diagonal = 0;
	private int diagona2 = 0;
	
	private  List<Campo> campos = new ArrayList<>();
	
	List<Integer> arrayColRow = Arrays.asList( this.linha0, this.linha1, this.linha2, this.coluna0, this.coluna1, this.coluna2, this.diagonal, this.diagona2 );
	
	public Tabela() {
		this.linhas = 3;
		this.colunas = 3;
		
		gerarCampo();
	}

	public int getLinhas() {
		return this.linhas;
	}

	public int getColunas() {
		return this.colunas;
	}

//	FAZER FOREACH NO ARRAY PARA ACHAR VENCEDOR;
	
//	public String jogoFinalizado(int rodada) {
//		for (int i = 0; i < arrayColRow.length; i++) {
//			if (arrayColRow[i] == 3) {
//				return "O jogador 1 venceu o jogo!";
//			} else if (arrayColRow[i] == -3) {
//				return "O jogador 2 venceu o jogo!";
//			} else if (rodada == 9 && arrayColRow[i] != -3 && arrayColRow[i] != 3) {
//				return "Ningu<E9>m ganhou!";
//			}
//		}
//		return "nda acontace";
//   }
	
	public void jogar(int value, int eixoX, int eixoY) {
		if(eixoX == 0 && eixoY == 0) {			
			this.linha0 = value;
			this.coluna0 = value;
			this.diagona2 = value;
		} else if(eixoX == 0 && eixoY == 1) {
			this.linha0 = value;
			this.coluna1 = value;
		} else if(eixoX == 0 && eixoY == 2) {
			this.linha0 = value;
			this.coluna2 = value;
			this.diagonal = value;
		} else if(eixoX == 1 && eixoY == 0) {			
			this.linha1 = value;
			this.coluna0 = value;
		} else if(eixoX == 1 && eixoY == 1) {
			this.linha1 = value;
			this.coluna1 = value;
			this.diagonal = value;
			this.diagona2 = value;
		} else if(eixoX == 1 && eixoY == 2) {
			this.linha1 = value;
			this.coluna2 = value;
		}else if(eixoX == 2 && eixoY == 0) {			
			this.linha2 = value;
			this.coluna0 = value;
			this.diagonal = value;
		} else if(eixoX == 2 && eixoY == 1) {
			this.linha2 = value;
			this.coluna1 = value;
		} else if(eixoX == 2 && eixoY == 2) {
			this.linha2 = value;
			this.coluna2 = value;
			this.diagona2 = value;
		}
	}
	
	void gerarCampo() {
		for(int linha = 0; linha < this.linhas; linha++) {
			for(int coluna = 0; coluna < this.colunas; coluna++) {
				campos.add(new Campo(linha, coluna));
			}
		}	
	}
	
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
	}
	
	public void jogador1( int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna ).forEach(p -> p.preecherBola());
	}
	
	public void jogador2( int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna ).forEach(p -> p.preecherXis());
	}
	
	public String toString() {
		StringBuilder stb = new StringBuilder();
		
		int i = 0;
		for(int linha = 0; linha < this.linhas; linha++) {
			for(int coluna = 0; coluna < this.colunas; coluna++) {
				if(coluna == 0) {
					stb.append(" ");
					stb.append(campos.get(i));					
					stb.append(" ");
				} else if (coluna == 2){
					stb.append(" ");
					stb.append(campos.get(i));					
					stb.append(" ");
				} else {
					stb.append(" | ");
					stb.append(campos.get(i));					
					stb.append(" | ");
				}
				i++;
			}
			if(linha < 2) {
				stb.append("\n");
				stb.append("--------------------");
				stb.append("\n");
			}		
		}
		return stb.toString();
	}
	
}