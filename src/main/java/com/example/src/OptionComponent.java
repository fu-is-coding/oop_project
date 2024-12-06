package com.example.src;

import javafx.scene.control.Button;

public class OptionComponent {
    Button[] playerSelectionButton = new Button[3];

    public OptionComponent(){
        for(int i = 0; i < playerSelectionButton.length; i++){
            playerSelectionButton[i] = new Button(i+2+"");
        // mainMenuSelection.getChildren().add(playerSelectionButton[i]);
        }
    }

}
