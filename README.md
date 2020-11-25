# Monsters-Card-Game
 Descrição Temporária: Projeto para a Disciplina de Linguagem de Programação 2 do curso TI UFRN. A ideia é criar um jogo de cartas baseado em turnos onde 2 jogadores vão se enfrentar, vence o jogador que reduzir primeiro os Pontos de Vida do adversário a 0. Cada jogador vai ter seu próprio baralho de cartas, no inicio do jogo cada jogador puxa 4 cartas do baralho e as coloca na sua mão, e a cada turno o jogador da vez vai poder invocar, colocar no tabuleiro, uma carta do tipo monstro e uma quantidade indefinida de cartas do tipo mágica. Cada turno é dividido em 3 fases, a primeira fase é a Fase de Compra, onde o jogador do turno puxa um carta do seu baralho e coloca na mão, a segunda fase é a Fase Principal, nessa fase o jogador pode fazer a invocação da sua carta monstro e as invocações de suas cartas mágicas, e a ultima fase é a Fase de Batalha, nesse fase os jogadores não podem mais fazer invocação de cartas e o jogador da vez pode decidir quais dos seus monstros vai batalhar contra os monstros do adversário, o monstro com o ataque menor perde a batalha e é destruído, a diferença entre os ataques dos monstros será descontado nos Pontos de Vida do jogador que teve o monstro destruído. A ideia inicial é que os monstros tenham seus Pontos de Ataque, possivelmente Pontos de Defesa ( para uma mecânica que posso ser adicionada), sua classe ( Bárbaro, Sacerdote, etc. )[As cartas mágicas vão servir de suporte para as classes, como por exemplo aumentar o ataque de um bárbaro ao lutar contra um sacerdote].

## MUDANÇAS PARA REALIZAR NO DIAGRMA DE CLASSES
Iury
1. **URGENTE**: Criar abastrata classe `Magia` com os atributos `pontos` e fazer as classes MAgias Herdas delas.

1. Em `iAcoesMonstros`: Mudar os retornos de `boolean` para `void`.
2. Mudar as constantes de todos os `ENUMs` para ficar igual aos do projeto.
3. Mudar em `iAcoesMonstros` a assinatura da função `mudarPosicaoBatalha` o parametro `carta` para `posicaoCartaTab`.
4. Remover o atributo `efeitofoiAtivado` na classe `MonstroEfeito`, pois a classe `Campo` possui um atributo similar, `zonaEfeitoMonstros`.
5. Adicionar os parametros: `Jogador jogadorAtivou, int posicaoCartaAtivou, Jogador  jogadorAlvo, int posicaoCartaAlvo` na função `ativarEfeito` da Interface `iEfeitos`.
7. Modificar o retorno da funções `invocarMonstro`, `invocarMAgia` e `mudarPosicaoBatalha` de `boolean` para `void` na classe `Jogador`
Tiago
8. Modificar classe `Campo`: Adicionar funções ` public void setEspacoMonstro( Monstro monstro, int posicao) ` , `public Magia getEspacoMagia( int posicao )` , `public void setEspacoMagia`, `public Monstro getEspacoMonstro( int posicao )` , `public boolean isZonaEfeitoMonstro(int posicao)`, `public void setZonaEspacoEfeitosMonstros(int posicao, boolean valor)`, `public int espacoZonaMonstroVazio()`, `public int espacoZonaMagiaVazio()`

9. Modificar classe Tabuleiro: Modificar funções: `public void ativarEfeitoMostro(Jogador jogadorAtivou, int posicaoCartaAtivou, Jogador  jogadorAlvo, int posicaoCartaAlvo)`,  `public void enviarCemiterio( Carta carta, int posicaoCamp )` -- Adicionar funções: `public void colocarMagiaTabuleiro(int magia)`

10. Modifica classe `MagiaEquipamento`: Adicionar: atributo `monstroEquipado`

## Requisitos:

JavaFX 15.0.1
e(fx)clipse 3.6.0
JavaSE 14
Eclipse IDE 2020-09

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

## Rodando o projeto:

é necessario que o passo de instalação anterior tenha sido feita!

Configurando o run:
1. Vá em run > Run Configurations.
2. No Java Application vá em Arguments e em VM arguments coloque:  --module-path "path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml
3. onde path\to é o caminho onde você descompactou o JavaFX SDK baixado.


