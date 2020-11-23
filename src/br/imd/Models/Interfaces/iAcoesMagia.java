package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;

/**
 * Interface que contém todas as ações(funções) que podem ser realizadas 
 * em um duelo com uma carta magica.
 * @author Iury
 *
 */
public interface iAcoesMagia {
	
	/**
	 * Função utilizada para invocar uma carta magica da mão
	 * do jogador no tabuleiro.
	 * @param jogador o jogador que vai invocar a carta magica.
	 * @param posicaoCartaMao a posição da carta magica na mão.
	 */
	void invocarMagia(Jogador jogador, int posicaoCartaMao);
	
	/**
	 * Função utilizada internamenta para ativar efeito de uma carta magica.
	 * @param jogador o jogador dono da carta.
	 * @param posicaoCartaTab posicao da carta magica no tabuleiro.
	 */
	void ativarEfeitoMagia( Jogador jogador, int posicaoCartaTab );
}
