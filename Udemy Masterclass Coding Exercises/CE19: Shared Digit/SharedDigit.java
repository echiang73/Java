// Basic solution with nested loop, O(n^2) not performant
public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2) {
        if (num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            return false;
        }
        
        for (int i = num1; i > 0; i /= 10) {
            for (int j = num2; j > 0; j /= 10){
                if (j%10 == i%10){
                    return true;
                }
            } 
        }
        return false;
    }
}


// Alternative solution without loops, O(1) performant
public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2) {
        if (num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            return false;
        }
        
        int num1First = num1/10;
        int num1Last = num1%10;
        int num2First = num2/10;
        int num2Last = num2%10;
        
        return (num1Last == num2Last || num1Last == num2First || num1First == num2Last || num1First == num2First);
    }
}


// Alternative solution without loops or variables for conciseness
public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2) {
        if (num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            return false;
        }
        return (num1%10 == num2%10 || num1%10 == num2/10 || num1/10 == num2%10 || num1/10 == num2/10);
    }
}
   
   
// Alternative solution as single-line return statement (impacts readability)
public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2) {
        return num1 >= 10 && num1 <= 99 && num2 >= 10 && num2 <= 99 &&
        (num1 % 10 == num2 % 10 || num1 % 10 == num2 / 10 || num1 / 10 == num2 % 10 || num1 / 10 == num2 / 10);
    }
}


// Alternative solution using int arrays and IntStream (won't pass Udemy checker, lambda is extra method)
import java.util.stream.IntStream;

public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2) {
        if (num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            return false;
        }
        
        int[] arrNum1 = { num1%10, num1/10 };
        int[] arrNum2 = { num2%10, num2/10 };
        return IntStream.of(arrNum1).anyMatch(x -> x == arrNum2[0] || x == arrNum2[1]);
    }
}