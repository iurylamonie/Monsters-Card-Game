package br.imd.Views;

import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

import br.imd.Controllers.Duelo;
import br.imd.Models.Baralho;
import br.imd.Models.Campo;
import br.imd.Models.Carta;
import br.imd.Models.Jogador;
import br.imd.Models.Magia;
import br.imd.Models.MagiaEquipamento;
import br.imd.Models.MagiaNormal;
import br.imd.Models.Monstro;
import br.imd.Models.MonstroEfeito;
import br.imd.Rules.AlreadySummonedMonsterException;
import br.imd.Rules.EffectHasActivatedException;
import br.imd.Rules.HandFullException;
import br.imd.Rules.NoCardDrawException;
import br.imd.Rules.NoSpaceZoneException;
import br.imd.Rules.NotChangeBattlePositionException;
import br.imd.Rules.SummonedTributeException;
import br.imd.Rules.WinnerException;
import br.imd.Constants.CartaLayaout;
import br.imd.Constants.Fase;
import br.imd.Constants.PosicaoMonstro;
import br.imd.Constants.TipoClasse;
import br.imd.Constants.TipoEfeitoMonstro;
import br.imd.Constants.TipoMagiaEquipamento;
import br.imd.Constants.TipoMagiaNormal;

/**
 * Monsters Cards Game versão Console (Texto-Terminal).
 * @author Iury
 *
 */
public class GameConsole {

	public static void main( String args[] ) {
		
		Duelo duelo;
		
		Baralho b1 = new Baralho();
		Baralho b2 = new Baralho();
		b1.setCartas(criarBaralhoGuerreiro());
		b2.setCartas(criarBaralhoMercenario());
		
		Jogador jogador1 = new Jogador("", b1);
		Jogador jogador2 = new Jogador("", b2);;
		
		Scanner leitor = new Scanner(System.in);
		
		printWarning("BEM-VINDO AO MONSTERS CARD GAME!");
		System.out.println("# INFORME O NOME DO PRIMEIRO JOGADOR: ");
		jogador1.setNome(leitor.nextLine());
		System.out.println("# INFORME O NOME DO SEGUNDO JOGADOR: ");
		jogador2.setNome(leitor.nextLine());
		
		duelo = new Duelo(jogador1, jogador2);
		
		printWarning( duelo.getAtualJogador().getNome() + " é o primeiro a jogar!");
		int op = 0;
		while(op != 5) {
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("Jogador: " + duelo.getAtualJogador().getNome() + " | Turno: " + duelo.getTurnoAtual() + 
					" | Pontos de Vida do Jogador: " + duelo.getAtualJogador().getPontosVida() + " | Pontos de Vida do jogador inimigo: "+
					duelo.getProxJogador().getPontosVida() + " | Fase Atual: " + duelo.getFaseAtual() + 
					" | Quantidade de cartas no baralho: "+ duelo.getDueladores().get(duelo.getAtualJogador()).getBaralho().getCartas().size()
					+" | Quantidade de cartas no cemiterio: " + duelo.getDueladores().get(duelo.getAtualJogador()).getCemiterio().size());
			Vector<Carta> mao = duelo.getDueladores().get(duelo.getAtualJogador()).getMaoJogador();
			monstrar_mao( mao);
			opcoesJogador(mao, duelo);
			
		}
		
	}
	
	/**
	 * Monstra as opção principais do jogador.
	 * @param mao cartas na mão do jogador atual.
	 * @param duelo o duelo.
	 */
	private static void opcoesJogador(Vector<Carta> mao, Duelo duelo) {
		menu_jogador();
		System.out.print("# Opção: ");
		Scanner leitor = new Scanner(System.in);
		int op = leitor.nextInt();
		
		switch(op) {
		case 0:
			monstrar_zona_monstro(duelo.getAtualJogador(), duelo);
			monstrar_zona_magia(duelo.getAtualJogador(), duelo);
			// FIXME Monstrar o campo dos dois jogadores ao mesmo tempo?
			break;
		case 1:
			invocar_carta(mao, duelo);
			break;
		case 2:
			ativar_efeito(duelo);
			break;
		case 3:
			mudar_posicao_batalha(duelo);
			break;
		case 4:
			proxima_fase( duelo);
			break;
		case 5:
			passar_turno(duelo);
			break;
		case 6:
			desistir(duelo);
			break;
		case 7:
			if(duelo.getTurnoAtual() != 1) {
				if( duelo.getFaseAtual() == Fase.BATALHA) {
					batalhar(duelo);
				} else printWarning("É necessario está na Fase de Batalha para batalhar.");
			} else printWarning("O jogador do turno 1 não pode atacar.");
			break;
		}
	}
	
