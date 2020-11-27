package br.imd.Models;

import java.util.Vector;
/**
 * Representa o tabuleiro de um jogador dentro de um duelo.
 * @author Iury
 *
 */
public class Tabuleiro {
	
	
	private Vector<Carta> cemiterio;
	private Vector<Carta> maoJogador;
	private Baralho baralho;
	private Campo campo;

	/**
	 * Inicializa o tabuleiro com o baralho escolhido pelo jogador.
	 * @param baralho baralho escolhido.
	 */
	public Tabuleiro(Baralho baralho){
		this.cemiterio = new Vector<Carta>();
		this.maoJogador = new Vector<Carta>();
		this.baralho = baralho;
		this.campo = new Campo();
	}
	
	

	/**
	 * Remove uma carta do topo do baralho e adiciona na mão do jogador. 
	 */
	public void comprar() {
		
		Carta carta = this.baralho.getCartas().pop();
		this.inserirCartaMao(carta);
	}
	
	/**
	 * Insere uma carta na mão do jogador e seta 
	 * a localização da carta na mão.
	 * @param carta carta que vai ser inserida na mão.
	 */
	public void inserirCartaMao( Carta carta ) {
		this.maoJogador.add(carta);
		carta.setLocalizacao( this.maoJogador.size() - 1);
	}
	
	/**
	 * Remove uma determina carta da mão do jogador.
	 * @param posicao posição na mão da carta que vai ser removida
	 * @return a carta removida da mão.
	 */
	public Carta removerCartaMao(int posicao ) {
		Carta carta = this.maoJogador.remove(posicao);
		carta.setLocalizacao(-1);
		return carta;
	}
	
	/**
	 * Adiciona uma carta no cemiterio do joador.
	 * @param carta carta que vai ser inserida.
	 */
	public void inserCartaCemiterio( Carta carta ) {
		this.cemiterio.add(carta);
	}
	
	/**
	 * Remove uma determinada carta do cemiterio.
	 * @param posicao posição da carta no cemiterio.
	 * @return a carta removida do cemiterio.
	 */
	public Carta removerCartaCemiterio( int posicao ) {
		Carta carta = this.cemiterio.remove(posicao);
		return carta;
	}
	
	public Vector<Carta> getCemiterio() {
		return cemiterio;
	}



	public void setCemiterio(Vector<Carta> cemiterio) {
		this.cemiterio = cemiterio;
	}



	public Vector<Carta> getMaoJogador() {
		return maoJogador;
	}



	public void setMaoJogador(Vector<Carta> maoJogador) {
		this.maoJogador = maoJogador;
	}



	public Baralho getBaralho() {
		return baralho;
	}



	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}



	public Campo getCampo() {
		return campo;
	}



	public void setCampo(Campo campo) {
		this.campo = campo;
	}
	
	
	
}
