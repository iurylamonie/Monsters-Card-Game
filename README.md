# Monsters-Card-Game

Monsters Card Game é um jogo de cartas baseado em turnos, onde dois jogadores se enfrentam com o objetivo de reduzir os pontos de vida do adversário a zero. Durante os turnos os jogadores utilizam suas cartas, que são divididas em duas categorias, monstros e magias.

## Regras

### 1. Duelos
1. Condições de Preparação e Vitória
> Em um duelo, os dois jogadores começam com 4.000 pontos de vida e a ordem dos turnos é decidida pelo Sistema. Após isso, ambos os jogadores compram 4 cartas dos seus baralhos, que serão considerados da sua “mão inicial”.
	Durante o duelo, o primeiro jogador a reduzir os Pontos de Vida do oponente a “0” será considerado o vencedor. Se os dois jogadores tiverem seus pontos de vida reduzidos a 0 ao mesmo tempo, será um empate. Um jogador perderá se precisar comprar uma carta do seu baralho e não puder.
2. Turnos e Fases
> A ordem das ações que cada jogador executa é chamada turno. O duelo avança conforme cada jogador alterna entre seus turnos. Os turnos são contados como o primeiro turno do jogador que começa a jogar sendo o Turno 1, seguindo pelo turno do oponente, que é o Turno 2, depois o primeiro joga o Turno 3, e assim por diante. O turno de um jogador é dividido em fases distintas. Um turno consiste de 3 fases: Fase de Compra, Fase Principal e Fase de Batalha.
	Fase de Compra: o jogador compra uma carta do baralho. O jogador que joga primeiro não compra no primeiro turno do duelo.
	Fase Principal: os jogadores podem usar cartas para Invocar um monstro ou magia, e até ativar o efeito de uma carta, sejá monstro ou mágica. Nessa fase também é permitido mudar a posição de batalha do monstro.
	Fase de Batalha: o jogador pode escolher um de seus monstros em posição de ataque e selecionar um alvo de ataque para batalhar. Sequência básica de batalha: (1) Selecione um monstro em posição de ataque para fazer um ataque. Cada monstro só pode declarar ataque uma vez por turno. (2) Selecione um alvo para atacar no campo oponente. Se não houver nenhum monstro no lado do oponente, seus monstros atacarão o oponente diretamente. (3) Ataque os monstros controlados pelo seu oponente. Se não houver nenhum monstro no lado do oponente, seus monstros atacarão o oponente diretamente. (4) Os monstros destruídos em batalha vão para o Cemitério. Se nenhuma batalha for iniciada, a Fase de Batalha pode ser pulada. 
	O jogador que joga primeiro não tem a Fase de Batalha no primeiro turno do Duelo.
### 2. Posição de Batalha e Invocação
1. Invocação de Monstros
>Para Invocações é possível realizar uma das seguintes ações uma vez por turno: invocação-normal e invocação-tributo.
	Invocação-normal, é uma forma de invocar um monstro é colocá-lo em posição de ataque ou defesa da sua mão para a zona de monstros.
	Invocação-tributo, monstros de Nível 5 ou superior requerem que jogador ofereça como tributo (enviar para o cemitério) outros monstros do seu lado do tabuleiro antes de invocar esse monstro de Nível 5 ou superior. Ao realizar uma invocação-tributo, você terá que oferecer como tributo 1 monstro para invocar um monstro de Nível 5 ou 6, ou 2 monstros para invocar um monstro de Nível 7 ou superior.
2. Posições de Batalha do Monstro
> O jogador pode mudar a posição de batalha de cada monstro em seu campo uma vez por turno durante a sua Fase Principal, mas não pode mudar a posição de um monstro no turno em que ele é colocado no tabuleiro.
	Em posição de ataque, ataques podem ser feitos contra o oponente ou os monstros dele, para isso deve está na Fase de Batalha.
	Em posição de defesa, o monstro não pode efetuar nenhum ataque.
### 3. Resultado de Batalha
1. Posição de Ataque x Posição de Ataque
	> Quando o monstro alvejado está em posição de ataque, compare os pontos de ataque (ATK) do monstro do atacante com o ATK do alvo. 
Quando o monstro do atacante tiver um ATK maior: A diferença em ATK será descontada dos pontos de vida do oponente em forma de dano. O monstro do oponente em posição de ataque será destruído e enviado ao cemitério.
	Quando o monstro do atacante tiver um ATK menor: A diferença em ATK será descontada nos pontos de vida do atacante na forma de dano. O monstro do atacante em posição de ataque será destruído e enviado ao cemitério.
	Quando o monstro do atacante tiver um ATK igual: Nenhum dos jogadores sofrerá dano, e os monstros serão destruídos e enviados para o cemitério.
