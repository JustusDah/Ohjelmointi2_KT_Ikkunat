package com.example.ikkunat;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class IkkunatLuokka {

    //Ikkunan koordinaatit
    private double x, y;

    public IkkunatLuokka(double x, double y) {
        Stage stage = new Stage();
        setupStage(stage, x, y);
    }

    private void setupStage(Stage stage, double x, double y) {
        this.x = x;
        this.y = y;

        //Kuva
        Image image = new Image(getClass().getResourceAsStream("/bedbuge.jpeg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);


        //Nappula
        Button suljeButton = new Button("Sulje ikkuna :3");
        suljeButton.setOnAction(e -> {
            luoUudetIkkunat(stage);
            stage.close();
        });


        //Hbox root
        HBox root = new HBox(10, imageView, suljeButton);
        Scene scene = new Scene(root, 330, 250);
        stage.setScene(scene);
        stage.setTitle("Lisääntyvät ikkunat :D");

        stage.setX(x);
        stage.setY(y);

        //Estää ikkunan sulkeutumisen
        stage.setOnCloseRequest(e -> {
            e.consume();
            luoUudetIkkunat(stage);
            stage.close();
        });

        stage.show();

    }

    private void luoUudetIkkunat(Stage oldStage){
        //Saa näytön tiedot
        Screen paaNaytto = Screen.getPrimary();
        double naytonLev = paaNaytto.getBounds().getWidth();
        double naytonKork = paaNaytto.getBounds().getHeight();

        //Random koordinaatit mihin ikkunat aukeavat. Varmistaa myös etteivät ilmesty näytön ulkopuolelle
        double randomX1 = Math.random() * (naytonLev - 300);
        double randomY1 = Math.random() * (naytonKork - 200);
        double randomX2 = Math.random() * (naytonLev - 300);
        double randomY2 = Math.random() * (naytonKork - 200);

        //Luo ikkunat
        Platform.runLater(() -> {
            new IkkunatLuokka(randomX1, randomY1);
            new IkkunatLuokka(randomX2, randomY2);
        });
    }

    /*Vielä puuttuu se tallennushomma. Oon sen kanssa tapellut, mutta ei oikein oo vielä onnistunut niin se on tästä
    palautuksesta jätetty pois. Ohjelma toimii melkein kuten haluan, vielä silti on korjattavaa ja lisättäviä
    ominaisuuksia.*/
}
