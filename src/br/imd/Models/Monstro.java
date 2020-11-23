package br.imd.Models;

import br.imd.Constants.CartaLayaout;
import br.imd.Constants.TipoClasse;
import br.imd.Constants.PosicaoMonstro;
import br.imd.Models.Carta;

/**
 * Classe responsavel por representar detalhes comuns das Cartas Monstro.
 * @author Iury
 *
 */
public class Monstro extends Carta {

	private int nivel;
	private int atk;
	private int def;
	private int turnoInvocacao;
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getTurnoInvocacao() {
		return turnoInvocacao;
	}

	public void setTurnoInvocacao(int turnoInvocacao) {
		this.turnoInvocacao = turnoInvocacao;
	}

	public TipoClasse getClasse() {
		return classe;
	}

	public void setClasse(TipoClasse classe) {
		this.classe = classe;
	}

	public PosicaoMonstro getPosicaoMonstro() {
		return posicaoMonstro;
	}

	public void setPosicaoMonstro(PosicaoMonstro posicaoMonstro) {
		this.posicaoMonstro = posicaoMonstro;
	}

	private TipoClasse classe;
	private PosicaoMonstro posicaoMonstro;
	
	public Monstro(String nome, String descricao, CartaLayaout layaout) {
		super(nome, descricao, layaout);
	}

}