	private static void batalhar(Duelo duelo) {
		
		Campo campo = duelo.getDueladores().get(duelo.getAtualJogador()).getCampo();
		Campo campoOp = duelo.getDueladores().get(duelo.getProxJogador()).getCampo();
		
		System.out.println("- Seus monstros disponiveis para batalhar: ");
		
		Vector<Integer> monsDisp = new Vector<Integer>();
		
		for( Monstro monstro : campo.getZonaMonstros()) {
			
			if( monstro != null ) {
				// verifica se o monstro batalhou
				if ( !monstro.isBatalhou() && monstro.getPosicaoMonstro() == PosicaoMonstro.ATAQUE ) {			
					System.out.println( monstro.getLocalizacao() + ".  Nome: " + monstro.getNome() + " - ATK/" + monstro.getAtk());
					monsDisp.add(monstro.getLocalizacao());			
				}
			}	
		}
		
		if( monsDisp.size() > 0 ) {
			Scanner leitor = new Scanner(System.in);
			System.out.print("Escolha o indice do monstro que vai atacar: ");
			int op = leitor.nextInt();
			
			for( int i : monsDisp ) {
				
				if( op == i ) {
					Monstro monstro = campo.getCartaMonstro(op);
					// Verificar se existe monstro no campo inimigo, se naot iver ataca direto
					if( campoOp.quantidadeCartaMonstro() == 0 ) {
						
						try {
							duelo.atacarDireto(monstro);
							monstro.setBatalhou(true);
							System.out.println( " ---- " + monstro.getNome() + " atacou diretamente.");
						} catch (WinnerException e) {
							printWarning(e.getMessage());
							System.exit(0);
						}
						
					} else {
						
						Vector<Integer> monsDispOp = new Vector<Integer>();
						System.out.println("-- Monstros disponiveis no campo do oponente: ");
						for( Monstro m : campoOp.getZonaMonstros() ) {
							if( m != null ) {
		
								System.out.print(m.getLocalizacao() + ". Posição de Batalha: ");
								if(m.getPosicaoMonstro() == PosicaoMonstro.ATAQUE) {
									System.out.print("Ataque");
								} else System.out.print("Defesa");
								System.out.println("- Nome: " + m.getNome() + " - ATK/" + m.getAtk() +" - DEF/" + m.getDef()) ;
								
								monsDispOp.add(m.getLocalizacao());
							}
						}
						
						System.out.print("Qual monstro deseja atacar, informe o indice:");
						int op2 = leitor.nextInt();
						
						for( int j : monsDispOp ) {
							if( j == op2 ) {
								try {
									campo.getCartaMonstro(op).setBatalhou(true);
									System.out.println(" ---- " + campo.getCartaMonstro(op).getNome() + " atacou " + campoOp.getCartaMonstro(op).getNome() + ".");
									duelo.atacar(campo.getCartaMonstro(op), campoOp.getCartaMonstro(op2));
								} catch (WinnerException e) {
									printWarning(e.getMessage());
									System.exit(0);
								}
							}
						}
						
					}
					
				}
			}
			
		} else printWarning("Você não possue monstros disponiveis para batalhar");
		
	}
	private static void mudar_posicao_batalha(Duelo duelo) {
		monstrar_zona_monstro(duelo.getAtualJogador(), duelo);
		System.out.print("Informe o indice do monstro que deseja mudar de posição: ");
		Scanner leitor = new Scanner(System.in);
		Campo campo = duelo.getDueladores().get(duelo.getAtualJogador()).getCampo();
		int op = leitor.nextInt();
		if( op >= 0 && op < 3) {
			Monstro monstro = campo.getCartaMonstro(op);
			
			if(monstro != null) {
				try {
					duelo.mudarPosicaoBatalha(monstro);
				} catch (NotChangeBattlePositionException e) {
					printWarning(e.getMessage());
				}
			} else printWarning("Indice inválido");
		} else printWarning("Indice inválido");
	}
	
