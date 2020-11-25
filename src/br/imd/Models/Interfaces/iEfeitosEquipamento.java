package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;
import br.imd.Models.Monstro;

/**
 * Interface que contém efeitos comuns entre as magias de equipamento.
 * @author Iury
 *
 */
public interface iEfeitosEquipamento extends iEfeitos {

	/**
	 * Aumenta o ATK do monstro de um jogador de acordo 
	 * com pontos informado no atributo "pontos" da carta magia-equipamento.
	 * @param monstroAlvo monstro que vai ser alvo do efeito
	 */
	void aumentarATK( Monstro monstroAlvo );
	
	/**
	 * Aumenta a DEF do monstro de um jogador de acordo 
	 * com pontos informado no atributo "pontos" da carta magia-equipamento.
	 * @param monstroAlvo monstro que vai ser alvo do efeito.
	 */
	void aumentarDEF( Monstro monstroAlvo );
}
