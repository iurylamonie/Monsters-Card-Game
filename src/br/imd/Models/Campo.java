package br.imd.Models;

import br.imd.Models.Monstro;
import br.imd.Models.Magia;
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
	 * Retorna uma carta monstro localizada em uma determinada posi��o na zona de monstros.
	 * @param posicao posi��o determinada da zona de monstros.
	 * @return carta do monstro localizada na posi��o.
	 */
	public Monstro getEspacoMonstro( int posicao ) {
		return this.zonaMonstros[posicao];
	}
	
	
	/**
	 * Adiciona uma carta monstro em uma localiza��o determinada na zona de monstros.
	 * @param monstro carta monstro a ser adicionada na zona de monstros
	 * @param posicao localiza��o que a carta deve ser adicionada.
	 */
	public void setEspacoMonstro( Monstro monstro, int posicao) {
		this.zonaMonstros[posicao] = monstro;
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
}
