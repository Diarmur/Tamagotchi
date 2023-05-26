package com.ynov.tamagochi;

public class Heal {
    Tamagotchi tamagotchi;
    int ageSick;

    public Heal(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public void Sick() {
        if (this.tamagotchi.stageOfLife.equals("elder")) {
            int chanceOfSickness = (int) (Math.random() * 3);
            if (chanceOfSickness == 0) {
                this.tamagotchi.sick = true;
                this.ageSick = this.tamagotchi.age;
            }
        }
    }

    public void HealTamagotchi() {
        if (this.tamagotchi.sick && this.tamagotchi.age > this.ageSick) {
            this.tamagotchi.sick = false;
        }
    }

    public void DeathBySick() {
        if (this.tamagotchi.sick && this.tamagotchi.age > this.ageSick) {
            this.tamagotchi.stageOfLife = "dead";
        }
    }
}
