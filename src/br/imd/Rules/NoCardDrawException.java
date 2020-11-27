package br.imd.Rules;

import java.lang.Exception;


/**
 * Quando o jogador vai comprar carta mas ele não tem mais cartas no baralho, ele perde o jogo.
 * @author Iury
 *
 */
public class NoCardDrawException extends Exception{
	
	public NoCardDrawException(String message ) {
		super(message);
	}
	
}
