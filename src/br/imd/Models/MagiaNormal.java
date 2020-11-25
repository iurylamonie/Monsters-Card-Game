package br.imd.Models;

import br.imd.Constants.CartaLayaout;
import br.imd.Constants.TipoMagiaNormal;
import br.imd.Models.Interfaces.iEfeitosMagias;

/**
 * Classe que representa as magias normais de jogo, ou seja magias que o
 * efeito é utilizado e logo em seguida essa carta magica vai para o cemiterio.
 * @author Iury
 *
 */
public class MagiaNormal extends Magia implements iEfeitosMagias {
	
	private TipoMagiaNormal tipo;

	public MagiaNormal(String nome, String descricao, CartaLayaout layaout, int pontos, TipoMagiaNormal tipo) {
		super(nome, descricao, layaout, pontos);
		this.tipo = tipo;
	}

	
	@Override
	public void ativarEfeito(Jogador jogadorAtivou, Carta cartaAtivou, Jogador jogadorAlvo, Carta cartaAlvo) {
		switch(this.tipo) {
		case GANHAR_VIDA:
			this.ganharPV(jogadorAlvo);
			break;
		case PERDER_VIDA:
			this.perderPV(jogadorAlvo);
			break;
		}

	}

	@Override
	public void desativarEfeito() {
		// TODO não é necessario desativar efeitos de ganhar ou perder pv.

	}

	@Override
	public void ganharPV(Jogador jogador) {
		jogador.setPontosVida( jogador.getPontosVida() + this.getPontos() );
	}

	@Override
	public void perderPV(Jogador jogador) {
		jogador.setPontosVida( jogador.getPontosVida() - this.getPontos() );
	}
	
	public TipoMagiaNormal getTipo() {
		return tipo;
	}

	public void setTipo(TipoMagiaNormal tipo) {
		this.tipo = tipo;
	}

}
