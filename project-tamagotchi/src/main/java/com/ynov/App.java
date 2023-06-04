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
        Tamagotchi tama = new Tamagotchi("test");
        Menu menu = new Menu(tama);
        //menu.time.timeScene(menu);
        menu.timeThread();
        menu.tameScene();


    // public void start(Stage stage) throws MalformedURLException {
    //     final URL imageURL = getClass().getResource("img/egg.png");  
    //     final Image image = new Image(imageURL.toExternalForm());
    //     final ImageView imageView = new ImageView(image); 
    //     final Pane root = new Pane(); 
    //     root.getChildren().setAll(imageView); 


    //     var javaVersion = SystemInfo.javaVersion();
    //     var javafxVersion = SystemInfo.javafxVersion();
    //     final Scene scene = new Scene(root, 700, 700); 
    //     var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    //     //var scene = new Scene(new StackPane(label), 640, 480);
    //     stage.setScene(scene);
    //     stage.show();
    // }



    public static void main(String[] args) {
        launch();
        
        

    }

}