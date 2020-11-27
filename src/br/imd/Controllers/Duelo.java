package br.imd.Controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import br.imd.Constants.Fase;
import br.imd.Constants.PosicaoMonstro;
import br.imd.Models.Campo;
import br.imd.Models.Carta;
import br.imd.Models.Jogador;
import br.imd.Models.Monstro;
import br.imd.Models.MonstroEfeito;
import br.imd.Models.Tabuleiro;
import br.imd.Models.Interfaces.iAcoesMonstros;
import br.imd.Rules.AlreadySummonedMonsterException;
import br.imd.Rules.EffectHasActivatedException;
import br.imd.Rules.HandFullException;
import br.imd.Rules.NoCardDrawException;
import br.imd.Rules.NoSpaceZoneException;
import br.imd.Rules.NotChangeBattlePositionException;
import br.imd.Rules.SummonedTributeException;
import br.imd.Rules.WinnerException;

/**
 * Classe duelo é responsavel pelo geranciamente do duelo assim como na
 * consistencia das regras do jogo.
 * @author Iury
 *
 */
public class Duelo implements iAcoesMonstros{

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
	
	/*
	 * Funções da interface iAcoesMonstro
	 * */
	
	@Override
	public int invocarMonstro(Monstro monstro, PosicaoMonstro posicaoMonstro)
			throws SummonedTributeException, NoSpaceZoneException, AlreadySummonedMonsterException {
		int pos = -1;
		
		Tabuleiro tab = this.dueladores.get(this.atualJogador);
		Campo camp = tab.getCampo();
		if(this.invocacaoMonstro == false) {
			
			if( camp.quantidadeCartaMonstro() != 3 ) {
				
				if( monstro.getNivel() <= 4 ) {
					pos = camp.espacoLivreZonaMonstro();
					camp.inserirCartaMonstro(monstro, pos);
					camp.mudarAtivacaoEfeito(pos, false);
				} else if( monstro.getNivel() <= 7 ) {
					
					if( camp.quantidadeCartaMonstro() >= 2 ) {
						throw new SummonedTributeException("Você precisa tributar 2 monstros da sua zona de monstros para invocar essa carta.", true, 2);
					} else throw new SummonedTributeException("Você precisa ter 2 monstros na sua zona de monstros e tributalos para invocar essa carta.", false, 2);
					
				} else {
					
					if( camp.quantidadeCartaMonstro() == 3 ) {
						throw new SummonedTributeException("Você precisa tributar 3 monstros da sua zona de monstros para invocar essa carta.", true, 3);
					} else throw new SummonedTributeException("Você precisa ter 3 monstros na sua zona de monstros e tributalos para invocar essa carta.", false, 2);
				}
				
			} else throw new NoSpaceZoneException("O monstro " + monstro.getNome() + " não pode ser invocado porque " + this.atualJogador.getNome() + " não tem espaço na zona de monstros.");
			
		} else throw new AlreadySummonedMonsterException("O monstro " + monstro.getNome() + " não pode ser invocado porque " + this.atualJogador.getNome() + " já invocou monstro nesse turno.");
		
		return pos;
	}
	
	@Override
	public int invocarMonstroTributo(Monstro monstro, Vector<Monstro> tributos) {
		int pos = -1;
		
		Tabuleiro tab = this.dueladores.get(this.atualJogador);
		Campo camp = tab.getCampo();
		
		for( Monstro tributo : tributos) {
			if( tributo instanceof MonstroEfeito ) ((MonstroEfeito) tributo).desativarEfeito();
			camp.mudarAtivacaoEfeito(tributo.getLocalizacao(), false);
			tributo = camp.removerCartaMonstro( tributo.getLocalizacao() );
			tab.inserCartaCemiterio(tributo);
		}
		
		pos = camp.espacoLivreZonaMonstro();
		camp.inserirCartaMonstro(monstro, pos);
		camp.mudarAtivacaoEfeito(pos, false);
		
		return pos;
	}

