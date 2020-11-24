package br.imd.Models;

import java.util.Stack;
import java.util.Vector;

public class Baralho {
	private String nome;
	private Stack<Carta> cartas;
	
	public Baralho() {
		cartas = new Vector<Carta>();
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
	
	public Vector<Carta> getCartas(){
		return cartas;
	}
	
	//método extra adicionado por mim
	public int getQuantidadeCartas() {
		return cartas.size();
	}
}
