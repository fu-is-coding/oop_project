package com.example.src;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BasicGraphicDisplay extends GameDisplay {
    final static int PLAYERCARD = 4, POOLCARD = 8;
    static CardPane[][] playerCardsImage;
    static CardPane[] poolCardsImage;
    static GridPane poolCardsPane;
    static Player[] players;
    static Text[] playerScoreText;


    public void paint(Stage primaryStage) {
        /* GUI Design begin */
        playerCardsImage = new CardPane[4][PLAYERCARD];
        for(int i = 0; i < playerCardsImage.length; i++){
            for(int j = 0; j < playerCardsImage[i].length; j++){
                playerCardsImage[i][j] = new CardPane(75);
            }
        }

        poolCardsImage = new CardPane[PLAYERCARD*4 + POOLCARD];
        for(int i = 0; i < poolCardsImage.length; i++){
            poolCardsImage[i] = new CardPane(60);
        }

        HBox player1CardsPane = new HBox(5), player3CardsPane = new HBox(5);
        player1CardsPane.setPrefHeight(115); player3CardsPane.setPrefHeight(115);
        for(int i = 0; i < 4; i++){
            player1CardsPane.getChildren().add(playerCardsImage[0][i]);
            player3CardsPane.getChildren().add(playerCardsImage[2][i]);
        }

        GridPane player2CardsPane = new GridPane(), player4CardsPane = new GridPane();
        player2CardsPane.setVgap(5);    player4CardsPane.setVgap(5);
        player2CardsPane.setHgap(5);    player4CardsPane.setHgap(5);
        player2CardsPane.setPrefHeight(235); player4CardsPane.setPrefHeight(235);
        for(int i = 0; i < 4; i++){
            player2CardsPane.add(playerCardsImage[1][i], i%2, i/2);
            player4CardsPane.add(playerCardsImage[3][i], i%2, i/2);
        }

        poolCardsPane = new GridPane();
        poolCardsPane.setVgap(3);
        poolCardsPane.setHgap(3);

        Text[] playerText = new Text[4];
        Text[] playerScoreText = new Text[4];
        Button[] playerCaptureButton = new Button[4];
        for(int i = 0; i < 4; i++){
            playerText[i] = new Text("Player " + (i+1));
            playerScoreText[i] = new Text("Score: 0.0");
            playerCaptureButton[i] = new Button("Capture");

            playerText[i].setFill(Color.WHITE);
            playerText[i].setStyle("-fx-font: 22 arial");
            playerScoreText[i].setFill(Color.WHITE);
            playerScoreText[i].setStyle("-fx-font: 15 arial");


        }

        VBox player2Pane = new VBox(10), player4Pane = new VBox(10);
        player2Pane.getChildren().addAll(playerText[1], playerScoreText[1], player2CardsPane, playerCaptureButton[1]);
        player4Pane.getChildren().addAll(playerText[3], playerScoreText[3], player4CardsPane, playerCaptureButton[3]);

        HBox player1Pane = new HBox(10), player3Pane = new HBox(10);
        VBox player1TextPane = new VBox(10), player3TextPane = new VBox(10);
        player1TextPane.getChildren().addAll(playerText[0], playerScoreText[0]);
        player3TextPane.getChildren().addAll(playerText[2], playerScoreText[2]);
        player1Pane.getChildren().addAll(player1TextPane, player1CardsPane, playerCaptureButton[0]);
        player3Pane.getChildren().addAll(player3TextPane, player3CardsPane, playerCaptureButton[2]);

        Pane[] playerPane = new Pane[4];
        playerPane[0] = player1Pane;
        playerPane[1] = player2Pane;
        playerPane[2] = player3Pane;
        playerPane[3] = player4Pane;

        BorderPane mainPane = new BorderPane();
        mainPane.setStyle("-fx-background-color: green");
        mainPane.setPadding(new Insets(23));
        mainPane.setBottom(player1Pane);
        mainPane.setLeft(player2Pane);
        mainPane.setTop(player3Pane);
        mainPane.setRight(player4Pane);
        mainPane.setCenter(poolCardsPane);
        mainPane.setPrefSize(1000, 700);
        BorderPane.setAlignment(poolCardsPane, Pos.CENTER);
        player1Pane.setAlignment(Pos.CENTER);
        player3Pane.setAlignment(Pos.CENTER);
        poolCardsPane.setAlignment(Pos.CENTER);
        for(int i = 0; i < 4; i++){
            BorderPane.setAlignment(playerPane[i], Pos.CENTER);
            playerPane[i].setVisible(false);
        }

        VBox capturesBoard = new VBox(20);
        Text captureBoardTitle = new Text("Capturing Status"), captureStatus = new Text("No Capture");
        captureBoardTitle.setFill(Color.WHITE);
        captureBoardTitle.setStyle("-fx-font: 25 arial");
        captureStatus.setStyle("-fx-font: 25 arial; -fx-fill: #ea8f79;");
        capturesBoard.setAlignment(Pos.TOP_CENTER);
        capturesBoard.getChildren().addAll(captureBoardTitle, captureStatus);
        capturesBoard.setPadding(new Insets(20));
        capturesBoard.setPrefWidth(250);
        capturesBoard.setStyle("-fx-padding: 10; -fx-background-color: green;" +
                      "-fx-border-style: solid inside;" +
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 35;" +
                      "-fx-border-radius: 5;" +
                      "-fx-border-color: white;");

        VBox[] playerCaptures = new VBox[4];
        for(int i = 0; i < 4; i++){
            playerCaptures[i] = new VBox(5);
            capturesBoard.getChildren().add(playerCaptures[i]);
        }


        HBox mainWrapper = new HBox();
        mainWrapper.getChildren().addAll(mainPane, capturesBoard);
}

    public void updateDisplay(){
      
    }
}

