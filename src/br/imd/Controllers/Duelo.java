package br.imd.Controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import br.imd.Constants.Fase;
import br.imd.Models.Jogador;
import br.imd.Models.Tabuleiro;
import br.imd.Rules.HandFullException;
import br.imd.Rules.NoCardDrawException;
import br.imd.Rules.WinnerException;

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
		this.faseAtual = Fase.PRINCIPAL;
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
	 * Passa para o proximo turno, muda o mandante do turno e
	 * troca a fase atual para a Fase de Compra..
	 */
	public void passarTurno() throws NoCardDrawException, HandFullException  {
		this.turnoAtual++;
		
		Jogador temp = this.atualJogador;
		this.atualJogador = this.proxJogador;
		this.proxJogador = temp;
		
		this.faseAtual = Fase.COMPRA;
		this.proximaFase(this.faseAtual);
	}
	
	/**
	 * Passa para a proxima fase e retorna essa proxima fase.
	 * @param faseAtual a fase que o jogador está atualmente.
	 * @return a proxima fase
	 */
	public Fase proximaFase(Fase faseAtual) throws NoCardDrawException, HandFullException {
		switch(faseAtual) {
		case COMPRA:
			this.comprarCarta(this.atualJogador);
			this.faseAtual = Fase.PRINCIPAL;
			break;
		case PRINCIPAL:
			this.faseAtual = Fase.BATALHA;
			break;
		case BATALHA:
			this.passarTurno();	
			break;
		}
		return this.faseAtual;
	}
	
	/**
	 * Compra uma carta da baralho e coloca na mão do jogador.
	 * @param jogador jogador que vai comprar a carta.
	 */
	public void comprarCarta(Jogador jogador) throws NoCardDrawException, HandFullException {
	
		Tabuleiro tab = this.dueladores.get(jogador);
		
		if( tab.getBaralho().getCartas().size() != 0) {
			
			if( tab.getMaoJogador().size() != 6 ) {
				
				tab.comprar();
				
			} else throw new HandFullException("O jogador " + jogador.getNome() + " está com o limite de cartas na mão. Nesse turno não pode comprar." );
			
		} else throw new NoCardDrawException("O jogador " + jogador.getNome() + " não possue cartas no baralho para comprar.");
	}
	
	/**
	 * O jogador desiste do duelo e dá a vitoria para o oponente.
	 * @param jogador jogador que desistiu do duelo;
	 */
	public void desistirDuelo(Jogador jogador) throws WinnerException {

		this.vencedor(this.proxJogador, "O jogador " + jogador.getNome() + " desistiu do duelo!");
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
	
	/**
	 * Passa para o sistema qual jogador venceu o duelo.
	 * @param vencedor o vencedor do duelo.
	 */
	private void vencedor( Jogador vencedor, String message ) throws WinnerException {
		throw new WinnerException("O jogador " + vencedor.getNome() + " venceu o duelo! " + message);
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
