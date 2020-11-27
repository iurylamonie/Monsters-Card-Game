package br.imd.Models.Interfaces;

import br.imd.Models.Carta;
import br.imd.Models.Jogador;
import br.imd.Models.Monstro;
import br.imd.Rules.AlreadySummonedMonsterException;
import br.imd.Rules.EffectHasActivatedException;
import br.imd.Rules.NoSpaceZoneException;
import br.imd.Rules.SummonedTributeException;
import br.imd.Constants.PosicaoMonstro;

/**
 * Interface que contém todas as ações/funções que podem ser realizadas 
 * em um duelo com uma carta monstro.
 * @author Iury
 *
 */
public interface iAcoesMonstros {
	
	/**
	 * Função utilizada para invocar um carta monstro da mão jogador atual no 
	 * tabuleiro.
	 * @param monstro o monstro que vai ser invocado.
	 * @param posicao posição de batalha do monstro.
	 * @return posição na qual o monstro foi inserido na zona de monstros.
	 */
	int invocarMonstro(Monstro monstro,  PosicaoMonstro posicaoMonstro) throws SummonedTributeException, NoSpaceZoneException, AlreadySummonedMonsterException;
	
	/**
	 * Funçãoo utilizada para realizar o ataque de um monstro do jogador atual
	 * contro um monstro do proximo jogador.
	 * @param monstroAtacante monstro que vai realizar o ataque.
	 * @param monstroAtacado monstro que vai receber o ataque.
	 */
	void atacar(Monstro monstroAtacante, Monstro monstroAtacado);
	
	/**
	 * Função utilizada para realizar um ataque de um monstro do jogador atual
	 * contra os Pontos de Vida do proximo jogador.
	 * @param monstroAtacante Posicao no tabuleiro do monstro do jogador atacante.
	 */
	void atacarDireto(Monstro monstroAtacante);
	
	/**
	 * Fun��o utilizada para mudar a posi��o de batalha de um monstro do jogador
	 * no tabuleiro.
	 * @param jogador jogador dono do monstro.
	 * @param posicaoCartaTab posicao da carta no tabuleiro.
	 */
	void mudarPosicaoBatalha(Jogador jogador, int posicaoCartaTab);
	
	/**
	 * Ativa o efeito de uma carta de monstro efeito,
	 * @param jogadorAtivou jogador dono da carta que ativou o efeito.
	 * @param cartaAtivou carta monstro efeito que teve o efeito ativado.
	 * @param jogadorAlvo possivel jogador alvo do efeito.
	 * @param cartaAlvo possivel carta alvo do efeito.
	 */
	void ativarEfeitoMonstro(Jogador jogadorAtivou, Carta cartaAtivou, Jogador jogadorAlvo, Carta cartaAlvo) throws EffectHasActivatedException;
}
