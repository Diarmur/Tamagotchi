package com.ynov.tamagochi;

public class Meal {
    Tamagotchi tamagotchi;

    Meal(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public void eat() {
        if (this.tamagotchi.eatStrike > 0 && !tamagotchi.hasEaten) {
            this.tamagotchi.eatStrike++;
            this.tamagotchi.hasEaten = true;
            this.tamagotchi.dayWithoutEat = 0;
        }
    }

    public void needEat() {
        int happinessLose = 0;
        if (this.tamagotchi.dayWithoutEat != 0) {
            for (int i = 0; i < this.tamagotchi.dayWithoutEat; i++) {
                happinessLose += happinessLose + 5;
            }
        }
        this.tamagotchi.happiness -= happinessLose;
    }
}
