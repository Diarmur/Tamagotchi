package com.ynov.tamagochi;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.ynov.time.Time;

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

    public static Date read(Tamagotchi tamagotchi) {
        try {
            File file = new File("project-tamagotchi/src/main/java/com/ynov/tamagochi/Tamagotchi.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            String tempDate = " ";
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                tamagotchi.name = tempArr[0];
                tamagotchi.happiness = Integer.parseInt(tempArr[1]);
                tamagotchi.age = Integer.parseInt(tempArr[2]);
                tamagotchi.stageOfLife = tempArr[3];
                tamagotchi.hasEaten = Boolean.valueOf(tempArr[4]).booleanValue();
                tamagotchi.eatStrike = Integer.parseInt(tempArr[5]);
                tamagotchi.sick = Boolean.valueOf(tempArr[6]).booleanValue();
                tamagotchi.isClean = Boolean.valueOf(tempArr[7]).booleanValue();
                tempDate = tempArr[8];
            }
            br.close();
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            try {
                return formatter.parse(tempDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException ioe) {
            System.out.println("pas de fichier");
        }
        return new Date();
    }
}
