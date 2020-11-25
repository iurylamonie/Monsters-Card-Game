package br.imd.Models;

/**
 * Classe que representa o jogador.
 * @author Iury
 *
 */
public class Jogador {
	
	private int pontosVida;
	private String nome;
	private Tabuleiro tabuleiro;
	
	Jogador(String nome, Baralho baralho){
		this.pontosVida = 0;
		this.nome = nome;
		this.tabuleiro = new Tabuleiro(baralho);
	}
	
	/**
	 * Coloca um carta monstro localizada na mão do jogador
	 * em um espaço vazio na zona de monstros.
	 * @param monstro a posição da carta monstro na mão do jogador.
	 */
	public void invocarMonstro(int monstro) {
		this.tabuleiro.colocarMostroTabuleiro(monstro);
	}
	
	/**
	 * Coloca um carta monstro localizada na mão do jogador
	 * em um espaço vazio na zona de monstros.
	 * @param magia a posição da carta magica na mão do jogador.
	 */
	public void invocarMagia(int magia) {
		this.tabuleiro.colocarMagiaTabuleiro(magia);
	}
	
	
	public void mudarPosicaoBatalha(Monstro carta) {
		this.tabuleiro.mudarPosicao(carta.getLocalizacaoTabuleiro());
	}

	public void comprarCarta() {
		this.tabuleiro.comprar();
	}
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
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
}
