package br.imd.Models.Interfaces;

import br.imd.Models.Monstro;
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
	 * @param monstroAlvo carta monstro que vai ser alvo do efeito.
	 */
	void diminuirATKInimigo( Monstro monstroAlvo );
	
	/**
	 * Diminui a DEF do monstro  inimigo que é alvo desse efeito
	 * de acordo com pontos informado no seu atributo "pontos".
	 * @param monstroAlvo carta monstro que vai ser alvo do efeito.
	 */
	void diminuirDEFInimigo( Monstro monstroAlvo );
}
