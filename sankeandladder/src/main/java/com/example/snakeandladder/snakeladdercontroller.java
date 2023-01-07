package com.example.snakeandladder;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class snakeladdercontroller {
    @FXML
    Text number;

    @FXML
      Text changeturn;
     int turn=1;


     HashMap<Pair<Double,Double>,Pair<Double,Double>> snakeLadderCoord;


     @FXML
    ImageView player1,player2;



    @FXML

    public void roll(MouseEvent event) throws IOException {
     //   System.out.println("Dice rolling");
        getSnakeLadderCoordinate();
        Random random= new Random();
        int rolling= random.nextInt(6)+1;
       // rolling=1;
        // System.out.println(rolling);
        number.setText(""+rolling);


      if(turn==1) {
         Pair<Double,Double> moveCord= movement(player1.getTranslateX(),player1.getTranslateY(),rolling);
         player1.setTranslateX(moveCord.getKey());
         player1.setTranslateY(moveCord.getValue());
         if(snakeLadderCoord.containsKey(new Pair<>(moveCord.getKey(),moveCord.getValue())))
         {
             player1.setTranslateX(snakeLadderCoord.get(new Pair<>(moveCord.getKey(),moveCord.getValue())).getKey());
             player1.setTranslateY(snakeLadderCoord.get(new Pair<>(moveCord.getKey(),moveCord.getValue())).getValue());

         }

         checkwin(player1.getTranslateX(),player1.getTranslateY());
      }
      else {
//          Double x = player2.getTranslateX();
//          Double y = player2.getTranslateY();
//
//          x += rolling * 50;
//          player2.setTranslateX(x);
          Pair<Double,Double> moveCord=movement(player2.getTranslateX(),player2.getTranslateY(),rolling);
          player2.setTranslateX(moveCord.getKey());
          player2.setTranslateY(moveCord.getValue());
          if(snakeLadderCoord.containsKey(new Pair<>(moveCord.getKey(),moveCord.getValue())))
          {
              player2.setTranslateX(snakeLadderCoord.get(new Pair<>(moveCord.getKey(),moveCord.getValue())).getKey());
              player2.setTranslateY(snakeLadderCoord.get(new Pair<>(moveCord.getKey(),moveCord.getValue())).getValue());

          }

          checkwin(player2.getTranslateX(),player2.getTranslateY());
      }
        if(rolling!=6) {
            if (turn == 1) {
                turn = 2;
                changeturn.setText("Player 2's Turn");
            } else {
                turn = 1;
                changeturn.setText("Player 1's Turn");
            }
    }
    }
    Pair<Double, Double> movement(double x,double y, int rolling){
         Double movex = x;
         Double movey = y;

        // movex +=rolling*50;
         if(movey%100==0) {
             movex +=rolling*50;
             if (movex > 500) {
                 movex = 500 * 2 - movex + 50;
                 movey -= 50;
             }
         }
         else {
             movex -=rolling*50;
             if(movex<50)
             {
                 if(movey==-450)
                     return (new Pair<>( x,y));
                 movex= -1*(movex-50);
                 movey -= 50;
             }
         }
       //  x += rolling * 50;
         //player1.setTranslateX(x);
        return new Pair<>(movex,movey);
     }
     void checkwin(double x, double y) throws IOException {
         if(x==50 && y== -450)
         {
             Alert winalert = new Alert(Alert.AlertType.INFORMATION);
             winalert.setHeaderText("Result");
             if(turn==1)
             {
                 winalert.setContentText("Player 1 has won the game");
             }
             else {
                 winalert.setContentText("Player 2 has won the game");
             }
             winalert.showAndWait();
              gamepage page= new gamepage();
             main.root.getChildren().setAll(page.root);

         }
     }
     void getSnakeLadderCoordinate(){
        snakeLadderCoord= new HashMap<>();
        snakeLadderCoord.put(new Pair<> (50.0,0.0),new Pair<>(150.0,-150.0));
         snakeLadderCoord.put(new Pair<> (200.0,0.0),new Pair<>(350.0,-50.0));
         snakeLadderCoord.put(new Pair<> (200.0,-50.0),new Pair<>(350.0,0.0));
         snakeLadderCoord.put(new Pair<> (450.0,00.0),new Pair<>(500.0,-150.0));
         snakeLadderCoord.put(new Pair<> (50.0,-100.0),new Pair<>(100.0,-200.0));
         snakeLadderCoord.put(new Pair<> (400.0,-100.0),new Pair<>(200.0,-400.0));
         snakeLadderCoord.put(new Pair<> (100.0,-300.0),new Pair<>(100.0,-50.0));
         snakeLadderCoord.put(new Pair<> (500.0,-250.0),new Pair<>(350.0,-300.0));
         snakeLadderCoord.put(new Pair<> (500.0,-350.0),new Pair<>(500.0,-450.0));
         snakeLadderCoord.put(new Pair<> (50.0,-350.0),new Pair<>(500.0,-450.0));
         snakeLadderCoord.put(new Pair<> (200.0,-300.0),new Pair<>(50.0,-250.0));
         snakeLadderCoord.put(new Pair<> (350.0,-250.0),new Pair<>(350.0,-150.0));
         snakeLadderCoord.put(new Pair<> (150.0,-450.0),new Pair<>(100.0,-350.0));
         snakeLadderCoord.put(new Pair<> (300.0,-450.0),new Pair<>(300.0,-350.0));
         snakeLadderCoord.put(new Pair<> (400.0,-450.0),new Pair<>(400.0,-350.0));
         snakeLadderCoord.put(new Pair<> (350.0,-400.0),new Pair<>(200.0,-100.0));
     }
}


