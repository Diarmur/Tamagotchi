package com.ynov.tamagochi;

public class Tamagotchi {
    boolean allReadyEat = false;
    boolean dirty = false; 
    public String name;
    public int happiness = 15;
    public int age = 0;
    public String StagesOfLife = "elder";

    public int NBDaysWithoutEating = 100; 
    public boolean eat = false;
    public int eatStrike = 0;
    public boolean sick = false;
    public int playSick = 0;

    public boolean isClean = true;

    public Tamagotchi(String name) {
        this.name = name;
    }

    // pour chaque uniter de temps passer
    public void update(){
        changeStage();
        this.playSick = 0;
        Clean.Dirty(this);;
    }


    private void changeStage() {
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
