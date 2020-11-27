package br.imd.Models.Interfaces;

import br.imd.Models.Carta;
import br.imd.Models.Jogador;
import br.imd.Models.Magia;
import br.imd.Models.Monstro;
import br.imd.Rules.NoSpaceZoneException;
import br.imd.Rules.WinnerException;

/**
 * Interface que cont�m todas as a��es(fun��es) que podem ser realizadas 
 * em um duelo com uma carta magica.
 * @author Iury
 *
 */
public interface iAcoesMagia {
	
	
	/**
	 * Coloca uma magia da mão do jogador no tabuleiro.
	 * @param magia magia que vai ser colocada no tabuleiro.
	 * @return posição que a carta foi colocada no campo de magia.
	 */
	int invocarMagia(Magia magia) throws NoSpaceZoneException;
	
	
	/**
	 * Ativa o efeito de uma carta especifica
	 * @param jogadorAtivou jogador que ativou o efeito
	 * @param cartaAtivou magia que teve o efeito ativado.
	 * @param jogadorAlvo jogador alvo da magia.
	 * @param cartaAlvo jogador alvo da magia
	 * @throws WinnerException
	 */
	void ativarEfeitoMagia( Jogador jogadorAtivou, Carta cartaAtivou, Jogador jogadorAlvo, Carta cartaAlvo) throws WinnerException;

	/**
	 * Verifica se tem uma carta magia de equipamento associada a um monstro, caso aja, é removida do campo.
	 * @param dono dono da carta monstro
	 * @param monstro monstro que vai ser verificado.
	 */
	void verificarMonstroEquipado( Jogador dono, Monstro monstro);
}
