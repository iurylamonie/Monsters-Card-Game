package br.imd.Controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import br.imd.Constants.Fase;
import br.imd.Models.Jogador;
import br.imd.Models.Tabuleiro;

/**
 * Classe duelo é responsavel pelo geranciamente do duelo assim como na
 * consistencia das regras do jogo.
 * @author Iury
 *
 */
public class Duelo {

	private int turnoAtual;
	private Fase faseAtual;
	private Jogador atualJogador;
	private Jogador proxJogador;
	private boolean invocacaoMonstro;
	private HashMap<Jogador, Tabuleiro> dueladores; 
	
	
	public Duelo(Jogador jogador1, Jogador jogador2) {
		this.dueladores =  new HashMap<Jogador, Tabuleiro>();
		this.dueladores.put(jogador1, new Tabuleiro( jogador1.getBaralho() ));
		this.dueladores.put(jogador2, new Tabuleiro( jogador2.getBaralho() ));
		this.preparacao(jogador1, jogador2);
		this.turnoAtual = 1;
		this.faseAtual = Fase.COMPRA;
		this.invocacaoMonstro = false;
	}
	
	/**
	 * Embaralha o baralho de um jogador.
	 * @param jogador jogador que vai ter o deck embaralhado.
	 */
	public void embaralhar(Jogador jogador) {	
		Tabuleiro tab = this.dueladores.get(jogador);
		Collections.shuffle(tab.getBaralho().getCartas());
	}
	
	/**
	 * Faz toda a preparação inicial do duelo.
	 * @param jogador1 um dos jogadores que vai participar do duelo.
	 * @param jogador2 outro jogador que vai participar do duelo
	 */
	private void preparacao(Jogador jogador1, Jogador jogador2 ) {
		
		this.escolherJogador(jogador1, jogador2);
		this.embaralhar(jogador1);
		this.embaralhar(jogador2);
		this.gerarVida();
		this.compraInicial();
		// FIXME implementar as funções necessarias primeiro. 
	}
	
	/**
	 * Escolhe de forma aleatoria o jogador que vai ser o primeiro a jogar.
	 * @param jogador1 um dos jogadores que vai participar do duelo.
	 * @param jogador2 outro jogador que vai participar do duelo.
	 */
	private void escolherJogador(Jogador jogador1, Jogador jogador2 ) {
		Random escolher = new Random();
		int numJogador = escolher.nextInt(2);
		if(numJogador == 0) {
			this.atualJogador = jogador1;
			this.proxJogador = jogador2;
		}else {
			this.atualJogador = jogador2;
			this.proxJogador = jogador1;
		}
	}
	
	/**
	 * Inicia os pontos de vidas dos dois jogadores com 4.000 pontos.
	 */
	private void gerarVida() {
		this.atualJogador.setPontosVida( 4000 );
		this.proxJogador.setPontosVida( 4000 );
	}
	
	
	/**
	 * Os dois jogadores compram 4 cartas no inicio do duelo.
	 */
	private void compraInicial() {
		Tabuleiro tab = this.dueladores.get(this.atualJogador);
		for( int i = 0; i < 4; i++) {
			tab.comprar();
		}
		
		tab = this.dueladores.get(this.proxJogador);
		for( int i = 0; i < 4; i++) {
			tab.comprar();
		}
		
	}
	
	public int getTurnoAtual() {
		return turnoAtual;
	}
	public void setTurnoAtual(int turnoAtual) {
		this.turnoAtual = turnoAtual;
	}
	public Fase getFaseAtual() {
		return faseAtual;
	}
	public void setFaseAtual(Fase faseAtual) {
		this.faseAtual = faseAtual;
	}
	public Jogador getAtualJogador() {
		return atualJogador;
	}
	public void setAtualJogador(Jogador atualJogador) {
		this.atualJogador = atualJogador;
	}
	public Jogador getProxJogador() {
		return proxJogador;
	}
	public void setProxJogador(Jogador proxJogador) {
		this.proxJogador = proxJogador;
	}
	public boolean isInvocacaoMonstro() {
		return invocacaoMonstro;
	}
	public void setInvocacaoMonstro(boolean invocacaoMonstro) {
		this.invocacaoMonstro = invocacaoMonstro;
	}


	public HashMap<Jogador, Tabuleiro> getDueladores() {
		return dueladores;
	}


	public void setDueladores(HashMap<Jogador, Tabuleiro> dueladores) {
		this.dueladores = dueladores;
	}
	
	
	
	
}
