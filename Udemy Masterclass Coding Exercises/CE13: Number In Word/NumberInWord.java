// Basic solution using traditional switch case
public class NumberInWord {
    public static void printNumberInWord(int number){
        switch(number){
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
        }
    }
}


// Alternative solution using traditional switch case with cached variable and break
public class NumberInWord {
    public static void printNumberInWord(int number){
        String word;
        switch(number){
            case 0:
                word = "ZERO";
                break;
            case 1:
                word = "ONE";
                break;
            case 2:
                word = "TWO";
                break;
            case 3:
                word = "THREE";
                break;
            case 4:
                word = "FOUR";
                break;
            case 5:
                word = "FIVE";
                break;
            case 6:
                word = "SIX";
                break;
            case 7:
                word = "SEVEN";
                break;
            case 8:
                word = "EIGHT";
                break;
            case 9:
                word = "NINE";
                break;
            default:
                word = "OTHER";
                break;
        }
        System.out.println(word);
    }
}


// Alternative solution using enhanced switch case with yield
public class NumberInWord {
    public static void printNumberInWord(int number) {
        String word = switch (number) {
            case 0: yield "ZERO";
            case 1: yield "ONE";
            case 2: yield "TWO";
            case 3: yield "THREE";
            case 4: yield "FOUR";
            case 5: yield "FIVE";
            case 6: yield "SIX";
            case 7: yield "SEVEN";
            case 8: yield "EIGHT";
            case 9: yield "NINE";
            default: yield "OTHER";
        };
        System.out.println(word);
    }
}


// Alternative solution using enhanced switch case with arrow function
public class NumberInWord {
    public static void printNumberInWord(int number) {
        String word = switch (number) {
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "OTHER";
        };
        System.out.println(word);
    }
}


// Alternative solution using nested enhanced switch case with arrow function inside println()
public class NumberInWord {
    public static void printNumberInWord(int number) {
        System.out.println(switch (number) {
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "OTHER";
        });
    }
}  