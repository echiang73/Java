package Poker;

import java.util.*;

public class Poker {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int playerTotal = 0;
    int dealerTotal = 0;
    List<Card> deck;
    List<Card> playerHand = new ArrayList<>();
    List<Card> dealerHand = new ArrayList<>();
    ListIterator<Card> cards;
    String playerInput;
    double winPercent = 0;
    boolean spyVisionOn;

    public void startGame() {
        System.out.println("\nWelcome to the Java Texas Hold'em Poker");

        checkSpyVision();

        playerInput = promptUserInput();

        while(true) {
            if ("P".equals(playerInput)) {
                pokerGame();
                playerInput = promptUserInput();
            } else if ("Q".equals(playerInput)) {
                printWinPercentageMessage();
                System.out.println("Thanks for playing Java Texas Hold'em Poker, goodbye!");
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

    private void printWinPercentageMessage() {
        if (winPercent > 70) {
            System.out.println("You are a professional hustler!");
        } else if (winPercent > 50) {
            System.out.println("Good idea to leave while you are ahead.");
        } else {
            System.out.println("Blackjack might not be your cup of tea.  Try slots.");
        }
    }

    private void checkSpyVision() {
        String spyVisionInput = promptIputForSpyVision();
        while(true) {
            if ("Y".equals(spyVisionInput)) {
                spyVisionOn = true;
                break;
            } else if ("N".equals(spyVisionInput)) {
                spyVisionOn = false;
                break;
            } else {
                System.out.println("Invalid entry, enter Y or N");
                spyVisionInput = scanner.nextLine().toUpperCase();
            }
        }
    }

    private String promptIputForSpyVision() {
        System.out.println("Before we start, would you like to put on Spy Vision sunglasses to see deck cards?");
        System.out.println("Y -> Yes\nN -> No");
        return scanner.nextLine().toUpperCase();
    }

    private void pokerGame() {
        initGame();

    }

    private void initGame() {
        deck = getNewDeck();
        cards = deck.listIterator();
        playerTotal = 0;
        dealerTotal = 0;
        playerHand.clear();
        dealerHand.clear();
        
        // dealCardsEach();
    }

    private List<Card> getNewDeck() {
        List<Card> newDeck = Card.getStandardDeck();
        Collections.shuffle(newDeck);
        if (spyVisionOn) {
            Card.printDeck(newDeck);
        }
        return newDeck;
    }

}