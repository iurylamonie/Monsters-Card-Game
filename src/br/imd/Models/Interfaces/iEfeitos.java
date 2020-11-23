package br.imd.Models.Interfaces;

/**
 * Interface que contém todas os efeitos comuns entre as cartas.
 * @author Iury
 *
 */

public interface iEfeitos {
	
	/**
	 * Função utilizada para ativar os efeitos relacionadas a carta.
	 */
	void ativarEfeito();
	
	/**
	 * Função utilizada para desativar os efeitos relacionadas a carta.
	 * Geralmente utilizada quando a carta deixa o campo, principalmente
	 * em efeitos de aumentar ATK ou DEF de um monstro.
	 */
	void desativarEfeito();
	
}
