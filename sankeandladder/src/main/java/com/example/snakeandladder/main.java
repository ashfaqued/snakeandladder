package com.example.snakeandladder;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

   public static Group root;

    @Override

    public void start(Stage stage) throws IOException {
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        root= new Group();
        gamepage page= new gamepage();
        root.getChildren().add(page.root);

        Scene scene = new Scene(root, 800, 500);

        stage.setTitle("Snake And Ladder");
        stage.setScene(scene);
        stage.show();
    }


}