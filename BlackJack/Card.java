import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Card {
    Suit suit;
    String face;
    int rank;

    public Card(Suit suit, String face, int rank) {
        this.suit = suit;
        this.face = face;
        this.rank = rank;
    }

    public Suit suit() {
        return suit;
    }

    public String face() {
        return face;
    }

    public int rank() {
        return rank;
    }

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage() {
            return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
            // return (new char[]{'\u2663', '\u2666', '\u2665', '\u2660'})[this.ordinal()]; // java source code
        }
    }

    public static Comparator<Card> sortRankReversedSuit() {
        return Comparator.comparing(Card::rank).reversed().thenComparing(Card::suit);
    }

    @Override
    public String toString() {
        // return face + suit.getImage();

        String RESET_BLACK = "\u001B[0m";
        String RED = "\u001B[31m";
        return face + (suit == Suit.HEART || suit == Suit.DIAMOND ? RED + suit.getImage() + RESET_BLACK : suit.getImage());
    }

    public static Card getNumericCard(Suit suit, int cardNumber) {

        if (cardNumber > 1 && cardNumber < 11) {
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
    }

    public static Card getFaceCard(Suit suit, char abbrev) {

        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1) {
            return new Card(suit, "" + abbrev, charIndex + 9);
        }
        System.out.println("Invalid Face card selected");
        return null;
    }

    public static List<Card> getStandardDeck() {

        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (int i = 2; i <= 10; i++) {
                deck.add(getNumericCard(suit, i));
            }
            for (char c : new char[]{'J', 'Q', 'K', 'A'}) {
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck) {
        printDeck(deck, "Spy Vision - Current Deck Order", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows) {
        System.out.println("-".repeat(10) + description + "-".repeat(10));
        int minRowLength = deck.size() / rows;
        int cardsInLastColumn = deck.size() % rows;
        int startIndex = 0;
        for (int i = 1; i <= Math.min(rows, deck.size()); i++) {
            int currentRowLength = minRowLength + (i <= cardsInLastColumn ? 1 : 0);
            int endIndex = Math.min(startIndex + currentRowLength, deck.size());
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print((c.face.length() == 1 ? " " : "") + c + " "));
            System.out.println();
            startIndex = endIndex;
        }
        System.out.println("-".repeat(51));
    }
}
