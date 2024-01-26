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
        }
    }

    public static Comparator<Card> sortRankReversedSuit() {
        return Comparator.comparing(Card::rank).reversed().thenComparing(Card::suit);
    }

    @Override
    public String toString() {
        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return faceString + suit.getImage();
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
        printDeck(deck, "Current Deck - Spy Vision", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows) {
        System.out.println("-".repeat(9) + description + "-".repeat(9));
        int cardsInRow = deck.size() / rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
        System.out.println("-".repeat(43));
    }

}


// // record not support here

// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.List;

// public record Card(Suit suit, String face, int rank) {

//     public enum Suit {
//         CLUB, DIAMOND, HEART, SPADE;

//         public char getImage() {
//             return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
//         }
//     }

//     public static Comparator<Card> sortRankReversedSuit() {
//         return Comparator.comparing(Card::rank).reversed().thenComparing(Card::suit);
//     }

//     @Override
//     public String toString() {

//         int index = face.equals("10") ? 2 : 1;
//         String faceString = face.substring(0, index);
//         return "%s%c".formatted(faceString, suit.getImage());
//     }

//     public static Card getNumericCard(Suit suit, int cardNumber) {

//         if (cardNumber > 1 && cardNumber < 11) {
//             return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
//         }
//         System.out.println("Invalid Numeric card selected");
//         return null;
//     }

//     public static Card getFaceCard(Suit suit, char abbrev) {

//         int charIndex = "JQKA".indexOf(abbrev);
//         if (charIndex > -1) {
//             return new Card(suit, "" + abbrev, charIndex + 9);
//         }
//         System.out.println("Invalid Face card selected");
//         return null;
//     }

//     public static List<Card> getStandardDeck() {

//         List<Card> deck = new ArrayList<>(52);
//         for (Suit suit : Suit.values()) {
//             for (int i = 2; i <= 10; i++) {
//                 deck.add(getNumericCard(suit, i));
//             }
//             for (char c : new char[]{'J', 'Q', 'K', 'A'}) {
//                 deck.add(getFaceCard(suit, c));
//             }
//         }
//         return deck;
//     }

//     public static void printDeck(List<Card> deck) {
//         printDeck(deck, "Current Deck - Spy Vision", 4);
//     }

//     public static void printDeck(List<Card> deck, String description, int rows) {
//         System.out.println("-".repeat(9) + description + "-".repeat(9));
//         int cardsInRow = deck.size() / rows;
//         for (int i = 0; i < rows; i++) {
//             int startIndex = i * cardsInRow;
//             int endIndex = startIndex + cardsInRow;
//             deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
//             System.out.println();
//         }
//         System.out.println("-".repeat(43));
//     }

// }