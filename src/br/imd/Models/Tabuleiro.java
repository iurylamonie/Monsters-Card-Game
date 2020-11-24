package br.imd.Models;

import java.util.Vector;

public class Tabuleiro {
	private Vector<Carta> cemiterio;
	private Vector<Carta> maoJogador;
	private Baralho baralho;
	
	Tabuleiro(Baralho baralho){
		this.cemiterio = new Vector<Carta>();
		this.maoJogador = new Vector<Carta>();
		this.baralho = baralho;
	}
	
	public Vector<Carta> getCemiterio() {
		return this.cemiterio;
	}

	public void setCemiterio(Carta carta) {
		this.cemiterio.add(carta);
	}

	public Vector<Carta> getMaoJogador() {
		return this.maoJogador;
	}

	public void setMaoJogador(Carta carta) {
		this.maoJogador.add(carta);
	}

	public Baralho getBaralho() {
		return this.baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}

	public Vector<Carta> comprar() {
		//todo
	}
	
	public void ativarEfeitoMostro(Monstro mostro) {
		
	}
	
	public void ativarEfeitoMagia(MagiaNormal magia) {
		
	}
	
	public void mudarPosicao(Monstro monstro) {
		
	}
	
	public void enviarCemiterio(Carta carta) {
		
	}
	
	public void colocarMostroTabuleiro(int monstro) {
		
	}
}
