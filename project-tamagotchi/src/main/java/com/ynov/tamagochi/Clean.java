package com.ynov.tamagochi;

public class Clean {
    Tamagotchi tamagotchi;

    public Clean(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public void CleanRoom() {
        if (this.tamagotchi.isClean == false) {
            this.tamagotchi.isClean = true;
        }
    }

    public void Dirty() {
        if (this.tamagotchi.isClean == false) {
            this.tamagotchi.happiness -= 3;
        }
    }
}
