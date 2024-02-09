// Visualization solution with main method and printing letters and test on IDE
public class DiagonalStar {
    public static void main(String args[]) {
        printSquareStar(7);
    }
    
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for(int i = 1; i <= number; i++) { // where i is the currentRow
                for (int j = 1; j <= number; j++) { // where j is the rowCount or "column"
                    if (i == 1) {
                        System.out.print("T"); // TOP
                    } else if (i == number) {
                        System.out.print("B"); // BOTTTOM
                    } else if (j == 1) {
                        System.out.print("L"); // LEFT
                    } else if (j == number) {
                        System.out.print("R"); // RIGHT
                    } else if (i == j) {
                        System.out.print("D"); // diagonal left DOWN to right
                    } else if (j == number - i + 1) {
                        System.out.print("U"); // diagonal left UP to right
                    } else {
                        System.out.print(" "); // print space in pattern
                    }
                }
                System.out.println();
            }
        }
    }
}

// TTTTTTT
// LD   UR
// L D U R
// L  D  R
// L U D R
// LU   DR
// BBBBBBB


// Basic solution combining conditions with OR operator and printing *
public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for(int i = 1; i <= number; i++) {
                for (int j = 1; j <= number; j++) {
                    if (i == 1 || i == number || j == 1 || j == number || i == j || j == number - i + 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}

// *******
// **   **
// * * * *
// *  *  *
// * * * *
// **   **
// *******


// Alternative solution using ternary operator
public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }
        for(int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                System.out.print((i == 1 || i == number || j == 1 || j == number || i == j || j == number - i + 1) ? "*" : " ");
            }
            System.out.println();
        }
    }
}


// Alternative solution concatenating String to print once at the end
public class DiagonalStar {
    public static void printSquareStar (int number){
        if (number<5) {
            System.out.println ("Invalid Value");
            return;
        }
        String output = "";
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                output += (i == 1 || i == number || j == 1 || j == number || i == j || j == number - i + 1) ? "*" : " ";
            }
            output += "\n";
        }
        System.out.println(output);
    }
}