# Desenvolvedor
Iury Lamonie

# Monsters-Card-Game
 Projeto para a Disciplina de Linguagem de Programação 2 do curso TI UFRN. Monsters Card Game é um jogo de cartas baseado em turnos, onde dois jogadores se enfrentam com o objetivo de reduzir os pontos de vida do adversário a zero. Durante os turnos os jogadores utilizam suas cartas, que são divididas em duas categorias, monstros e magias.

## Requisitos:
1. JavaFX 15.0.1
2. e(fx)clipse 3.6.0
3. JavaSE 13
4. Eclipse IDE 2020-09
## MUDANÇAS PARA REALIZAR NO DIAGRMA DE CLASSES

## Rodando a Interface Simples de Console
1. Basta executar o aquivo `GameConsole.java` localizado em `br.imd.Views`

## Estrutura das Pastas
1. `br.imd.Constants` contém todas as classes de arquivos com as variaveis constantes utilizadas no projeto.
2. `br.imd.Controllers` contém todas classes de arquivos de controle.
3. `br.imd.Models` contém as classes com o modelo de negocio.
4. `br.imd.Models.Interfaces` contém as classes de arquivos de interface do projeto.
5. `br.imd.Rulas`contém as classes de arquivos de exceção do projet.
6. `br.imd.Viws` contém as classes de arquivos com a Interface do Usuario.

## Classes de Exceções

1. HandFullException: Quando a mão do jogador estiver com 6 cartas ele não pode mais comprar.
2. NoCardsDrawException: Quando o jogador vai comprar carta mas ele não tem mais cartas no baralho, ele perde o jogo.
3. WinnerException: Quando o jogador inimigo chegar a zero da PV.
4. EffectHasActivatedException: Quando um monstro tentar ativar seu efeito, mas o efeito já tinha sido ativado.
5. SummonedTributeException: Quando o jogador invoca um monstro com mais de 4 estrelas.
6. NoSpaceZoneException: Quanto o jogador tentar invocar uma carta mas não tem espaço na zona de monstros.
7. AlreadySummonedMonsterException: Quando o jogador tentar invocar um monstro no mesmo turno que já invocou outro.
8. NotChangeBattlePositionException: O monstro não pode mudar de posição de batalha durante a Fase de Batalha o no turno que é invocado.

## TO DO
1. Remover as cartas magicas de equipamento quando o monstro na qual ela for associada deixar o campo.
2. Monstros não podem ser invocadas durante a fase de batalha.
2. Implementar a Interface JavaFX funcional.

# Rodando a Interface JavaFX ( Essa Interface não funciona)!

## Instalando JavaFX 15.0.1 no Eclipse:

1. Baixe o JavaFX SDK versão 15.0.1 no site Gluon (https://gluonhq.com/products/javafx/).
2. Descompacte em um local de sua preferencia.
3. Agora é necessario criar uma User Library no eclipse, windows > Preferences > Java > Build Path > User Libraries.
4. Clique em New e coloque no nome da biblioteca como "Java FX 15.0.1" ou algo de sua preferencia.
5. Seleciona a biblioteca criada e clique na opção "Add External JARs".
6. Procure o local onde foi descompactado o JavaFX baixado e vá na pasta "lib".
7. Adicione todos os arquvios JAR dessa pasta na biblioteca.
8. Para adicionar O JavaFX no eclipse clique com o mouse direito na pasta do projeto (dentro do eclipse).
9. Vá em Build Path > Configure Build Path.
10. Dentro da nova janela vá em Libraries > Clashpath e clique Add Library, e depois em User Library.
11. Adicione a biblioteca criada no Clashpath

## Configurando o run:

é necessario que o passo de instalação anterior tenha sido feita!

Configurando o run:
1. Vá em run > Run Configurations.
2. No Java Application vá em Arguments e em VM arguments coloque:  --module-path "path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml
3. onde path\to é o caminho onde você descompactou o JavaFX SDK baixado.


