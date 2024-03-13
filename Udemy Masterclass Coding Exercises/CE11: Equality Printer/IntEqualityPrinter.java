// Basic solution
public class IntEqualityPrinter {
    public static void printEqual(int num1, int num2, int num3) {
        if (num1 < 0 || num2 < 0 || num3 < 0) {
            System.out.println("Invalid Value");
        } else if (num1 == num2 && num2 == num3) {
            System.out.println("All numbers are equal");
        } else if (num1 != num2 && num1 != num3 && num2 != num3) {
            System.out.println("All numbers are different");
        } else {
            System.out.println("Neither all are equal or different");
        }
    }
}


// Alternative solution with CONSTANTS for better readability and reusability
public class IntEqualityPrinter {
    public static void printEqual(int num1, int num2, int num3) {
        String INVALID = "Invalid Value";
        String DIFF = "All numbers are different";
        String NEITHER = "Neither all are equal or different";
        String EQUAL = "All numbers are equal";
        
        if (num1 < 0 || num2 < 0 || num3 < 0) {
            System.out.println(INVALID);
        } else if (num1 == num2 && num2 == num3) {
            System.out.println(EQUAL);
        } else if (num1 != num2 && num1 != num3 && num2 != num3) {
            System.out.println(DIFF);
        } else {
            System.out.println(NEITHER);
        }
    }
}


// (Not recommended) Alternative solution using nested ternary operators with CONSTANTS for better readability
public class IntEqualityPrinter {
    public static void printEqual(int num1, int num2, int num3) {
        String INVALID = "Invalid Value";
        String DIFF = "All numbers are different";
        String NEITHER = "Neither all are equal or different";
        String EQUAL = "All numbers are equal";
        
        System.out.println(
            (num1 < 0 || num2 < 0 || num3 < 0) ? INVALID : 
            ((num1 == num2 && num2 == num3) ? EQUAL : 
            ((num1 != num2 && num1 != num3 && num2 != num3) ? DIFF : NEITHER)));
    }
}


// Alternative solution using HashSet which doesn't allow for duplication
import java.util.*; // wildcard for Set, HashSet, Arrays
 
public class IntEqualityPrinter {
    public static void printEqual(int num1, int num2, int num3) {
        String INVALID = "Invalid Value";
        String DIFF = "All numbers are different";
        String NEITHER = "Neither all are equal or different";
        String EQUAL = "All numbers are equal";
        
        if (num1 < 0 || num2 < 0 || num3 < 0) {
            System.out.println(INVALID);
        } else {
            Set<Integer> set = new HashSet<Integer>(Arrays.asList(num1, num2, num3));
            System.out.println(set.size()==3 ? DIFF : (set.size()==2 ? NEITHER : EQUAL));
        }
    }
}


// Alternative solution using JDK9 more performant List.of() instead of Array.asList()
import java.util.*; // Set, HashSet, List

public class IntEqualityPrinter {
    public static void printEqual(int num1, int num2, int num3) {
        String INVALID = "Invalid Value";
        String DIFF = "All numbers are different";
        String NEITHER = "Neither all are equal or different";
        String EQUAL = "All numbers are equal";
        
        if (num1 < 0 || num2 < 0 || num3 < 0) {
            System.out.println(INVALID);
        } else {
            Set<Integer> set = new HashSet<Integer>(List.of(num1, num2, num3));
            System.out.println(set.size()==3 ? DIFF : (set.size()==2 ? NEITHER : EQUAL));
        }
    }
}
