package br.imd.Models;

public class Jogador {
	private int pontosVida;
	private String nome;
	private Tabuleiro tabuleiro;
	
	Jogador(String nome, Baralho baralho){
		this.pontosVida = 0;
		this.nome = nome;
		tabuleiro = new Tabuleiro(baralho);
	}
	
	public int getPontosVida() {
		return pontosVida;
	}

	public void setPontosVida(int pontosVida) {
		this.pontosVida = pontosVida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void invocarMonstro(int monstro) {
		
	}
	
	public void invocarMagia(MagiaNormal magia) {
			
	}
	
	public void mudarPosicaoBatalha(Monstro carta) {
		
	}
}
