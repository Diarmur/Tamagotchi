package com.ynov.tamagochi;

public class Tamagochi {
    int happiness = 15;
    int age = 0;
    String StagesOfLife = "egg";
    int hunger = 0; 
    boolean allReadyEat = false;
    boolean dirty = false; 


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



    
}
