package br.imd.Models;

import br.imd.Constants.CartaLayaout;
import br.imd.Constants.TipoMagiaEquipamento;
import br.imd.Models.Interfaces.iEfeitosEquipamento;


/**
 * Classe que representa as cartas magicas de equipamentos. A carta se equipa ao monstro
 * dando bonus de atk ou def e s� sai do campo quando o monstro na qual ela � equipada deixa
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
	public void ativarEfeito(Jogador jogadorAtivou, Carta cartaAtivou, Jogador jogadorAlvo, Carta cartaAlvo ) {
		switch(this.tipoEquipamento) {
		case AUMENTAR_ATK:
			this.aumentarATK((Monstro) cartaAlvo);
			break;
		case AUMENTAR_DEF:
			this.aumentarDEF((Monstro) cartaAlvo);
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
	public void aumentarATK( Monstro monstroAlvo ) {
		monstroAlvo.setAtk( monstroAlvo.getAtk() + this.getPontos());
		this.setMonstroEquipado(monstroAlvo);
	}

	@Override
	public void aumentarDEF(Monstro monstroAlvo) {
		monstroAlvo.setDef( monstroAlvo.getDef() + this.getPontos() );
		this.setMonstroEquipado(monstroAlvo);
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
