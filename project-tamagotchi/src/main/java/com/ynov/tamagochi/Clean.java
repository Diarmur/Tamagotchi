package com.ynov.tamagochi;

import javafx.stage.Stage;

public class Clean {
    Tamagotchi tamagotchi;

    public Clean(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public static void CleanRoom(Tamagotchi tamagotchi) {
        if (tamagotchi.isClean == false) {
            tamagotchi.isClean = true;
        }
    }

    public static void Dirty(Tamagotchi tamagotchi) {
        if (tamagotchi.isClean == false) {
            tamagotchi.happiness -= 3;
        }
    }

    public static void SceneClean(Tamagotchi tamagotchi){
        Stage cleanStage = new Stage();
        cleanStage.setWidth(640);
        cleanStage.setHeight(480);
        
        cleanStage.show();
        Clean.CleanRoom(tamagotchi);
    }
}
