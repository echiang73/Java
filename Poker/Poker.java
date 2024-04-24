package Poker;

import java.util.*;
import java.math.BigDecimal; 
import java.text.DecimalFormat; 

public class Poker {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String playerName;
    int playerChipTotal = 0;
    int opponent1ChipTotal = 0;
    int opponent2ChipTotal = 0;
    int opponent3ChipTotal = 0;
    List<Card> deck;
    List<Card> playerHand = new ArrayList<>();
    List<Card> opponent1Hand = new ArrayList<>();
    List<Card> opponent2Hand = new ArrayList<>();
    List<Card> opponent3Hand = new ArrayList<>();
    List<Card> dealerFlopHand = new ArrayList<>();
    ListIterator<Card> cards;
    String playerInput;
    double winPercent = 0;
    boolean spyVisionOn;
    Blind dealer;
    Blind smallBlind;
    Blind bigBlind;

    public void startGame() {
        System.out.println("\nWelcome to the Java Texas Hold'em Poker");
        playerName = promptPlayerName();
        checkSpyVision();
        playerInput = promptUserInput();

        while(true) {
            if ("P".equals(playerInput)) {
                pokerGame();
                playerInput = promptUserInput();
            } else if ("Q".equals(playerInput)) {
                printWinPercentageMessage();
                System.out.println("Thanks for playing Java Texas Hold'em Poker, " + playerName + ". Goodbye!");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid entry, enter P or Q");
                playerInput = scanner.nextLine().toUpperCase();
            }

        }
    }

    private String promptPlayerName() {
        System.out.print("Please enter player name. ");
        return scanner.nextLine();
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
            System.out.println("Poker might not be your cup of tea.  Try slots.");
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
        System.out.println(playerName + ", before we start, would you like to put on Spy Vision sunglasses to see deck cards and opponents' cards?");
        System.out.println("Y -> Yes\nN -> No");
        return scanner.nextLine().toUpperCase();
    }

    private void pokerGame() {
        initGame();

    }

    private void initGame() {
        deck = getNewDeck();
        cards = deck.listIterator();

        askStartingChipAmount();

        determineAndPayBlind();

        playerHand.clear();
        opponent1Hand.clear();
        opponent2Hand.clear();
        opponent3Hand.clear();
        
        dealTwoCardsEach();
        dealFlop();
        printInitialHands();
    }

    private List<Card> getNewDeck() {
        List<Card> newDeck = Card.getDoubleDeck();
        Collections.shuffle(newDeck);
        if (spyVisionOn) {
            Card.printDeck(newDeck);
        }
        return newDeck;
    }

    private void askStartingChipAmount() {
        System.out.print("How much chips would you like to start with? ");
        String chipAmount = scanner.nextLine();
        while(true) {
            try {
                playerChipTotal = Integer.parseInt(chipAmount);
                opponent1ChipTotal = Integer.parseInt(chipAmount);
                opponent2ChipTotal = Integer.parseInt(chipAmount);
                opponent3ChipTotal = Integer.parseInt(chipAmount);
                System.out.println("Starting Chip Count: ");
                printChipStatus();
                break;
            } catch (Exception ex) {
                System.out.println("Invalid entry, please enter a number");
                chipAmount = scanner.nextLine();
            }
        }
    }

    private String convertCurrrency(int amount) {
        BigDecimal bdAmt = new BigDecimal("" + amount); 
        return new DecimalFormat("$#,##0").format(bdAmt); 
    }

    private void printChipStatus() {        
        System.out.println(playerName + ": " + convertCurrrency(playerChipTotal)
            + "\nOpponent1: " + convertCurrrency(opponent1ChipTotal)
            + "\nOpponent2: " + convertCurrrency(opponent2ChipTotal)
            + "\nOpponent3: " + convertCurrrency(opponent3ChipTotal));
    }

    public enum Blind {
        USER, OPPONENT1, OPPONENT2, OPPONENT3;
    }

    private void determineAndPayBlind() {
        int randomInt = new Random().nextInt(Blind.values().length);
        dealer = Blind.values()[randomInt];
        smallBlind = Blind.values()[(randomInt + 1) % 4];
        bigBlind = Blind.values()[(randomInt + 2) % 4];
        System.out.println("For this round, " + dealer + " is the Dealer");
        System.out.println("$10 Small Blind is posted by " + smallBlind);
        System.out.println("$20 Big Blind is posted by " + bigBlind);
        payBlind(smallBlind, bigBlind);
        
    }

    private void payBlind(Blind smallBlind, Blind bigBlind) {
        switch(smallBlind) {
            case USER:
                playerChipTotal -= 10;
                break;
            case OPPONENT1:
                opponent1ChipTotal -= 10;
                break;
            case OPPONENT2:
                opponent2ChipTotal -= 10;
                break;
            case OPPONENT3:
                opponent3ChipTotal -= 10;
                break;
            default:
                break;
        }

        switch(bigBlind) {
            case USER:
                playerChipTotal -= 20;
                break;
            case OPPONENT1:
                opponent1ChipTotal -= 20;
                break;
            case OPPONENT2:
                opponent2ChipTotal -= 20;
                break;
            case OPPONENT3:
                opponent3ChipTotal -= 20;
                break;
            default:
                break;
        }

        printChipStatus();

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

        // playerTotal = assessHandTotal(playerHand);
        // opponent1Total = assessHandTotal(opponent1Hand);
        // opponent2Total = assessHandTotal(opponent1Hand);
        // opponent3Total = assessHandTotal(opponent1Hand);
        // printInitialHands();
    }

    private void dealFlop() {
        for (int i = 0; i < 3; i++) {
            addToFlop();
        }
    }

    private void addToFlop() {
        dealerFlopHand.add(getCard());
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
        System.out.println(playerName + "'s hand: " + playerHand);
        if (spyVisionOn) {
            System.out.println("Opponent1 hand: [" + opponent1Hand.get(0) + ", " + opponent1Hand.get(1) + "]"); 
            System.out.println("Opponent2 hand: [" + opponent2Hand.get(0) + ", " + opponent2Hand.get(1) + "]"); 
            System.out.println("Opponent3 hand: [" + opponent3Hand.get(0) + ", " + opponent3Hand.get(1) + "]"); 
        }
        System.out.println("Flop: " + dealerFlopHand);
    }

    // private int getCardValue(Card card) {
    //     return card.face().equals("A") ? 11 : ((Arrays.asList("K", "Q", "J")).contains(card.face()) ? 10 : Integer.parseInt(card.face()));
    // }

    private void assessBestHand() {
        // TODO
    }

}