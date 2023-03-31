package com.ifsc.tds.gabriel.bruno.vinicius.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.ifsc.tds.gabriel.bruno.vinicius.entity.Contato;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ContatoEditController implements Initializable{
	
	 @FXML
	 private AnchorPane pnlPrincipal;
	 
	 @FXML
	private GridPane pnlDados;

    @FXML
    private Label lblNome;

    @FXML
    private TextField txtNome;

    @FXML
    private Label lblTelefone;

    @FXML
    private TextField txtTelefone;

    @FXML
    private Label lblEmail;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnOK;
    
    @FXML
    private HBox pnlBotoes;

    @FXML
    private Button btnCancelar;

	private Contato contato;

	private boolean okClick = false;

	private Stage janelaContatoEdit;

    @FXML
    void onClickBtnCancelar(ActionEvent event) {
    	this.getJanelaContatoEdit().close();
    
    }

    @FXML
    void onClickBtnOK(ActionEvent event) {
    	if (validarCampos()) {
			this.contato.setNome(this.txtNome.getText());
			this.contato.setTelefone(this.txtTelefone.getText());
			this.contato.setEmail(this.txtEmail.getText());

			this.okClick = true;
			this.getJanelaContatoEdit().close();
		}
	}
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}
	
	public Stage getJanelaContatoEdit() {
		return janelaContatoEdit;
	}

	public void setJanelaContatoEdit(Stage janelaContatoEdit) {
		this.janelaContatoEdit = janelaContatoEdit;
	}
	
	public void populaTela(Contato contato) {
		this.contato = contato;

		this.txtNome.setText(contato.getNome());
		this.txtTelefone.setText(contato.getTelefone());
		this.txtEmail.setText(contato.getEmail());
	}
	

	public boolean isOkClick() {
		return okClick;
	}
	
	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.txtNome.getText() == null || this.txtNome.getText().trim().length() == 0) {
			mensagemErros += "adicione o Nome!\n";
		}

		if (this.txtTelefone.getText() == null || this.txtTelefone.getText().trim().length() == 0) {
			mensagemErros += "adicione o Telefone!\n";
		}
		
		if (this.txtEmail.getText() == null || this.txtEmail.getText().trim().length() == 0) {
			mensagemErros += "adicione o Email!\n";
		}

		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaContatoEdit);
			alerta.setTitle("Dados invalidos!");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();

			return false;
		}
	}
}

	


