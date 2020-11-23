package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;

/**
 * Interface que cont�m todas as a��es(fun��es) que podem ser realizadas 
 * em um duelo com uma carta magica.
 * @author Iury
 *
 */
public interface iAcoesMagia {
	
	/**
	 * Fun��o utilizada para invocar uma carta magica da m�o
	 * do jogador no tabuleiro.
	 * @param jogador o jogador que vai invocar a carta magica.
	 * @param posicaoCartaMao a posi��o da carta magica na m�o.
	 */
	void invocarMagia(Jogador jogador, int posicaoCartaMao);
	
	/**
	 * Fun��o utilizada internamenta para ativar efeito de uma carta magica.
	 * @param jogador o jogador dono da carta.
	 * @param posicaoCartaTab posicao da carta magica no tabuleiro.
	 */
	void ativarEfeitoMagia( Jogador jogador, int posicaoCartaTab );
}
