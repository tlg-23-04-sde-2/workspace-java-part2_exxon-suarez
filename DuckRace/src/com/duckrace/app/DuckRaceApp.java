package com.duckrace.app;


/*
 * Application CONTROLLER
 * Sets up system classes, orchastrates overal flow of the application
 * Prompts user for inputs and forwards thos einputs to the system ( backend)
 */


import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

public class DuckRaceApp {
    private final Scanner scanner = new Scanner(System.in);     // read inputs from console
    private Board board = new Board();
    private int totalRacers = board.getRacersSize();

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        upDateBoard(id,reward);
        showBoard();

    }

    private void upDateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private int promptForId() {
        int id = 0;
        boolean validInput = false;     // assign validInput as false
        while(!validInput) {            // assume not valid input
            System.out.print("Please enter the ID of the winner [ 1 - " + totalRacers + " ]: ");      // todo: dont hardcode 13
            String input = scanner.nextLine().trim();
            if(input.matches("\\d{1,2}")) {            // any digits 1 or 2 occurences
             id = Integer.parseInt(input);                   // safe to convert to int at this point
             if (id >= 1 && id <= totalRacers) {                     // TODO: dont hardcade the 13
                 validInput = true;
             }
            }
        }

        return id;
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if(input.matches("D|P")) {
                validInput = true;
                if("D".equals(input)) {             // or use ternary here
                    reward = Reward.DEBIT_CARD;
                } else {
                    reward = Reward.PRIZES;
                }

            }
        }
        return reward;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("********* Welcome to the duck race application ************ ");
    }
}