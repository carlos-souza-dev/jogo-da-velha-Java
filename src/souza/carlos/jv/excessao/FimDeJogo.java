package souza.carlos.jv.excessao;

public class FimDeJogo extends RuntimeException{

	private static final long serialVersionUID = 1;
	
	public String toString () {
		return "Voc� saiu do jogo!";
	}
}
