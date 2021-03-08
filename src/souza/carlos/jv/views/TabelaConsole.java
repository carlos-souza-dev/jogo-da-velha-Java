package souza.carlos.jv.views;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import souza.carlos.jv.excessao.FimDeJogo;
import souza.carlos.jv.modulo.Tabela;

public class TabelaConsole {

	private Tabela tabela;
	private java.util.Scanner input = new Scanner(System.in);

	public TabelaConsole(Tabela tabela) {
		this.tabela = tabela;

		executarJogo();
	}

	private void executarJogo() {

		boolean continuar = true;

		try {
			
			int jogo = 0;
			while (continuar) {
				cicloDoJogo(jogo);
				
				String resposta = capturarInput("\nJogar novamente? ");
				
				if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("s")) {
					tabela.reiniciar();
				} else {
					continuar = false;
				}
				jogo++;
			}
			
		} catch (FimDeJogo e){
			System.out.println("Tchau!!!");
		}
	}

	private void cicloDoJogo(int jogo) {
		
		Iterator<Integer> eixos;
		
		
		int rodada = 0;
		while(rodada < 9) {
			System.out.println(" ---- Jogo "+(jogo+1)+" ---- \n");
			System.out.println(tabela);
			
			if(rodada% 2 == 0) {
				System.out.println("\nRodada "+(rodada+1)+": Jogador 1");
			} else {
				System.out.println("\nRodada "+(rodada+1)+": Jogador 2");				
			}

			
			String digitado = capturarInput("Digite os eixos (X, Y): ");
			
			eixos = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();
			
			int eixoX = eixos.next();
			int eixoY = eixos.next();
			
			if (rodada % 2 == 0) {
				tabela.jogador1(eixoX, eixoY);
				tabela.jogar(-1, eixoX, eixoY);
			} else {
				tabela.jogador2(eixoX, eixoY);
				tabela.jogar(1, eixoX, eixoY);
			}
			rodada++;  
			
			int campeao = tabela.jogoFinalizado();
			if(campeao == 1) {
				System.out.println(tabela);
				System.out.println("Jogador 1 ganhou o jogo!");
				rodada = 9;
			} else if (campeao == 2) {
				System.out.println(tabela);
				System.out.println("Jogador 2 ganhou o jogo!");            	
				rodada = 9;
			}            	
			
		}
		jogo++;
	}

	private String capturarInput(String posicao) {
		System.out.println(posicao.trim());
		String digitado = input.nextLine();
		
		if(digitado.equalsIgnoreCase("Sair")) {
			throw new FimDeJogo();
		}
		
		return digitado;
	}

}