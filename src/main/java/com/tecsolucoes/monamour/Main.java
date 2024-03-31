package com.tecsolucoes.monamour;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tela_inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ArtCraftERP - MonAmour");
        stage.setScene(scene);
        stage.show();

        stage.getIcons().add(new Image(Main.class.getResourceAsStream("Imagens/Logo.png")));
    }

    public static void main(String[] args) {
        launch();
    }
}