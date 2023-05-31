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
    int secondPerUnit = 5;// number off second for 1 time unit
    private Date dateInit = new Date();
    public int timeUnit = 0;
    private int second = 0;

    public Time(Tamagotchi tamagotchi, Meal meal, Clean clean, Heal heal) {
        this.tamagotchi = tamagotchi;
        this.meal = meal;
        this.clean = clean;
        this.heal = heal;
    }

    private int getTime(Date date) {
        return (int) date.getTime() / 1000;
    }

    private int elapsedTime() {
        this.timeUnit = 0;
        Date nowDate = new Date();
        int secondBeetweenCall = this.getTime(nowDate) - this.getTime(this.dateInit);

        this.second += secondBeetweenCall;
        this.dateInit = new Date();
        if (this.second > 10) {

            this.timeUnit = this.second / this.secondPerUnit;
            this.second = 0;
            this.tamagotchi.age += this.timeUnit;

            this.tamagotchi.age++;
        }
        return this.timeUnit;
    }

    public void newDay() {
        elapsedTime();

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
