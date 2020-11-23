package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;

/**
 * Interface que contém todas as ações(funções) que podem ser realizadas 
 * em um duelo com uma carta monstro.
 * @author Iury
 *
 */
public interface iAcoesMonstros {
	
	/**
	 * Função utilizada para invocar um carta monstro da mão do jogador no 
	 * tabuleiro.
	 * @param jogador o jogador dono da carta.
	 * @param posicaoCartaMao posicao da carta monstro na mão do jogador.
	 */
	void invocarMonstro(Jogador jogador, int posicaoCartaMao);
	
	/**
	 * Função utilizada para realizar o ataque de um monstro do jogador
	 * contro um monstro do jogador inimigo.
	 * @param jAtacante Jogador que está atacando.
	 * @param mAtacante Posicao no tabuleiro do monstro do jogador atacante.
	 * @param jAtacado Jogador inimigo que está sendo atacado.
	 * @param mAtacado Posicao no tabuleiro do monstro do jogador inimigo.
	 */
	void atacar(Jogador jAtacante, int mAtacante, Jogador jAtacado, int mAtacado);
	
	/**
	 * Função utilizada para realizar um ataque de um monstro do jogador
	 * contr os Pontos de Vida do jogador.
	 * @param jAtacante Jogador que está atacando.
	 * @param mAtacante Posicao no tabuleiro do monstro do jogador atacante.
	 * @param jogador Jogador inimigo que está sendo atacado.
	 */
	void atacarDireto(Jogador jAtacante, int mAtacante, Jogador jogador);
	
	/**
	 * Função utilizada para mudar a posição de batalha de um monstro do jogador
	 * no tabuleiro.
	 * @param jogador jogador dono do monstro.
	 * @param posicaoCartaTab posicao da carta no tabuleiro.
	 */
	void mudarPosicaoBatalha(Jogador jogador, int posicaoCartaTab);
}
