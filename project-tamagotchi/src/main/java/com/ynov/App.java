package com.ynov;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.ynov.tamagochi.Heal;
import com.ynov.tamagochi.Menu;
import com.ynov.tamagochi.Save;
import com.ynov.tamagochi.Tamagotchi;
import com.ynov.time.Time;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Tamagotchi tama = new Tamagotchi("egg");
        // Save.save(tama);
        // Save.read(tama);
        System.out.println(tama.name);
        Menu menu = new Menu(tama);
        menu.timeThread();
        menu.tameScene();

    }

    public static void main(String[] args) {
        launch();

    }

}