package com.ynov.tamagochi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public int printMenu() {
        System.out.println("que voulez vous faire ?");
        System.out.println("1 : jouer");
        System.out.println("2 : nourrir");
        System.out.println("3 : nettoyer");
        System.out.println("4 : soigner");
        System.out.println("0 : quitter");
        return promptRangeNbr("veuillez faire un choix : ", 0, 4);
    }

    public String prompt(String question) {
        System.out.print(question + " ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        try {
            String answer = buffer.readLine();
            if (answer.equals("")) {
                System.err.println("recommencez ...");
                return prompt(question);
            }
            return answer;
        } catch (IOException e) {
            System.err.println("recommencez ...");
            return prompt(question);
        }
    }

    public int promptNbr(String question) {
        String answer = prompt(question);
        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            System.err.println("recommence avec un nbr ...");
            return promptNbr(question);
        }
    }

    public int promptRangeNbr(String question, int min, int max) {
        int answer = promptNbr(question);
        if (answer < min || answer > max) {
            System.out.println("entre " + min + " et " + max);
            return promptRangeNbr(question, min, max);
        }
        return answer;
    }

    public void test() {
        int choice = -1;
        do {
            choice = printMenu();
            switch (choice) {
                case 1:

                case 2:

                case 3:

                case 4:

            }
        } while (choice != 0);
        System.out.println("bye bye");
    }
}
