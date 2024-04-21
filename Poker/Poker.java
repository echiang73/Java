package Poker;

import java.util.*;

public class Poker {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int playerTotal = 0;
    int opponent1Total = 0;
    int opponent2Total = 0;
    int opponent3Total = 0;
    List<Card> deck;
    List<Card> playerHand = new ArrayList<>();
    List<Card> opponent1Hand = new ArrayList<>();
    List<Card> opponent2Hand = new ArrayList<>();
    List<Card> opponent3Hand = new ArrayList<>();
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
        System.out.println("Before we start, would you like to put on Spy Vision sunglasses to see deck cards and opponents' cards?");
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
        opponent1Total = 0;
        opponent2Total = 0;
        opponent3Total = 0;
        playerHand.clear();
        opponent1Hand.clear();
        opponent2Hand.clear();
        opponent3Hand.clear();
        
        dealTwoCardsEach();
    }

    private List<Card> getNewDeck() {
        List<Card> newDeck = Card.getDoubleDeck();
        Collections.shuffle(newDeck);
        if (spyVisionOn) {
            Card.printDeck(newDeck);
        }
        return newDeck;
    }

    private void dealTwoCardsEach() {
        playerHand.add(getCard());
        opponent1Hand.add(getCard());
        opponent2Hand.add(getCard());
        opponent3Hand.add(getCard());
        playerHand.add(getCard());
        opponent1Hand.add(getCard());
        opponent2Hand.add(getCard());
        opponent3Hand.add(getCard());

        playerTotal = assessHandTotal(playerHand);
        opponent1Total = assessHandTotal(opponent1Hand);
        opponent2Total = assessHandTotal(opponent1Hand);
        opponent3Total = assessHandTotal(opponent1Hand);
        printInitialHands();
    }

    private Card getCard() {
        return cards.next();
    }

    private int assessHandTotal(List<Card> hand) {
        int handValue = 0;
        int numOfA = 0;
        
        for (Card card : hand) {
            // add all non-A values first, but keep count of A's
            try {
                handValue += Integer.parseInt(card.face());
            } catch (NumberFormatException e) {
                switch (card.face()) {
                    case "J": 
                        case "Q": case "K": handValue += 10;
                        break;
                    case "A": 
                        numOfA++;
                }
            }
        }

        // now calculate different combo of total value with A's
        if (numOfA > 0) {
            return calculateAces(numOfA, handValue);
        }
        return handValue;
    }

    private int calculateAces(int numOfA, int handValue) {
        switch(numOfA) {
            case 1: 
                handValue += (handValue + 11 < 22) ? 11 : 1;
                break;
            case 2: 
                handValue += (handValue + 12 < 22) ? 12 : 2;
                break;
            case 3: 
                handValue += (handValue + 13 < 22) ? 13 : 3;
                break;
            case 4: 
                handValue += (handValue + 14 < 22) ? 14 : 4;
                break;
        }
        return handValue;
    }

    private void printInitialHands() {
        System.out.println("Player hand: " + playerHand);
        if (spyVisionOn) {
            System.out.println("Opponent1 hand: [" + opponent1Hand.get(0) + ", " + opponent1Hand.get(1) + "]"); 
            System.out.println("Opponent2 hand: [" + opponent2Hand.get(0) + ", " + opponent2Hand.get(1) + "]"); 
            System.out.println("Opponent3 hand: [" + opponent3Hand.get(0) + ", " + opponent3Hand.get(1) + "]"); 
        }
 
    }

    private int getCardValue(Card card) {
        return card.face().equals("A") ? 11 : ((Arrays.asList("K", "Q", "J")).contains(card.face()) ? 10 : Integer.parseInt(card.face()));
    }

}