	private static void ativar_efeito( Duelo duelo ) {
		System.out.println("# Deseja ativar efeito de um Monstro(1) ou Magia(2). Informe o que deseja: ");
		Scanner leitor = new Scanner(System.in);
		int op = leitor.nextInt();
		Campo campo = duelo.getDueladores().get(duelo.getAtualJogador()).getCampo();
		switch(op) {
		
		case 1:	
			Vector<Integer> cont = new Vector<Integer>(); // quantidade de monstros efeitos que nao sejam passivos na zona;
			
			// Verificar quantos monstros podem ativar o efeito.
			for(Monstro monstro: campo.getZonaMonstros()) {
				if( monstro != null) {
					if(monstro instanceof MonstroEfeito ) {
						// Checa se nao for monstro de efeito passaivo e não tiver ativado o efeito dele.
						if( !((MonstroEfeito) monstro).isEfeitoPassivo() &&  !campo.checarAtivacaoEfeito(monstro.getLocalizacao()) ){
							
							System.out.println(monstro.getLocalizacao() + ". Nome: " + monstro.getNome()  + " - Descrição: " + monstro.getDescricao());					
							cont.add(monstro.getLocalizacao());
						}
					}
				}
				
			}
			
			if( cont.size() > 0) {
				System.out.print("Escolha o indice do monstro: ");
				int ope = leitor.nextInt();
				for(int i: cont) {
					
					if( ope == i) {
						MonstroEfeito monstro = ((MonstroEfeito)campo.getCartaMonstro(i));
						
						if( monstro.getTipoEfeito() == TipoEfeitoMonstro.AUMENTAR_PROPRIA_DEF || monstro.getTipoEfeito() == TipoEfeitoMonstro.AUMENTAR_PROPRIA_DEF ) {
							try {
								duelo.ativarEfeitoMonstro(duelo.getAtualJogador(), monstro, duelo.getAtualJogador(), monstro);
							} catch (EffectHasActivatedException e) {
								printWarning(e.getMessage());
							}
						} else {
							//campo do oponente
							Campo campoOp = duelo.getDueladores().get(duelo.getProxJogador()).getCampo();
							if( campoOp.quantidadeCartaMonstro() > 0 ) {
								
								Vector<Integer> indiceOp = new Vector<Integer>();
								
								for(Monstro monstroOp: campoOp.getZonaMonstros()) {
									if(monstroOp != null ) {
												
										System.out.println(monstroOp.getLocalizacao() + ". Nome: " + monstroOp.getNome()  + " - Descrição: " + monstroOp.getDescricao());					
										indiceOp.add(monstroOp.getLocalizacao());							
									}
									
								}
								
								while(true) {
									System.out.print("Escolha um dos indices dos monstros do oponente lista acima: ");
									int opea = leitor.nextInt();
									
									for( int indice : indiceOp ) {
										if( indice == ope ) {
											Monstro monstroOp = campoOp.getCartaMonstro(indice);
											try {
												duelo.ativarEfeitoMonstro(duelo.getAtualJogador(), monstro, duelo.getProxJogador(), monstroOp);
												return;
											} catch (EffectHasActivatedException e) {
												printWarning(e.getMessage());
											}
										}
									}
									
									printWarning("Informe um indice válido.");
								}
								
							} else printWarning("O adversario não possue nenhuma carta monstro no campo para você ativar esse efeito.");
							
						}
					
					}
				}
			} else printWarning("Não possue monstros que possam ativar o efeito.");
			break;
		case 2:
			Vector<Integer> indMagias = new Vector<Integer>(); // Quantidade de magias no campo.
			for(Magia carta : campo.getZonaMagia()) {
				if( carta != null ) {
					//Verifica se é uma carta de equipamento e se ela já foi ativada
					if( carta instanceof MagiaEquipamento && !((MagiaEquipamento) carta).isEfeitoFoiAtivado()) {
						System.out.println(carta.getLocalizacao() + ". Nome: " + carta.getNome()  + " - Descrição: " + carta.getDescricao());					
						indMagias.add(carta.getLocalizacao());
					}
				}
			}
			
			if( indMagias.size() > 0 ) {
				System.out.print("Escolha o indice da magia: ");
				int opm = leitor.nextInt();
				for( int ind: indMagias ) {
					if( ind == opm ) {
						
						Vector<Integer> indMon = new Vector<Integer>();
						
						for(Monstro monstro: campo.getZonaMonstros()) {
							if( monstro != null) {			
								System.out.println(monstro.getLocalizacao() + ". Nome: " + monstro.getNome()  + " - ATK/" + monstro.getAtk() + " - DEF/" + monstro.getDef() );					
								indMon.add(monstro.getLocalizacao());								
							}
							
						}
						
						if( indMon.size() > 0 ) {
							System.out.print("Escolha o indice do monstro que deseja equipar a carta: ");
							opm = leitor.nextInt();
							
							for( int indice: indMon ) {
								if( opm == indice ) {
									try {
										duelo.ativarEfeitoMagia(duelo.getAtualJogador(), campo.getCartaMagia(ind), duelo.getAtualJogador(), campo.getCartaMonstro(indice));
									} catch (WinnerException e) {
										printWarning(e.getMessage());
										System.exit(0);
									}
								}
							}
							
						}
						
					}
				}
			}
			else printWarning("Não possue monstros que possam ativar o efeito.");
			
			break;
		default:
			printWarning("Opção inválida.");
			break;
		}
	}
	
