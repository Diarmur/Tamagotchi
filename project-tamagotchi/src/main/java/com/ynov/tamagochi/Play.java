package com.ynov.tamagochi;

import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Play {

    public static void PlayTamagotchi(Tamagotchi tamagotchi) {
        if (tamagotchi.playSick < 3) {
            tamagotchi.happiness += 3;
            tamagotchi.playSick += 1;
        }
    }

    public static void ScenePlay(Tamagotchi tamagotchi){
        if (!tamagotchi.stageOfLife.equals("egg")) {
            
            String cssPath = tamagotchi.getClass().getResource("/app.css").toString();
            Image image  = new Image(tamagotchi.getClass().getResource(tamagotchi.imageURL).toExternalForm());
            //Image imageBall  = new Image(tamagotchi.getClass().getResource("/pokeball.png").toExternalForm());
            ImageView imageView = new ImageView(image);
            //ImageView imageViewBall = new ImageView(imageBall);
            Stage playStage = new Stage();
            playStage.setWidth(640);
            playStage.setHeight(480);

            final Pane tamagotchiImg = new Pane(); 
            tamagotchiImg.getChildren().setAll(imageView);

            //final Pane pokeball = new Pane(); 
            //tamagotchiImg.getChildren().setAll(imageViewBall);

            HBox pokeBox = new HBox(0, tamagotchiImg);
            //HBox pokeballBox = new HBox(0, pokeball);

            pokeBox.relocate(210, 170);
            

            Pane bg = new Pane();
            bg.getStyleClass().add("imgPlay");
            bg.getChildren().addAll(pokeBox);

            // tamagotchiImg.setOnMouseClicked(e->{
            //     System.out.println("hi");
            // });

            Scene scene = new Scene(bg, 640, 480);
            scene.getStylesheets().add(cssPath);
            playStage.setScene(scene);
            playStage.show();
            Play.PlayTamagotchi(tamagotchi);
            
        }
        
    }

    // private static int getRandomNumberInRange(int min, int max) {

	// 	if (min >= max) {
	// 		throw new IllegalArgumentException("max must be greater than min");
	// 	}

	// 	Random r = new Random();
	// 	return r.nextInt((max - min) + 1) + min;
	// }
}
