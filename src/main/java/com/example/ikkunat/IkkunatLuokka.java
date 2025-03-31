package com.example.ikkunat;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.awt.*;
import java.time.LocalDateTime;

/**
 *Ikkuna luokka mikä tekee ikkunat jotka sulkeutuessaan luovat tilalle kaksi uutta ikkunaa
 * @author justus
 */
public class IkkunatLuokka {

    private double x, y;
    private IkkunaOlio ikkunaOlio;

    /**
     * Luo ikkunan annetuila parametreilla
     * @param numero kokonaisluku
     * @param x Poin
     * @param y Poin
     * @param avausaika LocalDateTime
     */
    public IkkunatLuokka(int numero, double x, double y, LocalDateTime avausaika) {
        this.x = x;
        this.y = y;
        this.ikkunaOlio = new IkkunaOlio(numero, new Point((int) x, (int) y));
        Stage stage = new Stage();
        setupStage(stage, x, y);
        IkkunaHallinta.teeIkkuna(ikkunaOlio);
    }

    /**
     * Miltä ikkuna näyttää ja miten se toimii
     * @param stage olio mihin ikkuna tehdään
     * @param x Point
     * @param y Point
     */
    private void setupStage(Stage stage, double x, double y) {
        //Kuva
        Image image = new Image(getClass().getResourceAsStream("/bedbuge.jpeg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);


        //Nappulat
        Button palautaButton = new Button("Palauta aiemmat ikkunat.");
        palautaButton.setOnAction(e -> {
            IkkunaHallinta.palautaIkkunat();
        });
        Button suljeButton = new Button("Sulje ikkuna :3");
        suljeButton.setOnAction(e -> {
            luoUudetIkkunat(stage);
            stage.close();
        });

        //Teksti missä kaikki tieot
        Text tiedotText = new Text("Ikkunan Numero: " + ikkunaOlio.getNumero()
                + "\nIkkunan sijainti: " + ikkunaOlio.getSijainti());

        //Vbox kuvalle ja tekstille
        VBox kuvaJaTiedot = new VBox(5, imageView, tiedotText);

        //napeille
        VBox nappulat = new VBox(5, suljeButton, palautaButton);
        nappulat.setAlignment(Pos.TOP_LEFT);

        //Hbox root
        HBox root = new HBox(1, kuvaJaTiedot, nappulat);
        Scene scene = new Scene(root, 500, 250);
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

    /**
     * Luo sulkemisen jälkeen uudet ikkunat
     * @param oldStage vanha stage
     */
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
            new IkkunatLuokka(ikkunaOlio.getNumero(), randomX1, randomY1, ikkunaOlio.getAvausaika());
            new IkkunatLuokka(ikkunaOlio.getNumero(), randomX2, randomY2, ikkunaOlio.getAvausaika());
        });
    }

}
