package com.ynov.tamagochi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ynov.time.Time;

public class Menu {
    Tamagotchi tamagotchi;
    Clean clean;
    Heal heal;
    Meal meal;
    Time time = new Time(tamagotchi, meal, clean, heal);


    public Menu(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
        this.heal = new Heal(this.tamagotchi);
    }

    public int printMenu() {
        System.out.println("what do you want to do ?");
        System.out.println("1 : play");
        System.out.println("2 : eat");
        System.out.println("3 : clean");
        System.out.println("4 : heal");
        System.out.println("5 : view the status");
        System.out.println("0 : quitter");
        return promptRangeNbr("choose : ", 0, 5);
    }

    public String prompt(String question) {
        System.out.print(question + " ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        try {
            String answer = buffer.readLine();
            if (answer.equals("")) {
                System.err.println("retry ...");
                return prompt(question);
            }
            return answer;
        } catch (IOException e) {
            System.err.println("retry ...");
            return prompt(question);
        }
    }

    public int promptNbr(String question) {
        String answer = prompt(question);
        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            System.err.println("retry with number ...");
            return promptNbr(question);
        }
    }

    public int promptRangeNbr(String question, int min, int max) {
        int answer = promptNbr(question);
        if (answer < min || answer > max) {
            System.out.println("between " + min + " and " + max);
            return promptRangeNbr(question, min, max);
        }
        return answer;
    }

    public void test() {
        System.out.println(tamagotchi.sick);
        int choice = -1;
        do {
            time.newDay();
            choice = printMenu();
            switch (choice) {
                case 1:
                Play.PlayTamagotchi(this.tamagotchi);
                    break;
                case 2:
                    break;
                case 3:
                    Clean.CleanRoom(this.tamagotchi);
                    break;
                case 4:
                    heal.HealTamagotchi();
                    break;
                case 5:
                    TamagotchiStatus();
                    break;
            }
            
        } while (choice != 0);
        System.out.println("bye bye");
    }

    public void TamagotchiStatus() {
        System.out.println();
        System.out.println("Tamagotchi : " + tamagotchi.name);
        System.out.println();
        System.out.println("status : " + tamagotchi.StagesOfLife);
        //System.out.println("hungry : " + tamagotchi.hunger);
        System.out.println("hapiness : " + tamagotchi.happiness);
        if (tamagotchi.isClean) {
            System.out.println(tamagotchi.name + " is clean");
        } else {
            System.out.println(tamagotchi.name + " is dirty");
        }
        if (tamagotchi.sick) {
            System.out.println(tamagotchi.name + " is sick");
        } else {
            System.out.println(tamagotchi.name + " is healthy");
        }

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        try {
            buffer.readLine();
        } catch (IOException e) {

        }
    }
}
