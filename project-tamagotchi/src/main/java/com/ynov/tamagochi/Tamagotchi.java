package com.ynov.tamagochi;

import java.util.ArrayList;

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
    public ArrayList<String> ListImage = new ArrayList<String>() ;
    public ArrayList<String> ListName = new ArrayList<String>() ;
    public String imageURL = "img/egg.png";
    

    public Tamagotchi(String name) {
        this.name = name;
        setListImage();

    }

    private void setListImage() {
        int n = (int)(Math.random() * 3);
        ListImage.add("img/egg.png");
        switch(n){
            case 0: 
                ListImage.add("img/carapuce.png");
                ListImage.add("img/carabaffe.png");
                ListImage.add("img/tortank.png");
                ListName.add("Carapuce");
                ListName.add("Carabaffe");
                ListName.add("Tortank");
            break;
            case 1:
                ListImage.add("img/salameche.png");
                ListImage.add("img/reptincel.png");
                ListImage.add("img/dracaufeu.png");
                ListName.add("Salameche");
                ListName.add("Reptincel");
                ListName.add("Dracaufeu");
            break;
            case 2:
                ListImage.add("img/bulbizarre.png");
                ListImage.add("img/herbizarre.png");
                ListImage.add("img/florizarre.png");
                ListName.add("Bullbizarre");
                ListName.add("Herbizarre");
                ListName.add("Florizarre");
                break;
        }
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
            this.imageURL = ListImage.get(1);
            this.name = ListName.get(0);
            this.age = 0;
        }
        if (this.stageOfLife.equals("babe") && this.eatStrike >= 4 && this.happiness >= 40) {
            this.stageOfLife = "adult";
            this.imageURL = ListImage.get(2);
            this.name = ListName.get(1);
            this.age = 0;
        }
        if (this.stageOfLife.equals("adult") && age >= 15) {
            this.stageOfLife = "elder";
            this.imageURL = ListImage.get(3);
            this.name = ListName.get(2);
            
            this.age = 0;
        }
        if (this.stageOfLife.equals("elder") && age >= 5) {
            this.stageOfLife = "dead";
            this.age = 0;
        }
    }
}
