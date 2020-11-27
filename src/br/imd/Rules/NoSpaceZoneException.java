package br.imd.Rules;

import java.lang.Exception;
/**
 * Quanto o jogador tentar invocar uma carta mas não tem espaço na zona de monstros.
 * @author Iury
 *
 */
public class NoSpaceZoneException extends Exception{

	public NoSpaceZoneException(String message) {
		super(message);
	}
}
