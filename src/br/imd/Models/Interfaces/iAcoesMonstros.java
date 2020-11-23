package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;

/**
 * Interface que cont�m todas as a��es(fun��es) que podem ser realizadas 
 * em um duelo com uma carta monstro.
 * @author Iury
 *
 */
public interface iAcoesMonstros {
	
	/**
	 * Fun��o utilizada para invocar um carta monstro da m�o do jogador no 
	 * tabuleiro.
	 * @param jogador o jogador dono da carta.
	 * @param posicaoCartaMao posicao da carta monstro na m�o do jogador.
	 */
	void invocarMonstro(Jogador jogador, int posicaoCartaMao);
	
	/**
	 * Fun��o utilizada para realizar o ataque de um monstro do jogador
	 * contro um monstro do jogador inimigo.
	 * @param jAtacante Jogador que est� atacando.
	 * @param mAtacante Posicao no tabuleiro do monstro do jogador atacante.
	 * @param jAtacado Jogador inimigo que est� sendo atacado.
	 * @param mAtacado Posicao no tabuleiro do monstro do jogador inimigo.
	 */
	void atacar(Jogador jAtacante, int mAtacante, Jogador jAtacado, int mAtacado);
	
	/**
	 * Fun��o utilizada para realizar um ataque de um monstro do jogador
	 * contr os Pontos de Vida do jogador.
	 * @param jAtacante Jogador que est� atacando.
	 * @param mAtacante Posicao no tabuleiro do monstro do jogador atacante.
	 * @param jogador Jogador inimigo que est� sendo atacado.
	 */
	void atacarDireto(Jogador jAtacante, int mAtacante, Jogador jogador);
	
	/**
	 * Fun��o utilizada para mudar a posi��o de batalha de um monstro do jogador
	 * no tabuleiro.
	 * @param jogador jogador dono do monstro.
	 * @param posicaoCartaTab posicao da carta no tabuleiro.
	 */
	void mudarPosicaoBatalha(Jogador jogador, int posicaoCartaTab);
}
