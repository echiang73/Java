import java.util.*;

public class BlackJack {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int playerTotal = 0;
    int dealerTotal = 0;
    List<Card> deck;
    Card card;
    Card playerCard;
    Card dealerCard;
    List<Card> playerHand = new ArrayList<>();
    List<Card> dealerHand = new ArrayList<>();
    ListIterator<Card> cards;
    String playInput;
    boolean keepPlaying = true;
    int wins = 0;
    int gamesPlayed = 0;
    double winPercent = 0;
    boolean spyVisionOn;
    
    public void startGame() {
        System.out.println("Welcome to the Java Blackjack Table");

        checkSpyVision();

        playInput = promptUserInput();

        while(true) {
            if ("P".equals(playInput)) {
                blackJackGame();
                playInput = promptUserInput();
            } else if ("Q".equals(playInput)) {
                printWinPercentageMessage();
                System.out.println("Thanks for playing Java Blackjack, goodbye!");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid entry, enter P or Q");
                playInput = scanner.nextLine().toUpperCase();
            }

        }
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
                System.out.println("Invalid entry, enter P or Q");
                spyVisionInput = scanner.nextLine().toUpperCase();
            }
        }
    }

    private String promptIputForSpyVision() {
        System.out.println("Before we start, would you like to put on Spy Vision sunglasses to see deck cards?");
        System.out.println("Y -> Yes\nN -> No");
        return scanner.nextLine().toUpperCase();
    }
    
    private String promptUserInput() {
        System.out.println("Please select an option.");
        System.out.println("P -> Play\nQ -> Quit");
        return scanner.nextLine().toUpperCase();
    }
    
    private void blackJackGame() {
        initGame();

        while (true) {
            keepPlaying = evaluateBust();
            if (!keepPlaying) {
                printScore();
                break;
            }
            
            String decide = promptUserDecision();
            while (true) {
                if ("H".equals(decide)) {
                    playerHand.add(getCard());
                    playerTotal = assessHandTotal(playerHand);
                    System.out.println("Player hand: " + playerHand + ": total -> " + playerTotal);
                    break;
                } else if ("S".equals(decide)) {
                    checkWinner();
                    printScore();
                    break;
                } else {
                    System.out.println("Invalid entry, enter H or S");
                    decide = scanner.nextLine().toUpperCase();
                }
            }
            if (!keepPlaying) break;
        }
        System.out.println("-".repeat(43));
        System.out.println("Keep playing?");
        return;
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
    
    private void initGame() {
        deck = getNewDeck();
        cards = deck.listIterator();
        playerTotal = 0;
        dealerTotal = 0;
        playerHand.clear();
        dealerHand.clear();
        
        dealTwoCardsEach();
    }

    private List<Card> getNewDeck() {
        List<Card> newDeck = Card.getStandardDeck();
        Collections.shuffle(newDeck);
        if (spyVisionOn) {
            Card.printDeck(newDeck);
        }
        return newDeck;
    }

    private void dealTwoCardsEach() {
        playerHand.add(getCard());
        dealerHand.add(getCard());
        playerHand.add(getCard());
        dealerHand.add(getCard());

        playerTotal = assessHandTotal(playerHand);
        dealerTotal = assessHandTotal(dealerHand);
        System.out.println("line 181 playerTotal = " + playerTotal);
        printInitialHands();
    }

    private Card getCard() {
        return cards.next();
    }

    private int getCardValue(Card card) {
        // int cardValue = 0;
        // try {
        //     cardValue = Integer.parseInt(card.face());
        // } catch (NumberFormatException e) {
        //     switch (card.face()) {
        //         case "J", "Q", "K" -> cardValue = 10;
        //         case "A" -> cardValue = 11;
        //     }
        // }
        // return cardValue;
        return card.face().equals("A") ? 11 : ((Arrays.asList("K", "Q", "J")).contains(card.face()) ? 10 : Integer.parseInt(card.face()));
    }
    
    private String promptUserDecision() {
        System.out.println("H -> Hit me with another card\nS -> Stand");
        return scanner.nextLine().toUpperCase();
    }
    
    private boolean evaluateBust() {    
        if (playerTotal == 21) {
            System.out.println("BLACKJACK!!!");
            wins++;
            gamesPlayed++;
            return false;
        } else if (playerTotal < 21) {
            System.out.println("Want would you like to do? Hit or Stand?");
            return true;
        } else {
            System.out.println("Busted!");
            gamesPlayed++;
            return false;
        }
    }
    
    private void checkWinner() {
        getDealerHand();
        printHands();

        if (playerTotal > dealerTotal || dealerTotal > 21) {
            System.out.println("YOU WON!");
            wins++;
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a PUSH!");
        }
        gamesPlayed++;
        keepPlaying = false;
    }

    private void printInitialHands() {
        System.out.println("Player hand: " + playerHand + ": total -> " + playerTotal);
        System.out.println("Dealer hand: [ ?, " + dealerHand.get(1) + "]: total -> " + getCardValue(dealerHand.get(1)) + "+ ?"); 
    }
    
    private void printHands() {
        System.out.println("Player hand: " + playerHand + ": total -> " + playerTotal);
        System.out.println("Dealer hand: " + dealerHand + ": total -> " + dealerTotal);
    }

    private void getDealerHand() {
        while (dealerTotal < 16 && !(dealerTotal > 21)) {
            dealerHand.add(getCard());
            dealerTotal = assessHandTotal(dealerHand);
        }
    }

    private void printScore() {
        if (gamesPlayed > 0) {
            String w = wins <= 1 ? "win" : "wins";
            winPercent = ((double) wins/gamesPlayed) * 100;
            System.out.printf("Player stat: %d %s out of %d games (%3.1f%%)%n", wins, w, gamesPlayed, winPercent);
        }
    }
}