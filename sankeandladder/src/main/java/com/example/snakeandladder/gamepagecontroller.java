package com.example.snakeandladder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class  gamepagecontroller {
    @FXML
    public void start(MouseEvent event) throws IOException {
//System.out .println("play button click");

     AnchorPane start= FXMLLoader.load(getClass().getResource("snakenladder.fxml"));
      main.root.getChildren().setAll(start);

    }
}
