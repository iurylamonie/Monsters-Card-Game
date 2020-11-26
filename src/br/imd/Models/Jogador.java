package br.imd.Models;

/**
 * Classe que representa o jogador.
 * @author Iury
 *
 */
public class Jogador {
	
	private String nome;
	private Tabuleiro tabuleiro;
	
	Jogador(String nome, Baralho baralho){
		this.nome = nome;
		this.tabuleiro = new Tabuleiro(baralho);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	
}
