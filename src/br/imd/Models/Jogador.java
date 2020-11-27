package br.imd.Models;

/**
 * Classe que representa o jogador.
 * @author Iury
 *
 */
public class Jogador {
	
	private int pontosVida;
	private String nome;
	private Baralho baralho;
	
	Jogador(String nome, Baralho baralho){
		this.nome = nome;
		this.setBaralho(baralho);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontosVida() {
		return pontosVida;
	}

	public void setPontosVida(int pontosVida) {
		this.pontosVida = pontosVida;
	}

	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}
	
	
}
