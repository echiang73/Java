package Poker;

import java.util.*;

public class Poker {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String playerInput;

    public void startGame() {
        System.out.println("\nWelcome to the Java Poker Table");

        playerInput = promptUserInput();

        while(true) {
            if ("P".equals(playerInput)) {
                // pokerGame();
                playerInput = promptUserInput();
            } else if ("Q".equals(playerInput)) {
                // printWinPercentageMessage();
                System.out.println("Thanks for playing Java Poker, goodbye!");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid entry, enter P or Q");
                playerInput = scanner.nextLine().toUpperCase();
            }

        }
    }

    private String promptUserInput() {
        System.out.println("Please select an option.");
        System.out.println("P -> Play\nQ -> Quit");
        return scanner.nextLine().toUpperCase();
    }

}