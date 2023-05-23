package com.ynov.tamagotchi;

public class Tamagotchi {
    String name;
    int happiness = 15;
    int age = 0;
    String StagesOfLife = "egg";
    int hunger = 0; 
    boolean allReadyEat = false;
    boolean dirty = false; 
    int eatStrike = 0;

    Tamagotchi(String name) {
        this.name = name;
    }

    // pour chaque uniter de temps passer
    void update(){
    if(this.allReadyEat == true){
        this.allReadyEat = false;
        this.dirty = true;
        this.hunger = 0;
    }else{
        this.hunger ++;
        this.happiness -= this.hunger *5;
        }
    if(this.dirty == true){
        this.happiness -=3;
    }
    }


    void changeStage() {
        if (this.StagesOfLife.equals("egg") && this.age >= 1) {
            this.StagesOfLife = "babe";
            this.age = 0;
        }
        if (this.StagesOfLife.equals("babe") && this.eatStrike >= 4 && this.happiness >= 40) {
            this.StagesOfLife = "adult";
            this.age = 0;
        }
        if (this.StagesOfLife.equals("adult") && age >= 15) {
            this.StagesOfLife = "elder";
            this.age = 0;
        }
        if (this.StagesOfLife.equals("elder") && age >= 5) {
            this.StagesOfLife = "dead";
            this.age = 0;
        }
    }
}
