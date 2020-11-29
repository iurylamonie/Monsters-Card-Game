package br.imd.Views.Debug;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;



import br.imd.Constants.CartaLayaout;
import br.imd.Constants.PosicaoMonstro;
import br.imd.Constants.TipoClasse;
import br.imd.Constants.TipoEfeitoMonstro;
import br.imd.Constants.TipoMagiaEquipamento;
import br.imd.Constants.TipoMagiaNormal;
import br.imd.Controllers.Duelo;
import br.imd.Models.Baralho;
import br.imd.Models.Carta;
import br.imd.Models.Jogador;
import br.imd.Models.Magia;
import br.imd.Models.MagiaNormal;
import br.imd.Models.MagiaEquipamento;
import br.imd.Models.MonstroEfeito;
import br.imd.Models.Tabuleiro;
import br.imd.Models.Monstro;

public class Principal {

	
	public static void main(String args[]) {	
		
		System.out.println(Principal.class.getResource("../Components/SpaceComponent.fxml"));
		
		
		/*
		 * Criação do Baralho 1;
		 */
		Baralho baralho1 = new Baralho();
		Stack<Carta> cartas1 = new Stack<Carta>();
		cartas1.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas1.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas1.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		
		cartas1.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		cartas1.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		cartas1.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		
		cartas1.push( new Monstro("Yorick", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.GUERREIRO) );
		cartas1.push( new Monstro("Yorick", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.GUERREIRO) );
		cartas1.push( new Monstro("Yorick", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.GUERREIRO) );
		cartas1.push( new Monstro("Salazar", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.BARBARO) );
		cartas1.push( new Monstro("Salazar", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.BARBARO) );
		cartas1.push( new Monstro("Salazar", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.BARBARO) );
		cartas1.push( new Monstro("Salazar", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL, 4, 2000, 2500, TipoClasse.BARBARO) );
		
		cartas1.push( new MagiaNormal("Fogo Divino", "Aumenta sua vida em 500 pontos", CartaLayaout.MAGIA, 550, TipoMagiaNormal.GANHAR_VIDA) );
		cartas1.push( new MagiaNormal("Fogo Divino", "Aumenta sua vida em 500 pontos", CartaLayaout.MAGIA, 550, TipoMagiaNormal.GANHAR_VIDA) );
		cartas1.push( new MagiaNormal("Fogo Divino", "Aumenta sua vida em 500 pontos", CartaLayaout.MAGIA, 550, TipoMagiaNormal.GANHAR_VIDA) );		
		baralho1.setCartas(cartas1);
		/* < Fim do baralho 1 
		 * Fim do baralho 1.
		 * */
		
		
		/*
		 * Criação do Baralho 2;
		 */
		Baralho baralho2 = new Baralho();
		Stack<Carta> cartas2 = new Stack<Carta>();
		cartas2.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas2.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas2.push(new MagiaEquipamento("Espada da Esperança", "Monstro equipada com essa espada ganha 220 de ataque.", CartaLayaout.MAGIA , 220, TipoMagiaEquipamento.AUMENTAR_ATK));
		
		cartas2.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		cartas2.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		cartas2.push(new MonstroEfeito("Gozuki", "Ganha 200 pontos de ataque ao ser invocado.", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 0,
				TipoClasse.BARBARO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				200));
		
		cartas2.push( new Monstro("Yorick", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.GUERREIRO) );
		cartas2.push( new Monstro("Yorick", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.GUERREIRO) );
		cartas2.push( new Monstro("Yorick", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.GUERREIRO) );
		cartas2.push( new Monstro("Salazar", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.BARBARO) );
		cartas2.push( new Monstro("Salazar", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.BARBARO) );
		cartas2.push( new Monstro("Salazar", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL,
			       4, 2000, 2500,
			       TipoClasse.BARBARO) );
		cartas2.push( new Monstro("Salazar", "Lutou durante mil luas e mil noites", CartaLayaout.MONSTRO_NORMAL, 4, 2000, 2500, TipoClasse.BARBARO) );
		
		cartas2.push( new MagiaNormal("Fogo Divino", "Aumenta sua vida em 500 pontos", CartaLayaout.MAGIA, 550, TipoMagiaNormal.GANHAR_VIDA) );
		cartas2.push( new MagiaNormal("Fogo Divino", "Aumenta sua vida em 500 pontos", CartaLayaout.MAGIA, 550, TipoMagiaNormal.GANHAR_VIDA) );
		cartas2.push( new MagiaNormal("Fogo Divino", "Aumenta sua vida em 500 pontos", CartaLayaout.MAGIA, 550, TipoMagiaNormal.GANHAR_VIDA) );		
		baralho2.setCartas(cartas2);
		/* < Fim do baralho 2 
		 * Fim do baralho 12
		 * */
		
		
		Jogador j1 = new Jogador("Iury", baralho1);
		Jogador j2 = new Jogador("Tiago", baralho2);
		
		Duelo duelo = new Duelo(j1, j2);
		
		Scanner ler = new Scanner(System.in);
		System.out.println("O jogador inicial: " + duelo.getAtualJogador().getNome());
		
		//System.out.println(" 0 - Invocar Monstro - 1 - In")
		
		
		
	
	}
	
}
