package com.ynov.tamagochi;

public class Tamagotchi {
    boolean allReadyEat = false;
    boolean dirty = false; 
    public String name;
    public int happiness = 15;
    public int age = 0;
    public String stageOfLife = "egg";

    public int eatStrike = 0;
    public int dayWithoutEat = 0;
    public boolean hasEaten = true;

    public boolean sick = false;
    public int playSick = 0;

    public boolean isClean = true;
    public String imageURL = "img/egg.png";

    public Tamagotchi(String name) {
        this.name = name;
    }

    // pour chaque uniter de temps passer
    public void update(){
        changeStage();
        this.playSick = 0;
        Clean.Dirty(this);;
    }

    public void changeStage() {
        if (this.stageOfLife.equals("egg") && this.age >= 1) {
            this.stageOfLife = "babe";
            this.imageURL ="img/carapuce.png";
            this.age = 0;
        }
        if (this.stageOfLife.equals("babe") && this.eatStrike >= 4 && this.happiness >= 40) {
            this.stageOfLife = "adult";
            this.imageURL ="img/carabaffe.png";
            this.age = 0;
        }
        if (this.stageOfLife.equals("adult") && age >= 15) {
            this.stageOfLife = "elder";
            this.imageURL ="img/tortank.png";
            this.age = 0;
        }
        if (this.stageOfLife.equals("elder") && age >= 5) {
            this.stageOfLife = "dead";
            this.age = 0;
        }
    }
}
