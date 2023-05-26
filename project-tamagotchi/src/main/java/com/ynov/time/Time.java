package com.ynov.time;

import java.util.Date;

import com.ynov.tamagochi.Meal;
import com.ynov.tamagochi.Clean;
import com.ynov.tamagochi.Heal;
import com.ynov.tamagochi.Tamagotchi;


public class Time {
    
    Tamagotchi tamagotchi;
    Meal meal;
    Clean clean;
    Heal heal;
    private Date dateInit = new Date();
    public int timeUnit = 0;
    private int second = 0;

    public Time(Tamagotchi tamagotchi,Meal meal,Clean clean,Heal heal){
        this.tamagotchi = tamagotchi;
        this.meal = meal;
        this.clean = clean;
        this.heal = heal;
    }
    

    private int getTime(Date date) {
        return (int)date.getTime()/1000;
    }

    private boolean elapsedTime(){
        
        Date nowDate = new Date();
        if(this.getTime(nowDate)-this.getTime(this.dateInit)>this.second){
            this.second++;
            if (second%10==0) {
                this.timeUnit++;
                tamagotchi.age++;          
                return true;
            }
        }
        
        
        return false;
    }

    public void newDay(){   
        if (this.elapsedTime()) {
            if(!tamagotchi.hasEaten){
                tamagotchi.dayWithoutEat++;
            }

            if (tamagotchi.dayWithoutEat>0) {
                meal.needEat();
            }
            Clean.Dirty(this.tamagotchi);
            heal.Sick();
            
            if (tamagotchi.hasEaten) {
                tamagotchi.isClean = false;
            }
            tamagotchi.hasEaten = false;
        }
    }
}
