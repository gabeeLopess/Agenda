package com.ifsc.gabriel.bruno.vinicius.menu;

import com.ifsc.tds.gabriel.bruno.vinicius.controller.ContatoListaController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Menu extends Application {


	public void start(Stage primaryStage) {
		try {
			// a
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ifsc/tds/gabriel/bruno/vinicius/view/ContatoLista.fxml"));
			Parent contatoXML = loader.load();
			
			// carregar controle e cena
			ContatoListaController contatoListaController = loader.getController();
			Scene menulayout = new Scene(contatoXML);

			Stage menuJanela = new Stage();
			menuJanela.initModality(Modality.APPLICATION_MODAL);
			menuJanela.resizableProperty().setValue(Boolean.FALSE);
			menuJanela.setScene(menulayout);
			menuJanela.setTitle("Sistema");

			// evento para fechar janela
			menuJanela.setOnCloseRequest(e -> {
				if (contatoListaController.onCloseQuery()) {
					System.exit(0);
				} else {
					e.consume();
				}
			});

			menuJanela.show();
			
			//posição da janela
			Rectangle2D posicaoJanela = Screen.getPrimary().getVisualBounds();
			menuJanela.setX((posicaoJanela.getWidth()- menuJanela.getWidth())/2);
			menuJanela.setY((posicaoJanela.getHeight() - menuJanela.getHeight())/2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
