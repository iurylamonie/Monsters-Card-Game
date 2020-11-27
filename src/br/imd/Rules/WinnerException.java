package br.imd.Rules;

import java.lang.Exception;

/**
 *  Quando o jogador inimigo chegar a zero de PV
 * @author Iury
 */
public class WinnerException extends Exception {
	public WinnerException(String message ) {
		super(message);
	}
}
