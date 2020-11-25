package br.imd.Models;

import br.imd.Constants.CartaLayaout;

/**
 * Classe abastrata que representa uma Carta do jogo.
 * @author Iury
 *
 */
public abstract class Carta {
	
	
	private String nome;
	private String descricao;
	private CartaLayaout layaout;
	private int localizacao;
	
	/**
	 * Construtor padrão da classe Carta.
	 * @param nome Nome da carta.
	 * @param descricao Descrição da carta. Em cartas com efeito deve se informado o que a carta faz e condições de execução.
	 * @param layaout Layaout da carta.
	 */
	public Carta( String nome, String descricao, CartaLayaout layaout) {
		this.nome = nome;
		this.descricao = descricao;
		this.layaout = layaout;
		this.localizacao = -1;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CartaLayaout getLayaout() {
		return layaout;
	}

	public void setLayaout(CartaLayaout layaout) {
		this.layaout = layaout;
	}

	public int getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(int localizacaoTabuleiro) {
		this.localizacao = localizacaoTabuleiro;
	}
}