2. Posição de Ataque x Posição de Defesa
	> Quando um monstro alvejado está em posição de defesa, compare os Pontos de ataque(ATK) do monstro do atacante com os pontos de defesa (DEF) do alvo.
	Quando o monstro do atacante tiver um ATK maior que a DEF do alvo: Nenhum dos jogadores sofrerá dano, e o monstro do oponente em posição de defesa será destruído e enviado ao cemitério.
	Quando o monstro do atacante tiver um ATK menor que a DEF do alvo: A diferença em ATK e DEF será descontada nos pontos de vida do atacante na forma de dano. Nenhum dos monstros será destruída.
	Quando o monstro do atacante tiver um ATK igual: Nenhum dos jogadores sofrerá dano, e nenhum dos monstros será destruído.
3. Ataques Diretos
	> Se não houver monstros no lado do campo do oponente, o monstro ataca diretamente o oponente.
	Se o ataque direto acertar, o jogador causa dano nos pontos de vida do oponente. O dano reduzido baseará no valor dos pontos de ataque (ATK) do monstro atacante.


## Requisitos:

1. JavaFX 15.0.1
2. e(fx)clipse 3.6.0
3. JavaSE 13
4. Eclipse IDE 2020-09

## Modelagem do Sistema
- [Diagrama de Classes](https://github.com/) - Ainda não publicado no Git.
- [Diagrama de Casos de Uso](https://github.com/) - Ainda não publicado no Git.

## Estrutura das Pastas

1. [`br.imd.Constants`](https://github.com/iurylamonie/Monsters-Card-Game/tree/main/src/br/imd/Constants) - contém todas as classes de arquivos com as variaveis constantes utilizadas no projeto. 
2. [`br.imd.Controllers`](https://github.com/iurylamonie/Monsters-Card-Game/tree/main/src/br/imd/Constrollers) - contém todas classes de arquivos de controle.
3. [`br.imd.Models`](https://github.com/iurylamonie/Monsters-Card-Game/tree/main/src/br/imd/Models) - contém as classes com o modelo de negocio.
4. [`br.imd.Models.Interfaces`](https://github.com/iurylamonie/Monsters-Card-Game/tree/main/src/br/imd/Models/Interfaces) - contém as classes de arquivos de interface do projeto.
5. [`br.imd.Rules`](https://github.com/iurylamonie/Monsters-Card-Game/tree/main/src/br/imd/Rules) - contém as classes de arquivos de exceção do projeto.
6. [`br.imd.Views`](https://github.com/iurylamonie/Monsters-Card-Game/tree/main/src/br/imd/Constants) - contém as classes de arquivos com a Interface do Usuario.

## Classes de Exceções

1. `HandFullException`: Quando a mão do jogador estiver com 6 cartas ele não pode mais comprar.
2. `NoCardsDrawException`: Quando o jogador vai comprar carta mas ele não tem mais cartas no baralho, ele perde o jogo.
3. `WinnerException`: Quando o jogador inimigo chegar a zero da PV.
4. `EffectHasActivatedException`: Quando um monstro tentar ativar seu efeito, mas o efeito já tinha sido ativado.
5. `SummonedTributeException`: Quando o jogador invoca um monstro com mais de 4 estrelas.
6. `NoSpaceZoneException`: Quanto o jogador tentar invocar uma carta mas não tem espaço na zona de monstros.
7. `AlreadySummonedMonsterException`: Quando o jogador tentar invocar um monstro no mesmo turno que já invocou outro.
8. `NotChangeBattlePositionException`: O monstro não pode mudar de posição de batalha durante a Fase de Batalha o no turno que é invocado.


## TO DO

- Remover as cartas magicas de equipamento quando o monstro na qual ela for associada deixar o campo.
- Monstros não podem ser invocadas durante a fase de batalha.
- Implementar a Interface JavaFX funcional.

## Rodando a Interface Simples de Console

1. Basta executar o aquivo `GameConsole.java` localizado em `br.imd.Views`




## Rodando a Interface JavaFX ( Essa Interface não funciona)!

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

>é necessario que o passo de instalação anterior tenha sido feito!

Configurando o run:
1. Vá em run > Run Configurations.
2. No Java Application vá em Arguments e em VM arguments coloque:  --module-path "path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml
3. onde path\to é o caminho onde você descompactou o JavaFX SDK baixado.


