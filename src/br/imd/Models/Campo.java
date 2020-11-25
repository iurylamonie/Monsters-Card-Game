package br.imd.Models;

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
	}
	
	/**
	 * Retorna um inteiro para a primeira espa�o vazio na zona de Monstros.
	 * Retorna -1 caso n�o tenha ESPA�O.
	 * @return inteiro
	 */
	public int espacoZonaMonstroVazio() {
		if( this.zonaMonstros[0] == null ) return 0;
		else if( this.zonaMonstros[1] == null ) return 1;
		else if( this.zonaMonstros[2] == null ) return 2;
		
		return -1;
	}
	
	/**
	 * Retorna um inteiro para a primeira espa�o vazio na zona de magias.
	 * Retorna -1 caso n�o tenha ESPA�O.
	 * @return inteiro
	 */
	public int espacoZonaMagiaVazio() {
		if( this.zonaMonstros[0] == null ) return 0;
		else if( this.zonaMonstros[1] == null ) return 1;
		else if( this.zonaMonstros[2] == null ) return 2;
		
		return -1;
	}
	
	/**
	 * Retorna uma carta monstro localizada em uma determinada posi��o na zona de monstros.
	 * @param posicao posi��o determinada da zona de monstros.
	 * @return carta do monstro localizada na posi��o.
	 */
	public Monstro getEspacoMonstro( int posicao ) {
		return this.zonaMonstros[posicao];
	}
	
	
	/**
	 * Adiciona uma carta monstro em uma localiza��o determinada na zona de monstros e
	 * seta a posi��o na zona de efeitos de monstros como true.
	 * @param monstro carta monstro a ser adicionada na zona de monstros
	 * @param posicao localiza��o que a carta deve ser adicionada.
	 */
	public void setEspacoMonstro( Monstro monstro, int posicao) {
		this.zonaMonstros[posicao] = monstro;
		this.zonaEfeitosMonstros[posicao] = true;
	}
	
	/**
	 * Retorna uma carta de magia localizada em uma determinada posi��o na zona de magias.
	 * @param posicao posi��o determinada da zona de magia.
	 * @return carta de magia localizada na posi��o.
	 */
	public Magia getEspacoMagia( int posicao ) {
		return this.zonaMagia[posicao];
	}
	
	
	/**
	 * Adiciona uma carta de magia em uma localiza��o determinada na zona de magias.
	 * @param magia carta de magia a ser adicionada na zona de magias
	 * @param posicao localiza��o que a carta deve ser adicionada.
	 */
	public void setEspacoMagia( Magia magia, int posicao) {
		this.zonaMagia[posicao] = magia;
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
	
	/**
	 * Retorna o valor de posi��o na zona de efeitos � true ou false;
	 * @param posicao posi��o de deseja ver o valor.
	 * @return boolean
	 */
	public boolean isZonaEfeitoMonstro(int posicao) {
		return this.zonaEfeitosMonstros[posicao];
	}
	
	/**
	 * Muda o valor da posi��o na zona de efeitos, true ou false;
	 * @param posicao posi��o na zona de efeitos.
	 * @param valor boolean.
	 */
	public void setZonaEspacoEfeitosMonstros(int posicao, boolean valor) {
		this.zonaEfeitosMonstros[posicao] = valor;
	}
}
