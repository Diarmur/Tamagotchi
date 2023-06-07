package com.ynov.tamagochi;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Clean {

    static int cleanCount;
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

    public static void SceneClean(Tamagotchi tamagotchi,Menu menu){

        
        String cssPath = tamagotchi.getClass().getResource("/app.css").toString();
        Stage cleanStage = new Stage();
        cleanStage.setWidth(640);
        cleanStage.setHeight(480);

        Image image  = new Image(tamagotchi.getClass().getResource(tamagotchi.imageURL).toExternalForm());
        ImageView imageView = new ImageView(image);

        final Pane tamagotchiImg = new Pane(); 
        tamagotchiImg.getChildren().setAll(imageView);

        HBox pokeBox = new HBox(0, tamagotchiImg);
        pokeBox.relocate(210, 170);

        Pane bg = new Pane();
        bg.getStyleClass().add("imgClean");
        bg.getChildren().addAll(pokeBox);

        
        
        Scene scene = new Scene(bg, 640, 480);
        cleanStage.setScene(scene);
        cleanStage.show();
        scene.getStylesheets().add(cssPath);
        
        tamagotchiImg.setOnMouseClicked(e->{
            cleanCount++;
            if (cleanCount>=3) {
                Clean.CleanRoom(tamagotchi);
                cleanStage.close();
                cleanCount = 0;
                menu.updateStat();
            }
            
        });
    }
}
