package br.imd.Models;

import java.util.Vector;

import br.imd.Constants.PosicaoMonstro;
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
	
	/**
	 * Ativa o efeito de uma marca magica no campo.
	 * @param jogadorAtivou jogador que ativou o efeito.
	 * @param posicaoCartaAtivou posição da carta magica na zona de magias.
	 */
	public void ativarEfeitoMagia(Jogador jogadorAtivou, int posicaoCartaAtivou, Jogador  jogadorAlvo, int posicaoCartaAlvo) {
		//Carta cartaMagia = this.campo.getEspacoMagia( posicaoCartaAtivou );
		// TODO precisa das cartas Magias Feitas
	}
	
	/**
	 * Muda a posição de um monstro localizado em uma determinada posição
	 * na zona de monstros.
	 * @param posicaoMonstroCamp
	 */
	public void mudarPosicao(int posicaoMonstroCamp ) {
		
		PosicaoMonstro pm = this.campo.getEspacoMonstro(posicaoMonstroCamp).getPosicaoMonstro();
		switch(pm) {
		case ATAQUE:
			this.campo.getEspacoMonstro(posicaoMonstroCamp).setPosicaoMonstro(PosicaoMonstro.DEFESA);
			break;
		case DEFESA:
			this.campo.getEspacoMonstro(posicaoMonstroCamp).setPosicaoMonstro(PosicaoMonstro.ATAQUE);
			break;
		case NAO_INVOCADO:
			//TODO o que fazer quando o monstro não teve seu campo alterado?
			break;
		}
		
	}
	
	/**
	 * Envia uma carta que está localizada no campo para o cemiterio.
	 * @param posicaoCartaCamp
	 */
	public void enviarCemiterio( Carta carta, int posicaoCamp ) {
		
		this.cemiterio.add(carta);
		
		if( carta instanceof Monstro ) {
			this.campo.setEspacoMonstro(null, posicaoCamp);
		}
		else if( carta instanceof Magia ) {
			this.campo.setEspacoMagia(null, posicaoCamp);
		}
	}
	
	/**
	 * Coloca no tabuleiro um mostro localizado em um determinada posição da mão.
	 * @param monstro a posição determinada.
	 */
	public void colocarMostroTabuleiro(int monstro) {
		Carta cm = this.maoJogador.remove(monstro);
		int espacoVazio = this.campo.espacoZonaMonstroVazio();
		this.campo.setEspacoMonstro((Monstro) cm, espacoVazio);	
	}
	
	/**
	 * Coloca no tabuleiro uma magia localizado em um determinada posição da mão.
	 * @param monstro a posição determinada.
	 */
	public void colocarMagiaTabuleiro(int magia) {
		Carta cm = this.maoJogador.remove(magia);
		int espacoVazio = this.campo.espacoZonaMagiaVazio();
		this.campo.setEspacoMagia((Magia) cm, espacoVazio);
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
