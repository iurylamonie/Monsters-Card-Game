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

	public Stack<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(Stack<Carta> cartas) {
		this.cartas = cartas;
	}
	
}
