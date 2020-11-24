package br.imd.Models;

import java.util.Vector;

import br.imd.Models.Monstro;
import br.imd.Models.Carta;
import br.imd.Models.Campo;
import br.imd.Models.Jogador;
import br.imd.Models.Magia;

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
		Carta carta = this.baralho.getCartas().peek();
		this.maoJogador.add(carta);
		this.baralho.getCartas().pop();
	}
	
	/**
	 * Ativa o efeito de um monstro localizado no campo de acordo 
	 * com o tipo de efeito do monstro.
	 * @param jogadorAtivou jogador que é dono da carta monstro que o ativou.
	 * @param posicaoCartaAtivou posicao da carta que o efeito foi ativado.
	 * @param jogadorAlvo possivel jogador alvo do efeito da carta monstro.
	 * @param posicaoCartaAlvo possivel posicao da carta que foi alvo do efeito da carta monstro.
	 */
	public void ativarEfeitoMostro(Jogador jogadorAtivou, int posicaoCartaAtivou, Jogador  jogadorAlvo, int posicaoCartaAlvo) {
		Carta cartaEfeito = this.campo.getEspacoMonstro(posicaoCartaAtivou );
		if( cartaEfeito instanceof MonstroEfeito ) {
			((MonstroEfeito) cartaEfeito).ativarEfeito(jogadorAtivou, posicaoCartaAtivou, jogadorAlvo, posicaoCartaAlvo);
		}
	}
	
	public void ativarEfeitoMagia(Magia magia) {
		
	}
	
	public void mudarPosicao(Monstro monstro) {
		
	}
	
	public void enviarCemiterio(Carta carta) {
		
	}
	
	public void colocarMostroTabuleiro(int monstro) {
		
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
	
	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}
}
