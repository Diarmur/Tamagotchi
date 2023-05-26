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

    public Time(Tamagotchi tamagotchi, Meal meal, Clean clean, Heal heal) {
        this.tamagotchi = tamagotchi;
        this.meal = meal;
        this.clean = clean;
        this.heal = heal;
    }

    private int getTime(Date date) {
        return (int) date.getTime() / 1000;
    }

    private boolean elapsedTime() {

        Date nowDate = new Date();
        if (this.getTime(nowDate) - this.getTime(this.dateInit) > this.second) {
            this.second = (this.getTime(nowDate) - this.getTime(this.dateInit));
            if (second % 10 == 0) {
                this.timeUnit++;
                this.tamagotchi.age++;
                return true;
            }
        }

        return false;
    }

    public void newDay() {
        elapsedTime();
        System.out.println(this.second);
        if (this.elapsedTime()) {
            this.tamagotchi.changeStage();
            if (!this.tamagotchi.hasEaten) {
                this.tamagotchi.dayWithoutEat++;
            }

            if (this.tamagotchi.dayWithoutEat > 0) {
                this.meal.needEat();
            }
            this.clean.Dirty();
            this.heal.Sick();

            if (this.tamagotchi.hasEaten) {
                this.tamagotchi.isClean = false;
            }
            this.tamagotchi.hasEaten = false;
        }
    }
}
