package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;
import br.imd.Models.Magia;

/**
 * Interface que cont�m todas as a��es(fun��es) que podem ser realizadas 
 * em um duelo com uma carta magica.
 * @author Iury
 *
 */
public interface iAcoesMagia {
	
	
	/**
	 * Coloca uma magia da mão do jogador no tabuleiro.
	 * @param magia magia que vai ser colocada no tabuleiro.
	 * @return posição que a carta foi colocada no campo de magia.
	 */
	int invocarMagia(Magia magia);
	
	/**
	 * Fun��o utilizada internamenta para ativar efeito de uma carta magica.
	 * @param jogador o jogador dono da carta.
	 * @param posicaoCartaTab posicao da carta magica no tabuleiro.
	 */
	void ativarEfeitoMagia( Jogador jogador, int posicaoCartaTab );
}
