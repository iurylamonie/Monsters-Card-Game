package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;

/**
 * Interface que contém efeitos comuns entre as magias normais.
 * @author Iury
 *
 */
public interface iEfeitosMagias extends iEfeitos {

	/**
	 * Aumenta os Pontos de Vida do jogador informado de acordo com
	 * os pontos informados no atributo "pontos".
	 * @param jogador jogador que vai ganhar vida.
	 */
	void ganharPV(Jogador jogador);
	
	/**
	 * Diminui os Pontos de Vida do jogador informado de acordo com
	 * os pontos informados no atributo "pontos".
	 * @param jogador jogador que vai ganhar vida.
	 */
	void perderPV(Jogador jogador);
}
