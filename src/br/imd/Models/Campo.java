package br.imd.Models;

import br.imd.Constants.PosicaoMonstro;

/**
 * Representa o campo do jogador em um tabuleiro.
 * @author Iury
 *
 */
public class Campo {

	private Monstro zonaMonstros[];
	private Magia zonaMagia[];
	private boolean zonaEfeitosMonstros[];
	
	
	/**
	 * Inicializa os espa�os de zonas do campo. Com tamanho 3 para cada zona.
	 */
	public Campo() {
		this.zonaMagia = new Magia[3];
		this.zonaMonstros = new Monstro[3];
		this.zonaEfeitosMonstros = new boolean[3];
		for(int i = 0; i < 3; i++ ) {
			this.zonaEfeitosMonstros[i] = false;
		}
	}
	
	/**
	 * Retorna um inteiro para o primeira espaço livre na zona de Monstros.
	 * Retorna -1 caso tenha um espaço livre.
	 * @return int para a posição livre.
	 */
	public int espacoLivreZonaMonstro() {
		if( this.zonaMonstros[0] == null ) return 0;
		else if( this.zonaMonstros[1] == null ) return 1;
		else if( this.zonaMonstros[2] == null ) return 2;
		
		return -1;
	}
	
	/**
	 * Retorna um inteiro para o primeira espaço livre na zona de magias.
	 * Retorna -1 caso tenha uma espaço livre.
	 * @return inteiro
	 */
	public int espacoLivreZonaMagia() {
		if( this.zonaMagia[0] == null ) return 0;
		else if( this.zonaMagia[1] == null ) return 1;
		else if( this.zonaMagia[2] == null ) return 2;
		
		return -1;
	}
	
	/**
	 * Adiciona uma carta monstro em uma localização determinada na zona de monstros.
	 * @param monstro carta monstro a ser adicionada na zona de monstros
	 * @param posicao localização que a carta deve ser adicionada.
	 */
	public void inserirCartaMonstro( Monstro monstro, int posicao) {
		this.zonaMonstros[posicao] = monstro;
		if(monstro != null )monstro.setLocalizacao(posicao);
	}
	
	/**
	 * Adiciona uma carta de magia em uma localização determinada na zona de magias.
	 * @param magia carta de magia a ser adicionada na zona de magias
	 * @param posicao localização que a carta deve ser adicionada.
	 */
	public void inserirCartaMagia( Magia magia, int posicao) {
		this.zonaMagia[posicao] = magia;
		if( magia != null )magia.setLocalizacao(posicao);
	}
	
	/**
	 * Retira a carta monstro de um determinado espaço na zona de monstros e
	 * e deixa o espaço livre.
	 * @param posicao posição do monstro que desejamos remover
	 * @return monstro
	 */
	public Monstro removerCartaMonstro( int posicao ) {
		Monstro monstro = this.getCartaMonstro(posicao);
		monstro.setLocalizacao(-1);
		this.inserirCartaMonstro(null, posicao);
		monstro.setPosicaoMonstro(PosicaoMonstro.NAO_INVOCADO);
		this.mudarAtivacaoEfeito(posicao, false);
		return monstro;
	}
	
	/**
	 * Retira a carta de magia de uma determinado espaço na zona de magia e
	 * deixa o espaço livre.
	 * @param posicao posição da magia de desejamos revmover
	 * @return retorna o magia retirada da posição
	 */
	public Magia removerCartaMagia( int posicao ) {
		Magia magia = this.getCartaMagia(posicao);
		magia.setLocalizacao(-1);
		this.inserirCartaMagia(null, posicao);
		
		return magia;
	}
	
	/**
	 * Retorna uma carta monstro localizada em uma determinada posi��o na zona de monstros.
	 * @param posicao posi��o determinada da zona de monstros.
	 * @return carta do monstro localizada na posi��o.
	 */
	public Monstro getCartaMonstro( int posicao ) {
		return this.zonaMonstros[posicao];
	}
	
	/**
	 * Retorna uma carta de magia localizada em uma determinada posi��o na zona de magias.
	 * @param posicao posi��o determinada da zona de magia.
	 * @return carta de magia localizada na posi��o.
	 */
	public Magia getCartaMagia( int posicao ) {
		return this.zonaMagia[posicao];
	}
	
	
	
	
	/**
	 * Retorna o valor de posi��o na zona de efeitos � true ou false;
	 * @param posicao posi��o de deseja ver o valor.
	 * @return boolean
	 */
	public boolean checarAtivacaoEfeito(int posicao) {
		return this.zonaEfeitosMonstros[posicao];
	}
	
	/**
	 * Muda o valor da posi��o na zona de efeitos, true ou false;
	 * @param posicao posi��o na zona de efeitos.
	 * @param valor boolean.
	 */
	public void mudarAtivacaoEfeito(int posicao, boolean valor) {
		this.zonaEfeitosMonstros[posicao] = valor;
	}
	
	/**
	 * Informa a quantidade de cartas monstros na zona de monstros.
	 * @return quantidade de cartas monstro na zona de monstros.
	 */
	public int quantidadeCartaMonstro() {
		int cont = 0;
		for(int i = 0; i < 3; i++) {
			if(this.zonaMonstros[i] != null ) cont++;
		}
		return cont;
	}
	
	public Monstro[] getZonaMonstros() {
		return zonaMonstros;
	}
	public void setZonaMonstros(Monstro zonaMonstros[]) {
		this.zonaMonstros = zonaMonstros;
	}
	public Magia[] getZonaMagia() {
		return zonaMagia;
	}
	public void setZonaMagia(Magia zonaMagia[]) {
		this.zonaMagia = zonaMagia;
	}


	public boolean[] getZonaEfeitosMonstros() {
		return zonaEfeitosMonstros;
	}


	public void setZonaEfeitosMonstros(boolean zonaEfeitosMonstros[]) {
		this.zonaEfeitosMonstros = zonaEfeitosMonstros;
	}
	
}
