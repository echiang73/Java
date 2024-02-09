/* This is a fun, but challenging coding exercise since it requires some visualization to program.  Thus, I provided
a solution that prints letters instead of asterisk so you can visualize the correlation between the condition and the
location of the output on the square.  I also provide two versions of the solution where the nested loop starts to
increment with 1 (which may make more logical sense as first row) or with 0 (for the savvy programmers that prefer
corresponding to 0 index).  I also included alternative solutions using ternary operator for conciseness and using
String concatenation.  Lastly, there are two advanced solutions that uses a single for loop to print the pattern.

If printing star patterns is still too confusing, here is a really good YouTube video that explains the basic concept of
how to print line by line.  https://www.youtube.com/watch?v=xzstcj3Cuso
*/

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


// Alternative solution using 0 starting index for currentRow i and rowCount j
public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for(int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (i == 0 || i == number-1 || j == 0 || j == number-1 || i == j || j == number-1 - i) {
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


// Alternative solution using ternary operator and deleting else keyword
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
    public static void printSquareStar(int number){
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


// Alternative solution with one for loop
public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }
        for (int i = 1; i <= number*number; i++) {
            if (i%number == 0) {
                System.out.println("*");
            } else {
                System.out.print(
                (i >= 1 && i <= number)
                || (i >= number*number-number)
                || (i-1)%number == 0
                || i/number+1 == i%number
                || i%number == number-(i/number+1)+1
                ? "*" : " ");
            }
        }
    }
}


// Alternative solution with one loop and nested ternary operators (not recommended as readability impacted)
public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }
        for (int i = 1; i <= number*number; i++) {
            boolean isStar = (i >= 1 && i <= number)
                || (i >= number*number-number)
                || (i-1)%number == 0
                || i/number+1 == i%number
                || i%number == number-(i/number+1)+1;
            System.out.print(i%number == 0 ? "*\n" : (isStar ? "*" : " "));
        }
    }
}