	private static void proxima_fase(Duelo duelo) {
		try {
			duelo.proximaFase(duelo.getFaseAtual());
		} catch (NoCardDrawException e) {
			e.printStackTrace();
		} catch (HandFullException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Passa o turno para o proximo jogador
	 * @param duelo
	 */
	private static void passar_turno(Duelo duelo) {
		try {
			duelo.passarTurno();
		} catch (NoCardDrawException e) {
			printWarning(e.getMessage());
			try {
				duelo.vencedor(duelo.getProxJogador(), duelo.getAtualJogador().getNome() + " venceu o duelo!");
			} catch (WinnerException e1) {
				printWarning(e1.getMessage());
				System.exit(0);
				e1.printStackTrace();
			}
		} catch (HandFullException e) {
			printWarning(e.getMessage());
		}
	}
	
	/**
	 * O jogador do turno atual desiste do duelo e dá a vitoria par ao oponente..
	 * @param duelo
	 */
	private static void desistir(Duelo duelo) {
		try {
			duelo.desistirDuelo( duelo.getAtualJogador() );
		} catch (WinnerException e) {
			printWarning(e.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Invoca um monstro da mão de acordo com a posição da carta na mão.
	 * @param mão do jogador que vai invocar a carta.
	 */
	private static void invocar_carta( Vector<Carta> mao, Duelo duelo ) {
		monstrar_mao(mao);
		System.out.print("Qual deseja invocar (Escolha o Indice): ");
		int opi;
		Scanner leitor = new Scanner(System.in);
		opi = leitor.nextInt();
		if( opi >= 0 && opi < mao.size() ) {
			if( mao.get(opi) instanceof Monstro ) {
				System.out.print("Em qual posição de batalha(0 - Ataque | 1 - Defesa ): ");
				
				int opad;
				opad = leitor.nextInt();
				
				try {
					if( opad == 0 ) {
						
						Carta carta = mao.get(opi);
						duelo.invocarMonstro(((Monstro) carta), PosicaoMonstro.ATAQUE);
						carta = duelo.getDueladores().get(duelo.getAtualJogador()).removerCartaMao(opi);
						
						// Verifica se a carta é do tipo Monstro Efeito
						if( carta instanceof MonstroEfeito) {
							
							// Se for de efeito passivo, vai ativar!
							if( ((MonstroEfeito) carta).isEfeitoPassivo() ) {
								try {
									duelo.ativarEfeitoMonstro(duelo.getAtualJogador(), carta, duelo.getAtualJogador(), carta);
								} catch (EffectHasActivatedException e) {
									printWarning(e.getMessage());
								}
								
							}
						}
						
					}else if(opad == 1 ) {
						Carta carta = mao.get(opi);
						duelo.invocarMonstro(((Monstro) carta), PosicaoMonstro.DEFESA);
						carta = duelo.getDueladores().get(duelo.getAtualJogador()).removerCartaMao(opi);		
						
						if( carta instanceof MonstroEfeito) {
							// Se for de efeito passivo, vai ativar!
							if( ((MonstroEfeito) carta).isEfeitoPassivo() ) {
								try {
									duelo.ativarEfeitoMonstro(duelo.getAtualJogador(), carta, duelo.getAtualJogador(), carta);
								} catch (EffectHasActivatedException e) {
									printWarning(e.getMessage());
								}
							}
						}
					}
					else printWarning("Posição inválida.");
				} catch (SummonedTributeException e) {
					if( e.isPodeInvocar() ) {
						System.out.print("# Você precisa tributar " + e.getQuantidadeTributos() + " monstros. Digite 1(Sim) ou 2(Não):" );
						int op;
						op = leitor.nextInt();
						if( op == 1 ) {
							Carta carta = duelo.getDueladores().get(duelo.getAtualJogador()).removerCartaMao(opi);
							invocacao_tributo( e.getQuantidadeTributos(), ((Monstro) carta), duelo);
						}
						else if( op != 2 ) { 
							printWarning("Opção inválida");
						}
					} else printWarning(e.getMessage());
					
				} catch (NoSpaceZoneException e) {
					printWarning(e.getMessage());
				} catch (AlreadySummonedMonsterException e) {
					printWarning(e.getMessage());
				}
				
				
			} else if( mao.get(opi) instanceof Magia ) {
				try {
					Carta carta = duelo.getDueladores().get(duelo.getAtualJogador()).removerCartaMao(opi);
					duelo.invocarMagia( (Magia) carta);
					
					if(carta instanceof MagiaNormal ) {
						if(((MagiaNormal) carta).getTipo() == TipoMagiaNormal.PERDER_VIDA) {
							try {
								duelo.ativarEfeitoMagia(duelo.getAtualJogador(), carta, duelo.getProxJogador(), null);
							} catch (WinnerException e) {
								printWarning(e.getMessage());
								System.exit(0);
							}
						} else {
							try {
								duelo.ativarEfeitoMagia(duelo.getAtualJogador(), carta, duelo.getAtualJogador(), null);
							} catch (WinnerException e) {
								printWarning(e.getMessage());
								System.exit(0);
							}
						}
					}
					
				} catch (NoSpaceZoneException e) {
					printWarning(e.getMessage());
				}
			}
		} else printWarning("Indice inválido.");
	}
	
	/**
	 * Invoca uma carta monstro da mão que precias de tributos.
	 * @param qtdTributos quantidade de cartas para ser tributada
	 * @param monstro o monstro a ser invocado.
	 */
	private static void invocacao_tributo( int qtdTributos, Monstro monstro, Duelo duelo) {
		monstrar_zona_monstro(duelo.getAtualJogador(), duelo);
		int cont = 0;
		int op;
		Scanner leitor = new Scanner(System.in);
		Vector<Monstro> tributos = new Vector<Monstro>();
		Campo campo = duelo.getDueladores().get(duelo.getAtualJogador()).getCampo();
		while( cont != qtdTributos) {
			System.out.print("# Escolha o " + (cont+1) + " monstro a ser tributado dos " + qtdTributos + ". Informe o indice do monstro no campo : ");
			op = leitor.nextInt();
			
			if( campo.getCartaMonstro(op) != null ) {
				tributos.add(campo.getCartaMonstro(op));
				cont++;
			} else {
				printWarning("Informe um indice de monstro válido!");
			}
			
		}
		
		if( cont == qtdTributos ) {
			duelo.invocarMonstroTributo(monstro, tributos);
			
			if(monstro instanceof MonstroEfeito ) {
				try {
					duelo.ativarEfeitoMonstro(duelo.getAtualJogador(), monstro, duelo.getAtualJogador(), monstro);
				} catch (EffectHasActivatedException e) {
					printWarning(e.getMessage());
				}
			}
			
		}
		
		
	}
	
	/**
	 * Monstro a zona de monstros de um jogador
	 * @param jogador o jogador que desejamos monstrar a zona
	 */
	private static void monstrar_zona_monstro(Jogador jogador, Duelo duelo) {
		int i = 0;
		Campo campo = duelo.getDueladores().get(jogador).getCampo();
		
		System.out.println("==============================================Zona Monstro de " + jogador.getNome() +"====================================================");
		for(Monstro carta: campo.getZonaMonstros()) {		
			if(carta == null ) {
				continue;
			}
			else {
				System.out.print( carta.getLocalizacao() + ". Posição de Batalha: ");
				if(carta.getPosicaoMonstro() == PosicaoMonstro.ATAQUE) {
					System.out.print("Ataque");
				} else System.out.print("Defesa");
				System.out.println("- Nome: " + carta.getNome() + " - Nível: " + carta.getNivel() + " - ATK/" + carta.getAtk() +
						" - DEF/" + carta.getDef() + " - Descrição: " + carta.getDescricao() + " " + carta.getTurnoInvocacao());
			} 
			i++;
		}
		
		System.out.println("===========================================================================================================================================");
	
	}
	
	private static void monstrar_zona_magia(Jogador jogador, Duelo duelo) {
		int i = 0;
		Campo campo = duelo.getDueladores().get(jogador).getCampo();
	
		System.out.println("==============================================Zona Magica de " + jogador.getNome() +"====================================================");
		for(Magia carta: campo.getZonaMagia()) {		
			if(carta == null ) {
				continue;
			}
			else {
				System.out.println(carta.getLocalizacao() + ". - Nome: " + carta.getNome() +  " - Descrição: " + carta.getDescricao());
			} 
			i++;
		}
		
		System.out.println("===========================================================================================================================================");
	
		
	}
	
	/**
	 * Imprime uma mensagem de alerta
	 * @param message a mensagem que deseja mostrar.
	 */
	private  static void printWarning(String message) {
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++AVISO DO SISTEMA+++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(message);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
	}
	
	
	private static void menu_jogador( ) {
		System.out.println("**************************************OPÇÕES*************************************************************************************************************");
		System.out.println("* 0 - Ver Campo | 1 - Invocar Carta | 2 - Ativar Efeito | 3 - Mudar Posição Batalha | 4 - Passar Fase | 5 - Passar Turno | 6 - Desistir | 7 - Batalhar  *");
		System.out.println("*********************************************************************************************************************************************************");
	}
	
	private static void monstrar_mao( Vector<Carta> mao ) {
		int i = 0;
		System.out.println("**************************************Sua Mão******************************************************************");
		for(Carta carta: mao) {		
			if( carta instanceof MonstroEfeito ) {
				System.out.println(i + ". [Monstro Efeito] - Nome: " + carta.getNome() + " - Nível: " + ((MonstroEfeito) carta).getNivel() + " - ATK/" + ((MonstroEfeito)carta).getAtk() +
						" - DEF/" + ((MonstroEfeito)carta).getDef() + " - Descrição: " + carta.getDescricao());			

			} else if(carta instanceof Monstro ) {
				System.out.println(i + ". [Monstro Normal] - Nome: " + carta.getNome() + " - Nível: " + ((Monstro) carta).getNivel() + " - ATK/" + ((Monstro)carta).getAtk() +
						" - DEF/" + ((Monstro)carta).getDef() + " - Descrição: " + carta.getDescricao());
			} else if( carta instanceof MagiaNormal ) {
				System.out.println(i + ". [Magia Normal] - Nome: " + carta.getNome() +  " - Descrição: " + carta.getDescricao());
			} else if( carta instanceof MagiaEquipamento) {
				System.out.println(i + ". [Magia de Equipamento] - Nome: " + carta.getNome() +  " - Descrição: " + carta.getDescricao());
			}
			i++;
		}
		
		System.out.println("**************************************************************************************************************");
	
	}
	/**
	 * Cria um baralho com cartas do tipo guerreiro.
	 * @return o baralho criado.
	 */
	private static Stack<Carta> criarBaralhoGuerreiro() {
		Stack<Carta> cartas = new Stack<Carta>();;
		/*
		 * , nivel4, atk1700, def 1150, guerreiro, .
		 * , nivel 3, atk1500, def1200, barbaro Esse poderoso homem lagarto pode brandir sua espada mas rápida que a velocidade do som!"
		 */
		
		
		/*
		 * Magias de Equipamento
		 */		
		cartas.push(new MagiaEquipamento("Espada do Heroi", "Monstro equipada com essa espada ganha 300 de ataque.", CartaLayaout.MAGIA , 300, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas.push(new MagiaEquipamento("Espada do Heroi", "Monstro equipada com essa espada ganha 300 de ataque.", CartaLayaout.MAGIA , 300, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas.push(new MagiaEquipamento("Espada do Heroi", "Monstro equipada com essa espada ganha 300 de ataque.", CartaLayaout.MAGIA , 300, TipoMagiaEquipamento.AUMENTAR_ATK));
		
		/*
		 * Magias Normais
		 */
		cartas.push( new MagiaNormal("Fogo da Perdição", "Causa 500 pontos de dano na vida do oponente.", CartaLayaout.MAGIA, 500, TipoMagiaNormal.PERDER_VIDA) );
		cartas.push( new MagiaNormal("Fogo da Perdição", "Causa 500 pontos de dano na vida do oponente.", CartaLayaout.MAGIA, 500, TipoMagiaNormal.PERDER_VIDA) );
		cartas.push( new MagiaNormal("Fogo da Perdição", "Causa 500 pontos de dano na vida do oponente.", CartaLayaout.MAGIA, 500, TipoMagiaNormal.PERDER_VIDA) );
		
		/*
		 * Monstros Normais
		 */
		cartas.push( new Monstro("Beelhur", "Um guerreiro de tremenda força e agilidade que brande seu machado.", CartaLayaout.MONSTRO_NORMAL,
			       4, 1700, 1150,
			       TipoClasse.GUERREIRO) );
		cartas.push( new Monstro("Beelhur", "Um guerreiro de tremenda força e agilidade que brande seu machado.", CartaLayaout.MONSTRO_NORMAL,
			       4, 1700, 1150,
			       TipoClasse.GUERREIRO) );
		cartas.push( new Monstro("Beelhur", "Um guerreiro de tremenda força e agilidade que brande seu machado.", CartaLayaout.MONSTRO_NORMAL,
			       4, 1700, 1150,
			       TipoClasse.GUERREIRO) );
		cartas.push( new Monstro("Jacaré", "Esse poderoso homem lagarto pode brandir sua espada mas rápida que a velocidade do som.", CartaLayaout.MONSTRO_NORMAL,
			       3, 1500, 1200,
			       TipoClasse.BARBARO) );
		cartas.push( new Monstro("Jacaré", "Esse poderoso homem lagarto pode brandir sua espada mas rápida que a velocidade do som.", CartaLayaout.MONSTRO_NORMAL,
			       3, 1500, 1200,
			       TipoClasse.BARBARO) );
		cartas.push( new Monstro("Jacaré", "Esse poderoso homem lagarto pode brandir sua espada mas rápida que a velocidade do som.", CartaLayaout.MONSTRO_NORMAL,
			       3, 1500, 1200,
			       TipoClasse.BARBARO) );
		cartas.push( new Monstro("Aviario", "Um barbaro alado que vaga pelo céu e manipula o vento.", CartaLayaout.MONSTRO_NORMAL,
			       2, 1000, 1000,
			       TipoClasse.BARBARO) );
		cartas.push( new Monstro("Aviario", "Um barbaro alado que vaga pelo céu e manipula o vento.", CartaLayaout.MONSTRO_NORMAL,
			       2, 1000, 1000,
			       TipoClasse.BARBARO) );
		
		/*
		 * Monstros de efeito
		 */
		cartas.push(new MonstroEfeito("O Grande Guardião", "Ganha 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 6, 2500, 0,
				TipoClasse.MAGO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				400));
		cartas.push(new MonstroEfeito("O Grande Guardião", "Ganha 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 6, 2500, 0,
				TipoClasse.MAGO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				400));
		cartas.push(new MonstroEfeito("O Grande Guardião", "Ganha 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 6, 2500, 0,
				TipoClasse.MAGO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.AUMENTAR_PROPRIO_ATK,
				400));
		cartas.push(new MonstroEfeito("Alves, o Carrasco", "Diminui o ataque de um monstro inimigo em 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 4, 1500, 1600,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.DIMINUIR_ATK_INIMIGO,
				400));
		cartas.push(new MonstroEfeito("Alves, o Carrasco", "Diminui o ataque de um monstro inimigo em 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 4, 1500, 1600,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.DIMINUIR_ATK_INIMIGO,
				400));
		cartas.push(new MonstroEfeito("Alves, o Carrasco", "Diminui o ataque de um monstro inimigo em 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 4, 1500, 1600,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.DIMINUIR_ATK_INIMIGO,
				400));
		return cartas;
	}
	
	
	/**
	 * Cria um baralho com cartas do tipo mercenario.
	 * @return o baralho criado.
	 */
	private static Stack<Carta> criarBaralhoMercenario() {
		Stack<Carta> cartas = new Stack<Carta>();;
		/*
		 * , nivel4, atk1700, def 1150, guerreiro, .
		 * , nivel 3, atk1500, def1200, barbaro Esse poderoso homem lagarto pode brandir sua espada mas rápida que a velocidade do som!"
		 */
		
		
		/*
		 * Magias de Equipamento
		 */		
		cartas.push(new MagiaEquipamento("Revolver Antigo", "Monstro equipada com essa espada ganha 400 de ataque.", CartaLayaout.MAGIA , 400, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas.push(new MagiaEquipamento("Revolver Antigo", "Monstro equipada com essa espada ganha 400 de ataque.", CartaLayaout.MAGIA , 400, TipoMagiaEquipamento.AUMENTAR_ATK));
		cartas.push(new MagiaEquipamento("Revolver Antigo", "Monstro equipada com essa espada ganha 400 de ataque.", CartaLayaout.MAGIA , 400, TipoMagiaEquipamento.AUMENTAR_ATK));
		/*
		 * Magias Normais
		 */
		cartas.push( new MagiaNormal("Báu do Tesouro", "Adiciona 1000 Pontos de Vida ao dono dessa carta.", CartaLayaout.MAGIA, 1000, TipoMagiaNormal.GANHAR_VIDA) );
		cartas.push( new MagiaNormal("Báu do Tesouro", "Adiciona 1000 Pontos de Vida ao dono dessa carta.", CartaLayaout.MAGIA, 1000, TipoMagiaNormal.GANHAR_VIDA) );
		cartas.push( new MagiaNormal("Báu do Tesouro", "Adiciona 1000 Pontos de Vida ao dono dessa carta.", CartaLayaout.MAGIA, 1000, TipoMagiaNormal.GANHAR_VIDA) );
		/*
		 * Monstros Normais
		 */
		cartas.push( new Monstro("Bartolomeo", "Um homem que faz tudo pelo ouro.", CartaLayaout.MONSTRO_NORMAL,
			       4, 1500, 1850,
			       TipoClasse.MERCENARIO) );
		cartas.push( new Monstro("Bartolomeo", "Um homem que faz tudo pelo ouro.", CartaLayaout.MONSTRO_NORMAL,
			       4, 1500, 1850,
			       TipoClasse.MERCENARIO) );
		cartas.push( new Monstro("Giovanni Dalle", "Muitos dizem que o céu é o limite, mas não para uma feiticeira.", CartaLayaout.MONSTRO_NORMAL,
			       3, 1800, 0,
			       TipoClasse.FEITICEIRA) );
		cartas.push( new Monstro("Giovanni Dalle", "Muitos dizem que o céu é o limite, mas não para uma feiticeira.", CartaLayaout.MONSTRO_NORMAL,
			       3, 1800, 0,
			       TipoClasse.FEITICEIRA) );
		cartas.push( new Monstro("Giovanni Dalle", "Muitos dizem que o céu é o limite, mas não para uma feiticeira.", CartaLayaout.MONSTRO_NORMAL,
			       3, 1800, 0,
			       TipoClasse.FEITICEIRA) );
		cartas.push( new Monstro("Framcesco Sforza, o Grande Escudo", "Evacuem a cidade. Preparem as defesas e deem um escudo para esse homem", CartaLayaout.MONSTRO_NORMAL,
			       2, 0, 1800,
			       TipoClasse.BARBARO) );
		cartas.push( new Monstro("Framcesco Sforza, o Grande Escudo", "Evacuem a cidade. Preparem as defesas e deem um escudo para esse homem", CartaLayaout.MONSTRO_NORMAL,
			       2, 0, 1800,
			       TipoClasse.BARBARO) );
		cartas.push( new Monstro("Framcesco Sforza, o Grande Escudo", "Evacuem a cidade. Preparem as defesas e deem um escudo para esse homem", CartaLayaout.MONSTRO_NORMAL,
			       2, 0, 1800,
			       TipoClasse.BARBARO) );
		
		/*
		 * Monstros de efeito
		 */
		cartas.push(new MonstroEfeito("Brau, o Coração de Freljord", "Ganha 400  pontos de defesa ao ser invocado", CartaLayaout.MONSTRO_EFEITO, 6, 2000, 2400,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIA_DEF,
				400));
		cartas.push(new MonstroEfeito("Brau, o Coração de Freljord", "Ganha 400  pontos de defesa ao ser invocado", CartaLayaout.MONSTRO_EFEITO, 6, 2000, 2400,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIA_DEF,
				400));
		cartas.push(new MonstroEfeito("Brau, o Coração de Freljord", "Ganha 400  pontos de defesa ao ser invocado", CartaLayaout.MONSTRO_EFEITO, 6, 2000, 2400,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, true, TipoEfeitoMonstro.AUMENTAR_PROPRIA_DEF,
				400));
		cartas.push(new MonstroEfeito("Miss Fortune, a Caçadora de Recompensas", "Diminui a defesa de um monstro inimigo em 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 200,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.DIMINUIR_DEF_INIMIGO,
				400));
		cartas.push(new MonstroEfeito("Miss Fortune, a Caçadora de Recompensas", "Diminui a defesa de um monstro inimigo em 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 200,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.DIMINUIR_DEF_INIMIGO,
				400));
		cartas.push(new MonstroEfeito("Miss Fortune, a Caçadora de Recompensas", "Diminui a defesa de um monstro inimigo em 400 pontos de ataque ao ter seu efeito ativado", CartaLayaout.MONSTRO_EFEITO, 4, 1700, 200,
				TipoClasse.MERCENARIO, PosicaoMonstro.NAO_INVOCADO, false, TipoEfeitoMonstro.DIMINUIR_DEF_INIMIGO,
				400));
		return cartas;
	}
}
