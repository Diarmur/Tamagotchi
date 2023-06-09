package com.ynov.time;

import java.util.Date;

import com.ynov.tamagochi.Meal;
import com.ynov.tamagochi.Menu;
import com.ynov.tamagochi.Clean;
import com.ynov.tamagochi.Heal;
import com.ynov.tamagochi.Tamagotchi;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Time {

    Tamagotchi tamagotchi;
    Meal meal;
    Clean clean;
    Heal heal;
    int secondPerUnit = 15;// number off second for 1 time unit
    private Date dateInit ;
    public int timeUnit = 0;
    private int second = 0;


    public Time(Tamagotchi tamagotchi, Meal meal, Clean clean, Heal heal, Date dateSave) {
        this.tamagotchi = tamagotchi;
        this.meal = meal;
        this.clean = clean;
        this.heal = heal;
        this.dateInit = dateSave;
    }

    public void timeScene(Menu menu){
        Stage stage = new Stage();
        Label label = new Label("Hello, JavaFX "+this.second);
        //var scene = new Scene(new StackPane(label), 640, 480);
        Button button = new Button("Click Me");

        

        HBox hbox = new HBox(20,button);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20,label,hbox);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 640, 480);
        button.setOnMouseClicked(e->{
            this.elapsedTime();
            label.setText(""+this.second);
        });
        stage.setScene(scene);
        stage.show();
    }



    private int getTime(Date date) {
        return (int) date.getTime() / 1000;
    }

    public int elapsedTime() {
        
        
        this.timeUnit = 0;
        Date nowDate = new Date();
        int secondBeetweenCall = this.getTime(nowDate) - this.getTime(this.dateInit);
        if (secondBeetweenCall != 0) {
           
        
            this.second += secondBeetweenCall;
            this.dateInit = new Date();
            if (this.second > 10) {
                this.timeUnit = this.second / this.secondPerUnit;
                this.second = 0;
                this.tamagotchi.age += this.timeUnit;

                this.tamagotchi.age++;
            }
        }
        return this.timeUnit;
    }

    public void newDay() {
        
        
        for (int i = 0; i < this.timeUnit; i++) {

            this.tamagotchi.changeStage();
            if (!this.tamagotchi.hasEaten) {
                this.tamagotchi.dayWithoutEat++;
            }

            tamagotchi.playSick = 0;

            if (this.tamagotchi.dayWithoutEat > 0) {
                this.meal.needEat();
            }
            Clean.Dirty(tamagotchi);
            this.heal.Sick();

            if (this.tamagotchi.hasEaten) {
                this.tamagotchi.isClean = false;
            }
            this.tamagotchi.hasEaten = false;

            if (this.tamagotchi.happiness <= 0) {
                this.tamagotchi.stageOfLife = "dead";
            }
        }
    }
}
