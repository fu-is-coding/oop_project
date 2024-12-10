package com.example.src;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class CardPane extends StackPane{
    private Player currentPlayer;
    private Card card;
    private Text iv;
    private boolean selected = false;
    private boolean active = true;

    public CardPane(int width){
        iv = new Text();
        // iv.setFitWidth(width);
        // iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);  

        setMargin(iv, new Insets(3));
        getChildren().add(iv);
    }

    public void setCard(Card card){
        this.card = card;
        selected = false;
        setStyle("-fx-background-color: none");

        if(card == null){
            iv.setText("");
            setOnMouseClicked(null);
        }
        else{
            iv.setText(card.getImage());
            currentPlayer = new Player();

            setOnMouseClicked(e ->{
                // dont do anything if not active
                if(!active)
                    return;
                selected = !selected;
                if(!selected){
                    setStyle("-fx-background-color: red");
                    currentPlayer.addChoosenCard(card);
                }
                else{
                    setStyle("-fx-background-color: none");
                    currentPlayer.removeChoosenCard(card);
                }

                
            });
        }
    }

    public void setCurrentPlayer(Player player){
        currentPlayer = player;
    }

    @SuppressWarnings("static-access")
    public void setActive(boolean active){
        this.active = active;

        if(card == null)
            return;

        if(!active)
            iv.setText("Hidden");
        else
            iv.setText(card.getRank() + card.getSuit());
    }
}
