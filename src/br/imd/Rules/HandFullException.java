package br.imd.Rules;

import java.lang.Exception;


/**
 * Quando a mão do jogador estiver com 6 cartas ele não pode mais comprar.
 * @author Iury
 *
 */
public class HandFullException extends Exception {
	public HandFullException(String message ) {
		super(message);
	}
}
