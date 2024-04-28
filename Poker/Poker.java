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
    List<Card> burnCards = new ArrayList<>();
    List<Card> flop = new ArrayList<>();
    ListIterator<Card> cards;
    String playerInput;
    double winPercent = 0;
    boolean spyVisionOn;
    int randomDealerIndex = -1;
    Blind dealer;

    public void startGame() {
        System.out.println("\nWelcome to the Java Texas Hold'em Poker");
        playerName = promptPlayerName();
        checkSpyVision();
        askStartingChipAmount();

        initDeck();

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

    private void initDeck() {
        deck = getNewDeck();
        cards = deck.listIterator();
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

    private void pokerGame() {
        if (randomDealerIndex == -1) {
            randomDealerIndex = new Random().nextInt(Blind.values().length);
            dealer = Blind.values()[randomDealerIndex % 4];
        } else {
            randomDealerIndex++;
            dealer = Blind.values()[randomDealerIndex % 4]; // does this increment?
        }
        determineBlinds();

        playerHand.clear();
        opponent1Hand.clear();
        opponent2Hand.clear();
        opponent3Hand.clear();
        
        dealTwoCardsEach();

        // bet on blind to continue

        dealFlop();
        printInitialHands();

        // // testing blinds
        // nextBlind();
        // determineAndPayBlind();
        // nextBlind();
        // determineAndPayBlind();
    }

    private List<Card> getNewDeck() {
        List<Card> newDeck = Card.getDoubleDeck();
        Collections.shuffle(newDeck);
        if (spyVisionOn) {
            Card.printDeck(newDeck);
        }
        return newDeck;
    }

    public enum Blind {
        USER, OPPONENT1, OPPONENT2, OPPONENT3;
    }

    // private void nextBlind() {
    //     smallBlind = Blind.values()[(smallBlind.ordinal() + 1) % 4];
    //     bigBlind = Blind.values()[(bigBlind.ordinal() + 1) % 4];
    // }

    private void determineBlinds() {
        Blind smallBlind = Blind.values()[(dealer.ordinal() + 1) % 4];
        Blind bigBlind = Blind.values()[(dealer.ordinal() + 2) % 4];
        System.out.println("For this round, " + dealer + " is the Dealer");
        // System.out.println("$10 Small Blind is posted by " + smallBlind);
        System.out.println("$10 Small Blind is posted by " + convertName(smallBlind));
        // System.out.println("$20 Big Blind is posted by " + bigBlind);
        System.out.println("$20 Big Blind is posted by " + convertName(bigBlind));
        payBlind(smallBlind);
        payBlind(bigBlind);
        printChipStatus();
    }

    private String convertNames(Blind blind) {
        if (blind.equals(Blind.USER)) {
            return playerName;
        } else if (blind.equals(Blind.OPPONENT1)) {
            return "Computer #1";
        } else if (blind.equals(Blind.OPPONENT2)) {
            return "Computer #2";
        } else {
            return "Computer #3";
        }
    }

    private void payBlind(Blind blind) {
        switch(blind) {
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

    private Card getCard() {
        return cards.next();
    }

    private void dealFlop() {
        burnCard();
        for (int i = 0; i < 3; i++) {
            addToFlop();
        }
    }

    private void burnCard() {
        burnCards.add(getCard());
    }

    private void addToFlop() {
        flop.add(getCard());
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
            System.out.println("Burn: " + burnCards);
        }
        System.out.println("Flop: " + flop);
    }

    // private int getCardValue(Card card) {
    //     return card.face().equals("A") ? 11 : ((Arrays.asList("K", "Q", "J")).contains(card.face()) ? 10 : Integer.parseInt(card.face()));
    // }

    private void assessBestHand() {
        // TODO
    }

}