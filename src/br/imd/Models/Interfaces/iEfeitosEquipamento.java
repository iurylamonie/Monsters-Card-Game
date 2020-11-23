package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;

/**
 * Interface que contém efeitos comuns entre as magias de equipamento.
 * @author Iury
 *
 */
public interface iEfeitosEquipamento extends iEfeitos {

	/**
	 * Aumenta o ATK do monstro de um jogador de acordo 
	 * com pontos informado no atributo "pontos" da carta magia-equipamento.
	 * @param jogador o jogador dono da carta que vai receber o bonus de ATK.
	 * @param posicaoCartaTab posicao da carta no tabuleiro.
	 */
	void aumentarATK(Jogador jogador, int posicaoCartaTab);
	
	/**
	 * Aumenta a DEF do monstro de um jogador de acordo 
	 * com pontos informado no atributo "pontos" da carta magia-equipamento.
	 * @param jogador o jogador dono da carta que vai receber o bonus de ATK.
	 * @param posicaoCartaTab posicao da carta no tabuleiro.
	 */
	void aumentarDEF(Jogador jogador, int posicaoCartaTab);
}
