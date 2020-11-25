package br.imd.Models;

import br.imd.Constants.CartaLayaout;
import br.imd.Constants.TipoMagiaEquipamento;
import br.imd.Models.Interfaces.iEfeitosEquipamento;


/**
 * Classe que representa as cartas magicas de equipamentos. A carta se equipa ao monstro
 * dando bonus de atk ou def e só sai do campo quando o monstro na qual ela é equipada deixa
 * o campo.
 * @author Iury
 *
 */
public class MagiaEquipamento extends Magia implements iEfeitosEquipamento {

	private boolean efeitoFoiAtivado;
	private TipoMagiaEquipamento tipoEquipamento;
	private Monstro monstroEquipado;
	
	public MagiaEquipamento(String nome, String descricao, CartaLayaout layaout, int pontos, TipoMagiaEquipamento te) {
		super(nome, descricao, layaout, pontos);
		this.efeitoFoiAtivado = false;
		this.tipoEquipamento = te;
		this.monstroEquipado = null;
	}

	@Override
	public void ativarEfeito(Jogador jogadorAtivou, int posicaoCartaAtivou, Jogador jogadorAlvo, int posicaoCartaAlvo) {
		switch(this.tipoEquipamento) {
		case AUMENTAR_ATK:
			this.aumentarATK(jogadorAlvo, posicaoCartaAlvo);
			break;
		case AUMENTAR_DEF:
			this.aumentarDEF(jogadorAlvo, posicaoCartaAlvo);
			break;
		}

	}

	@Override
	public void desativarEfeito() {
		
		switch(this.tipoEquipamento) {
		case AUMENTAR_ATK:
			this.monstroEquipado.setAtk(this.monstroEquipado.getAtk() - this.getPontos());
			break;
		case AUMENTAR_DEF:
			this.monstroEquipado.setDef(this.monstroEquipado.getDef() - this.getPontos());
			break;
		}
		
	}

	@Override
	public void aumentarATK(Jogador jogador, int posicaoCartaTab) {
		this.monstroEquipado = jogador.getTabuleiro().getCampo().getEspacoMonstro(posicaoCartaTab);
		this.monstroEquipado.setAtk(this.monstroEquipado.getAtk() + this.getPontos());
	}

	@Override
	public void aumentarDEF(Jogador jogador, int posicaoCartaTab) {
		this.monstroEquipado = jogador.getTabuleiro().getCampo().getEspacoMonstro(posicaoCartaTab);
		this.monstroEquipado.setDef(this.monstroEquipado.getDef() - this.getPontos());
	}
	
	public Monstro getMonstroEquipado() {
		return monstroEquipado;
	}

	public void setMonstroEquipado(Monstro monstroEquipado) {
		this.monstroEquipado = monstroEquipado;
	}

	public boolean isEfeitoFoiAtivado() {
		return efeitoFoiAtivado;
	}

	public void setEfeitoFoiAtivado(boolean efeitoFoiAtivado) {
		this.efeitoFoiAtivado = efeitoFoiAtivado;
	}

	public TipoMagiaEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoMagiaEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

}
