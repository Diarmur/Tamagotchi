package com.ynov.tamagochi;

public class Tamagotchi {
    public String name;
    public int happiness = 15;
    public int age = 0;
    public String stageOfLife = "elder";

    public int hunger = 100; // en pourcent
    public boolean eat = false;
    public int eatStrike = 0;

    public boolean sick = false;

    public boolean isClean = true;

    public Tamagotchi(String name) {
        this.name = name;
    }

    // pour chaque uniter de temps passer
    void update() {

    }

    void changeStage() {
        if (this.stageOfLife.equals("egg") && this.age >= 1) {
            this.stageOfLife = "babe";
            this.age = 0;
        }
        if (this.stageOfLife.equals("babe") && this.eatStrike >= 4 && this.happiness >= 40) {
            this.stageOfLife = "adult";
            this.age = 0;
        }
        if (this.stageOfLife.equals("adult") && age >= 15) {
            this.stageOfLife = "elder";
            this.age = 0;
        }
        if (this.stageOfLife.equals("elder") && age >= 5) {
            this.stageOfLife = "dead";
            this.age = 0;
        }
    }
}
