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
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Tamagotchi tama = new Tamagotchi("test");

        Save.save(tama);

        // Menu menu = new Menu(tama);
        // menu.test();

        // Heal heal = new Heal(tama);
        // heal.Sick();
        // tama.age++;
        // System.out.println(tama.sick);
        // heal.HealTamagotchi();
        // heal.DeathBySick();
        // System.out.println(tama.StagesOfLife);

        // Time timer = new Time();
        // System.out.println(timer.elapsedTime());

    }

}