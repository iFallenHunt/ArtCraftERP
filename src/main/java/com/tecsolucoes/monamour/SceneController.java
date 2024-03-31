package com.tecsolucoes.monamour;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;

public class SceneController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void switchToTelaInicio(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_inicio.fxml"));
        // Não é necessário criar um novo EventObject, pois o mouseEvent já é passado como parâmetro
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTelaVenda(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_venda.fxml"));
        // Não é necessário criar um novo EventObject, pois o mouseEvent já é passado como parâmetro
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTelaProdutos(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_produtos.fxml"));
        // Não é necessário criar um novo EventObject, pois o mouseEvent já é passado como parâmetro
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTelaClientes(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_clientes.fxml"));
        // Não é necessário criar um novo EventObject, pois o mouseEvent já é passado como parâmetro
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTelaFornecedores(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_fornecedores.fxml"));
        // Não é necessário criar um novo EventObject, pois o mouseEvent já é passado como parâmetro
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTelaFinanceiro(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_financeiro.fxml"));
        // Não é necessário criar um novo EventObject, pois o mouseEvent já é passado como parâmetro
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTelaEstoque(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_estoque.fxml"));
        // Não é necessário criar um novo EventObject, pois o mouseEvent já é passado como parâmetro
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}





