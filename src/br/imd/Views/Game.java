package br.imd.Views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Monsters Cards Game versão JavaFX.
 * @author Iury
 *
 */
public class Game extends Application {
	
	private Stage primario;
	private BorderPane telaPrincipal;
	private VBox detalhes;
	private VBox log;
	private HBox maoJogador1;
	private HBox maoJogador2;
	private VBox campoJogador1;
	private VBox campoJogador2;
	private VBox tabuleiro;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primario = primaryStage;
		this.primario.setTitle("Monsters Card Game");
		this.initPrincipal();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void initPrincipal() {
		this.telaPrincipal = new BorderPane();
		this.telaPrincipal.prefHeight(680);
		this.telaPrincipal.prefWidth(1024);
		// FIXME chamar as funções de criação
		this.detalhes = this.criarTelaDetalhes();
		this.maoJogador1 = this.criarMaoJogador();
		this.maoJogador2 = this.criarMaoJogador();
		// FAZER A URGENCIA A CIMA
		
		//this.tabuleiro = new VBox();
		
		//this.tabuleiro.getChildren().add(this.campoJogador2);
		//this.tabuleiro.getChildren().add(this.campoJogador2);
		
		this.telaPrincipal.setLeft(this.detalhes);
		this.telaPrincipal.setTop(this.maoJogador2);
		this.telaPrincipal.setBottom(this.maoJogador1);
		//this.telaPrincipal.setCenter(this.tabuleiro);
		//this.telaPrincipal.setRight(this.log);
		
		Scene scene = new Scene(this.telaPrincipal);
		this.primario.setScene(scene);
		this.primario.show();
	}
	
	
	private VBox criarTelaDetalhes() {
		VBox vb = new VBox();
		
		ImageView view = new ImageView();
		view.setFitWidth(100);
		view.setFitHeight(140);
		Image image = new Image(getClass().getResourceAsStream("../Resources/clubs.png"));
		view.setImage(image);
		Label labelNivel = new Label("Nivel: 4");
		Label labelAtk = new Label("Ataque: 1200");
		Label labelDef = new Label("Defesa: 800");
		Label labelDescricao = new Label("Descricao: Blablabla");
		
		Button btnInvocar = new Button("Invocar");
		vb.getChildren().add(view);
		vb.getChildren().add(labelNivel);
		vb.getChildren().add(labelAtk);
		vb.getChildren().add(labelDef);
		vb.getChildren().add(labelDescricao);
		vb.getChildren().add(btnInvocar);
		return vb;
	}

	private HBox criarMaoJogador() {
		HBox hb = new HBox();
		
		ImageView view = new ImageView();
		view.setFitWidth(100);
		view.setFitHeight(140);
		Image image = new Image(getClass().getResourceAsStream("../Resources/clubs.png"));
		view.setImage(image);
		
		ImageView view2 = new ImageView();
		view2.setFitWidth(100);
		view2.setFitHeight(140);
		Image image2 = new Image(getClass().getResourceAsStream("../Resources/diamonds.png"));
		view2.setImage(image2);
		
		ImageView view3 = new ImageView();
		view3.setFitWidth(100);
		view3.setFitHeight(140);
		Image image3 = new Image(getClass().getResourceAsStream("../Resources/hearts.png"));
		view3.setImage(image3);
		
		ImageView view4 = new ImageView();
		view4.setFitWidth(100);
		view4.setFitHeight(140);
		Image image4 = new Image(getClass().getResourceAsStream("../Resources/spades.png"));
		view4.setImage(image4);
		
		hb.getChildren().add(view);
		hb.getChildren().add(view2);
		hb.getChildren().add(view3);
		hb.getChildren().add(view4);
		return hb;
	}
}
