package com.example.ikkunat;

import javafx.application.Application;
import javafx.stage.Stage;

public class LisaantyvaIkkunat extends Application {

    @Override
    public void start(Stage primaryStage) {
        new IkkunatLuokka(500, 400);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
