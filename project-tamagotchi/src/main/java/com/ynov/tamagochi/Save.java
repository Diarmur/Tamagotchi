package com.ynov.tamagochi;

import java.io.*;
import java.util.*;

public class Save {
    // Délimiteurs qui doivent être dans le fichier CSV
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";

    // En-tête de fichier
    private static final String HEADER = "Title,Author,Year";

    public static void save(Tamagotchi tamagotchi) {
        FileWriter file = null;

        try {

            // name,hapiness,age,stageOfLife,hunger,eat,eatStrike,sick,isClean,save date
            file = new FileWriter("project-tamagotchi/src/main/java/com/ynov/tamagochi/Tamagotchi.csv");

            file.append(tamagotchi.name);
            file.append(DELIMITER);
            file.append(Integer.toString(tamagotchi.happiness));
            file.append(DELIMITER);
            file.append(Integer.toString(tamagotchi.age));
            file.append(DELIMITER);
            file.append(tamagotchi.stageOfLife);
            file.append(DELIMITER);
            file.append(String.valueOf(tamagotchi.hasEaten));
            file.append(DELIMITER);
            file.append(Integer.toString(tamagotchi.eatStrike));
            file.append(DELIMITER);
            file.append(String.valueOf(tamagotchi.sick));
            file.append(DELIMITER);
            file.append(String.valueOf(tamagotchi.isClean));
            file.append(DELIMITER);
            file.append(String.valueOf(new Date()));
            file.append(SEPARATOR);

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
