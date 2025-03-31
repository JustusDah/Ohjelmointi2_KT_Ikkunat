package com.example.ikkunat;

import javafx.application.Application;
import javafx.stage.Stage;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * Ohjelman main. Käynnistää ohjelman
 * @author justus
 */
public class LisaantyvaIkkunatMain extends Application {

    /**
     * @param primaryStage ohjelman Stage
     */
    @Override
    public void start(Stage primaryStage) {
        IkkunaOlio ikkunaOlio = new IkkunaOlio(1, new Point(500, 400));
        LocalDateTime avausaika = LocalDateTime.now();
        new IkkunatLuokka(ikkunaOlio.getNumero(), 500, 400, avausaika);
    }

    /**
     * Käynnistävä metodi
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
