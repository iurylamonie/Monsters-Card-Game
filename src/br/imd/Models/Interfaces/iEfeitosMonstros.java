package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;
/**
 * Interface que contém efeitos comuns entre os monstros de efeito.
 * @author Iury
 *
 */
public interface iEfeitosMonstros extends iEfeitos {
	
	/**
	 * Aumenta o ATK do monstro que ativa esse efeito
	 * de acordo com pontos informado no seu atributo "pontos".
	 */
	void aumentarProprioATK();
	
	/**
	 * Aumenta o DEF do monstro que ativa esse efeito
	 * de acordo com pontos informado no seu atributo "pontos".
	 */
	void aumentarProprioDEF();
	
	/**
	 * Diminui o ATK do monstro  inimigo que é alvo desse efeito
	 * de acordo com pontos informado no seu atributo "pontos".
	 * @param jogador jogador inimigo.
	 * @param posicaoCartaTab posicao da carta no tabuleiro inimimgo.
	 */
	void diminuirATKInimigo(Jogador jogador, int posicaoCartaTab );
	
	/**
	 * Diminui a DEF do monstro  inimigo que é alvo desse efeito
	 * de acordo com pontos informado no seu atributo "pontos".
	 * @param jogador jogador inimigo.
	 * @param posicaoCartaTab posicao da carta no tabuleiro inimimgo.
	 */
	void diminuirDEFInimigo(Jogador jogador, int posicaoCartaTab );
}