	@Override
	public void atacar(Monstro monstroAtacante, Monstro monstroAtacado) throws WinnerException {
		
		Tabuleiro tabAtacante = this.dueladores.get(this.atualJogador);
		Campo campAtacante = tabAtacante.getCampo();
		
		Tabuleiro tabAtacado = this.dueladores.get(this.proxJogador);
		Campo campAtacado = tabAtacado.getCampo();
		
		switch(monstroAtacado.getPosicaoMonstro()) {
		case ATAQUE:
			
			if( monstroAtacante.getAtk() > monstroAtacado.getAtk() ) {
				
				this.proxJogador.setPontosVida( this.proxJogador.getPontosVida() - (monstroAtacante.getAtk() - monstroAtacado.getAtk()));
				
				if( this.proxJogador.getPontosVida() <= 0 ) this.vencedor(this.atualJogador, "VENCEDOR: " + this.atualJogador.getNome() + "! Reduziu a vida do seu oponente a cinzas!");
				
				if( monstroAtacado instanceof MonstroEfeito ) ((MonstroEfeito) monstroAtacado).desativarEfeito();
				
				campAtacado.mudarAtivacaoEfeito(monstroAtacado.getLocalizacao(), false);
				monstroAtacado = campAtacado.removerCartaMonstro( monstroAtacado.getLocalizacao() );
				tabAtacado.inserCartaCemiterio(monstroAtacado);
				
			} else if( monstroAtacante.getAtk() < monstroAtacado.getAtk() ) {
				
				this.atualJogador.setPontosVida( this.atualJogador.getPontosVida() - (monstroAtacado.getAtk() - monstroAtacante.getAtk()));
				
				if( this.atualJogador.getPontosVida() <= 0 ) this.vencedor(this.proxJogador, "VENCEDOR: " + this.proxJogador.getNome() + "! Reduziu a vida do seu oponente a cinzas!");
				
				if( monstroAtacante instanceof MonstroEfeito ) ((MonstroEfeito) monstroAtacante).desativarEfeito();
				
				campAtacante.mudarAtivacaoEfeito(monstroAtacante.getLocalizacao(), false);
				monstroAtacante = campAtacado.removerCartaMonstro( monstroAtacante.getLocalizacao() );
				tabAtacante.inserCartaCemiterio(monstroAtacante);
				
			} else {
				
				if( monstroAtacado instanceof MonstroEfeito ) ((MonstroEfeito) monstroAtacado).desativarEfeito();
				campAtacado.mudarAtivacaoEfeito(monstroAtacado.getLocalizacao(), false);
				monstroAtacado = campAtacado.removerCartaMonstro( monstroAtacado.getLocalizacao() );
				tabAtacado.inserCartaCemiterio(monstroAtacado);
				
				if( monstroAtacante instanceof MonstroEfeito ) ((MonstroEfeito) monstroAtacante).desativarEfeito();
				campAtacante.mudarAtivacaoEfeito(monstroAtacante.getLocalizacao(), false);
				monstroAtacante = campAtacado.removerCartaMonstro( monstroAtacante.getLocalizacao() );
				tabAtacante.inserCartaCemiterio(monstroAtacante);			
			}
			
			break;
		case DEFESA:
			
			if(monstroAtacante.getAtk() > monstroAtacado.getDef()) {
				if( monstroAtacado instanceof MonstroEfeito ) ((MonstroEfeito) monstroAtacado).desativarEfeito();
				campAtacado.mudarAtivacaoEfeito(monstroAtacado.getLocalizacao(), false);
				monstroAtacado = campAtacado.removerCartaMonstro( monstroAtacado.getLocalizacao() );
				tabAtacado.inserCartaCemiterio(monstroAtacado);
			}else if ( monstroAtacante.getAtk() < monstroAtacado.getDef() ) {
				this.atualJogador.setPontosVida( this.atualJogador.getPontosVida() - (monstroAtacado.getDef() - monstroAtacante.getAtk()));
				if( this.atualJogador.getPontosVida() <= 0 ) this.vencedor(this.proxJogador, "VENCEDOR: " + this.proxJogador.getNome() + "! Reduziu a vida do seu oponente a cinzas!");
			}
			
			break;
		case NAO_INVOCADO:
			break;
		}
		
		
		
	}

	@Override
	public void atacarDireto(Monstro monstroAtacante) throws WinnerException {
		this.proxJogador.setPontosVida( this.proxJogador.getPontosVida() - monstroAtacante.getAtk());
		
		if( this.proxJogador.getPontosVida() <= 0 ) this.vencedor(this.atualJogador, "VENCEDOR: " + this.atualJogador.getNome() + "! Reduziu a vida do seu oponente a cinzas!");	
	}

	@Override
	public void mudarPosicaoBatalha(Monstro monstro) throws NotChangeBattlePositionException {
		
		if(this.faseAtual != Fase.BATALHA) {
			
			if(monstro.getTurnoInvocacao() != this.turnoAtual ) {
				if(monstro.getPosicaoMonstro() == PosicaoMonstro.ATAQUE ) {
					monstro.setPosicaoMonstro(PosicaoMonstro.DEFESA);
				} else monstro.setPosicaoMonstro(PosicaoMonstro.ATAQUE);
			} else throw new NotChangeBattlePositionException("O monstro " + monstro.getNome() + " não pode mudar de posição no turno que é invocado.");
		
		} else throw new NotChangeBattlePositionException("O monstro " + monstro.getNome() + " não pode mudar de posição de batalha durante a Fase de Batalha.");
		
	}

	@Override
	public void ativarEfeitoMonstro(Jogador jogadorAtivou, Carta cartaAtivou, Jogador jogadorAlvo, Carta cartaAlvo)
			throws EffectHasActivatedException {
		int pos = cartaAtivou.getLocalizacao();
		Tabuleiro tab = this.dueladores.get(jogadorAtivou);
				
		if( !tab.getCampo().checarAtivacaoEfeito(pos) ) {
			
			((MonstroEfeito) cartaAtivou).ativarEfeito(jogadorAtivou, cartaAtivou, jogadorAlvo, cartaAlvo );
			tab.getCampo().mudarAtivacaoEfeito(pos, true);
			
		} else throw new EffectHasActivatedException("O monstro " + cartaAtivou.getNome() + " não pode ativar seu efeito, pois já tinha ativado.");
		
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
