public class PositiveNegativeZero {
    public static void checkNumber(int number){
        if (number > 0){
            System.out.println("positive");
        } else if (number < 0){
            System.out.println("negative");
        } else {
            System.out.println("zero");
        }
    }
}

// // ternary operator
// public class PositiveNegativeZero {
//     public static void checkNumber(int number){
//         System.out.println(number > 0 ? "positive" : (number < 0 ? "negative" : "zero"));
//     }
// }

// // ternary operator with CONSTANTS
// public class PositiveNegativeZero {
//     public static void checkNumber(int number){
//         String POS = "positive";
//         String NEG = "negative";
//         String ZERO = "zero";
        
//         System.out.println(number > 0 ? POS : (number < 0 ? NEG : ZERO));
//     }
// }
