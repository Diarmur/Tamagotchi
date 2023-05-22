package com.ynov.tamagochi;

public class Tamagochi {
    String name;
    int happiness = 15;
    int age = 0;
    String StagesOfLife = "egg";
    int hunger = 100; // en pourcent
    boolean eat = false;
    int eatStrike = 0;

    Tamagochi(String name) {
        this.name = name;
    }

    // pour chaque uniter de temps passer
    void update() {

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
