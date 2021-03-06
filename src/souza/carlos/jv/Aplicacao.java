package souza.carlos.jv;

import souza.carlos.jv.modulo.Tabela;
import souza.carlos.jv.views.TabelaConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabela tabela = new Tabela();
		
		new TabelaConsole(tabela);
	}
}