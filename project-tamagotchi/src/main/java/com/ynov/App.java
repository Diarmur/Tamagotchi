package com.ynov;

import com.ynov.tamagochi.Heal;
import com.ynov.tamagochi.Menu;
import com.ynov.tamagochi.Save;
import com.ynov.tamagochi.Tamagotchi;
import com.ynov.time.Time;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Tamagotchi tama = new Tamagotchi("test");
        Menu menu = new Menu(tama);
        //menu.time.timeScene(menu);
        menu.timeThread();
        menu.tameScene();
    }



    public static void main(String[] args) {
        launch();
        
        

    }

}