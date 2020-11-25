package br.imd.Models.Interfaces;

import br.imd.Models.Jogador;
import br.imd.Models.Carta;
/**
 * Interface que cont�m todas os efeitos comuns entre as cartas.
 * @author Iury
 *
 */

public interface iEfeitos {
	
	/**
	 * Fun��o utilizada para ativar os efeitos relacionadas � uma determinada carta
	 * e possiveis cartas alvos desse efeito.
	 * @param jogadorAtivou jogador que ativou a carta.
	 * @param cartaAtivada carta que vai ter o efeito ativado.
	 * @param jogadorAlvo jogador alvo do efeito.
	 * @param cartaAlvo carata alvo do efeito.
	 * 
	 */
	void ativarEfeito(Jogador jogadorAtivou, Carta cartaAtivada,
			Jogador  jogadorAlvo, Carta cartaAlvo);
	
	/**
	 * Fun��o utilizada para desativar os efeitos relacionadas a carta.
	 * Geralmente utilizada quando a carta deixa o campo, principalmente
	 * em efeitos de aumentar ATK ou DEF de um monstro.
	 */
	void desativarEfeito();
	
}
