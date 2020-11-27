package br.imd.Rules;

import java.lang.Exception;
/**
 * O monstro não pode mudar de posição de batalha durante a Fase de Batalha o no turno que é invocado.
 * @author Iury
 *
 */
public class NotChangeBattlePositionException extends Exception {
	
	public NotChangeBattlePositionException(String message ) {
		super(message);
	}
}
