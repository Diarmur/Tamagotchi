package com.ynov.tamagochi;

public class Clean {
    Tamagotchi tamagotchi;

    public Clean(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public static void CleanRoom(Tamagotchi tamagotchi) {
        if (tamagotchi.isClean == false) {
            tamagotchi.isClean = true;
        }
    }

    public static void Dirty(Tamagotchi tamagotchi) {
        if (tamagotchi.isClean == false) {
            tamagotchi.happiness -= 3;
        }
    }
}
