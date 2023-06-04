package com.ynov.tamagochi;

public class Play {

    public static void PlayTamagotchi(Tamagotchi tamagotchi) {
        if (tamagotchi.playSick < 3) {
            tamagotchi.happiness += 3;
            tamagotchi.playSick += 1;
        }
    }
}
