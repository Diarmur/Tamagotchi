package com.ynov;

import java.util.Date;

import com.ynov.tamagochi.Menu;
import com.ynov.tamagochi.Save;
import com.ynov.tamagochi.Tamagotchi;


import javafx.application.Application;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    static Tamagotchi tama = new Tamagotchi("egg");


    @Override
    public void start(Stage stage) {
        Date dateSave = Save.read(tama);
        if (tama.stageOfLife.equals("dead")) {
            tama = new Tamagotchi("egg");
            dateSave = new Date();
        }
        Menu menu = new Menu(tama,dateSave,"javafx");
       
        
        
        menu.timeThread();
        menu.tameScene();

    }

    public static void main(String[] args) {
        String playStyle = "terminal"; //to play in terminal replace "javafx" with "terminal"

        if (playStyle.equals("javafx")) {
            launch();
        }else if (playStyle.equals("terminal")) {
            Date dateSave = Save.read(tama);
            if (tama.stageOfLife.equals("dead")) {
                tama = new Tamagotchi("egg");
                dateSave = new Date();
            }
            Menu menu = new Menu(tama,dateSave,playStyle);
            menu.test();
        }
        

    }

    @Override
    public void stop(){
        System.out.println("Stage is closing");
        Save.save(tama);
    }

}