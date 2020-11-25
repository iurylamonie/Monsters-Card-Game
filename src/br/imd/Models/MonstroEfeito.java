package br.imd.Models;

import br.imd.Models.Interfaces.iEfeitosMonstros;
import br.imd.Constants.CartaLayaout;
import br.imd.Constants.PosicaoMonstro;
import br.imd.Constants.TipoClasse;
import br.imd.Constants.TipoEfeitoMonstro;

/**
 * Classe que representa as Cartas de Monstro que possuem efeito.
 * @author Iury
 *
 */
public class MonstroEfeito extends Monstro implements iEfeitosMonstros {

	private boolean efeitoPassivo;
	private TipoEfeitoMonstro tipoEfeito;
	private int pontos;

	/**
	 * Construtor padrão da classe MonstroEfeito.
	 * @param nome
	 * @param descricao
	 * @param layaout
	 * @param nivel
	 * @param atk
	 * @param def
	 * @param classe
	 * @param posicaoBatalhao
	 */
	public MonstroEfeito(String nome, String descricao, CartaLayaout layaout, int nivel, int atk, int def,
			TipoClasse classe, PosicaoMonstro posicaoBatalhao, boolean efeitoPassivo, TipoEfeitoMonstro tipoEfeito,
			int pontos) {
		super(nome, descricao, layaout, nivel, atk, def, classe, posicaoBatalhao);
		this.efeitoPassivo = efeitoPassivo;
		this.tipoEfeito = tipoEfeito;
		this.pontos = pontos;
	}
	
	/**
	 * Ativa o efeito do monstro de acordo com o tipo de efeito do monstro.
	 * @param jogadorAtivou jogador que é dono da carta monstro que o ativou.
	 * @param posicaoCartaAtivou posicao da carta que o efeito foi ativado.
	 * @param jogadorAlvo possivel jogador alvo do efeito da carta monstro.
	 * @param posicaoCartaAlvo possivel posicao da carta que foi alvo do efeito da carta monstro.
	 */
	@Override
	public void ativarEfeito(Jogador jogadorAtivou, int posicaoCartaAtivou, Jogador  jogadorAlvo, int posicaoCartaAlvo) {
	
		switch(this.tipoEfeito) {
		
		case AUMENTAR_PROPRIA_DEF:
			this.aumentarProprioDEF();
			break;
		
		case AUMENTAR_PROPRIO_ATK:
			this.aumentarProprioATK();
			break;
		
		case DIMINUIR_ATK_INIMIGO:
			this.diminuirATKInimigo(jogadorAlvo, posicaoCartaAlvo);
			break;
		
		case DIMINUIR_DEF_INIMIGO:
			this.diminuirDEFInimigo(jogadorAlvo, posicaoCartaAtivou);
			break;
		}
		
	}

	/**
	 * Desativa os efeitos de aumentar proprio ataque e defesa de um monstro.
	 */
	@Override
	public void desativarEfeito() {
		
		switch(this.tipoEfeito) {
		
		case AUMENTAR_PROPRIA_DEF:
			this.setDef( this.getDef() - this.pontos );
			break;
		
		case AUMENTAR_PROPRIO_ATK:
			this.setAtk( this.getAtk() - this.pontos );
			break;
		default:
			//TODO o que fazer com as outras situações? Como o de diminuir algo do inimigo.
			break;
		}
		
	}
	
	/**
	 * Aumenta o ataque do monstro de acordo com o valor que o monstro possue em seu atributo pontos.
	 */
	@Override
	public void aumentarProprioATK() {
		this.setAtk( this.getAtk() + this.pontos );
		
	}

	/**
	 * Aumenta a defesa do monstro de acordo com o valor que o monstro possue em seu atributo pontos.
	 */
	@Override
	public void aumentarProprioDEF() {
		this.setDef( this.getDef() + this.pontos );
		
	}

	/**
	 * Diminui o ataque de uma carta monstro localizada no tabuleiro de acordo com o valor que o monstro
	 * que ativou o efeito possue em seu atributo pontos.
	 * @param jogador jogador alvo da diminuição de pontos.
	 * @param posicaoCartaTab posição da carta monstro alvo localizada no tabuleiro.
	 */
	@Override
	public void diminuirATKInimigo(Jogador jogador, int posicaoCartaTab) {
		// TODO é necessario ter as classe tabuleiro e jogador implementadas.
		
	}
	
	/**
	 * Diminui o ataque de uma carta monstro localizada no tabuleiro de acordo com o valor que o monstro
	 * que ativou o efeito possue em seu atributo pontos
	 * @param jogador jogador alvo da diminuição de pontos.
	 * @param posicaoCartaTab posição da carta monstro alvo localizada no tabuleiro.
	 */
	@Override
	public void diminuirDEFInimigo(Jogador jogador, int posicaoCartaTab) {
		// TODO é necessario ter as classes tabuleiro e jogador implementadas.
		
	}

	public boolean isEfeitoPassivo() {
		return efeitoPassivo;
	}

	public void setEfeitoPassivo(boolean efeitoPassivo) {
		this.efeitoPassivo = efeitoPassivo;
	}

	public TipoEfeitoMonstro getTipoEfeito() {
		return tipoEfeito;
	}

	public void setTipoEfeito(TipoEfeitoMonstro tipoEfeito) {
		this.tipoEfeito = tipoEfeito;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	

}
