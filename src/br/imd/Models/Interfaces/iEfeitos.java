package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;
/**
 * Interface que contém todas os efeitos comuns entre as cartas.
 * @author Iury
 *
 */

public interface iEfeitos {
	
	/**
	 * Função utilizada para ativar os efeitos relacionadas a carta.
	 * @param jogadorAtivou jogador que ativou a carta.
	 * @param posicaoCartaAtivou posicao da carta que foi ativada.
	 * @param jogadorAlvo possivel jogador alvo da ativação do efeito.
	 * @param posicaoCartaAlvo posicao da possivel carta que vai ser alvo do efieto
	 * 
	 */
	void ativarEfeito(Jogador jogadorAtivou, int posicaoCartaAtivou,
			Jogador  jogadorAlvo, int posicaoCartaAlvo);
	
	/**
	 * Função utilizada para desativar os efeitos relacionadas a carta.
	 * Geralmente utilizada quando a carta deixa o campo, principalmente
	 * em efeitos de aumentar ATK ou DEF de um monstro.
	 */
	void desativarEfeito();
	
}
