package br.imd.Models;

import java.util.Stack;

public class Baralho {
	private String nome;
	private Stack<Carta> cartas;
	
	public Baralho() {
		cartas = new Stack<Carta>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public void setCartas(Carta carta) {
		cartas.add(carta);
	}
	
	public Stack<Carta> getCartas(){
		return cartas;
	}
	
	//m�todo extra adicionado por mim
	public int getQuantidadeCartas() {
		return cartas.size();
	}
}
