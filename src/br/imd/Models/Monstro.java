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
	
	/**
	 * Construtor padrão da classe monstor. A atributo turnoInvocacao é iniciado com -1.
	 * @param nome Nome da carta.
	 * @param descricao Descrição da carta. Em cartas com efeito deve se informado o que a carta faz e condições de execução.
	 * @param layaout Layaout da carta.
	 * @param nivel Nivel do monstro.
	 * @param atk Ataque do monstro.
	 * @param def Defesa do monstro.
	 * @param classe Classe da carta monstro.
	 * @param posicaoBatalhao Posição de batalha que o monstro está.
	 */
	public Monstro(String nome, String descricao, CartaLayaout layaout,
			       int nivel, int atk, int def,
			       TipoClasse classe, PosicaoMonstro posicaoBatalhao) {
		super(nome, descricao, layaout);
		this.atk = atk;
		this.def = def;
		this.turnoInvocacao = -1;
		this.classe = classe;
		this.posicaoMonstro = posicaoBatalhao;
	}

}
