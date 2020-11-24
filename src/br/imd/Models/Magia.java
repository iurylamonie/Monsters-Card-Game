package br.imd.Models;

import br.imd.Constants.CartaLayaout;
import br.imd.Models.Carta;

/**
 * Classe responsavel por representar detalhes comuns das Cartas Magicas.
 * @author Iury
 *
 */
public abstract class Magia extends Carta {

	private int pontos;
	
	public Magia(String nome, String descricao, CartaLayaout layaout, int pontos) {
		super(nome, descricao, layaout);
		// TODO Auto-generated constructor stub
		this.pontos = pontos;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	
}
