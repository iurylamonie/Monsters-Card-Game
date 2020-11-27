package br.imd.Rules;

import java.lang.Exception;
/**
 *  Quando um monstro tentar ativar seu efeito, mas o efeito já tinha sido ativado.
 * @author Iury
 *
 */
public class EffectHasActivatedException extends Exception {
	public EffectHasActivatedException(String message ) {
		super(message);
	}
}
