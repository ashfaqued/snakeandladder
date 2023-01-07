package com.example.snakeandladder;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class gamepage {
    public AnchorPane root;
    gamepage() throws IOException{
        root= FXMLLoader.load(getClass().getResource("gamepage.fxml"));


    }
}
