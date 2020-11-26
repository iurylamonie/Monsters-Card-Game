package br.imd.Views.Debug;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;



import br.imd.Constants.CartaLayaout;
import br.imd.Constants.PosicaoMonstro;
import br.imd.Constants.TipoClasse;
import br.imd.Constants.TipoEfeitoMonstro;
import br.imd.Constants.TipoMagiaEquipamento;
import br.imd.Models.Baralho;
import br.imd.Models.Carta;
import br.imd.Models.MagiaNormal;
import br.imd.Models.MagiaEquipamento;
import br.imd.Models.MonstroEfeito;
import br.imd.Models.Tabuleiro;
import br.imd.Models.Monstro;

public class Principal {

	
	public static void main(String args[]) {	
		Baralho baralho1 = new Baralho();
		Stack<Carta> cartas = new Stack<Carta>();
		
		cartas.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		
		cartas.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		cartas.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		cartas.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		
		cartas.push( new Monstro("Yorick", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.GUERREIRO) );
		
		baralho1.setCartas(cartas);
		
		Tabuleiro tab1 = new Tabuleiro(baralho1);
		
		tab1.comprar();
		tab1.comprar();
		tab1.comprar();
		
		System.out.println("Quantidade de Cartas na mão: " + tab1.getMaoJogador().size() 
				+ "\nQuantidade de cartas no baralho: " + tab1.getBaralho().getCartas().size());
		Vector<Carta> maoJogador = tab1.getMaoJogador();
		
		for( Carta carta: maoJogador) {
			if( carta instanceof MonstroEfeito ) {
				System.out.println(" Carta de Monstro Efeito -- Nome: " + carta.getNome() 
				+ " -- Efeito: " + ((MonstroEfeito) carta).getDescricao());
			} else if( carta instanceof Monstro ) {
				System.out.println(" Carta de Monstro -- Nome: " + carta.getNome() 
				+ " -- ATK: " + ((Monstro) carta).getAtk());
			} else if( carta instanceof MagiaNormal ) {
				System.out.println(" Cartas de Magia Normal -- Nome: " + carta.getNome() 
				+ " -- Efeito: " + ((MonstroEfeito) carta).getDescricao());
			}
		}
		
		
		File file = new File("Teste.txt");
		try( FileWriter fw = new FileWriter(file) ){
		    fw.write('2');
		    fw.write("25");
		    fw.flush();
		}catch(IOException ex){
		  ex.printStackTrace();
		}
	}
	
}
