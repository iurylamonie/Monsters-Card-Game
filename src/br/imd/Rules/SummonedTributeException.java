package br.imd.Rules;

import java.lang.Exception;
/**
 * Quando o jogador invoca um monstro com mais de 4 estrelas.
 * @author Iury
 *
 */
public class SummonedTributeException extends Exception{
	
	private boolean podeInvocar;
	private int quantidadeTributos;
	
	/**
	 * Construtor padrão da classe.
	 * @param message mensagem que desejamos informar
	 * @param podeInvocar true se a carta pode ser invocada, false caso contrario
	 * @param quantidadeTributos quantos monstros no campo são necessarios para invocar essa carta.
	 */
	public SummonedTributeException(String message, boolean podeInvocar, int quantidadeTributos ) {
		super(message);
		this.podeInvocar = podeInvocar;
		this.quantidadeTributos = quantidadeTributos;
	}

	public boolean isPodeInvocar() {
		return podeInvocar;
	}

	public int getQuantidadeTributos() {
		return quantidadeTributos;
	}
	
	
}
