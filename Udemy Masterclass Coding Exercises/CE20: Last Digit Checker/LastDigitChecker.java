// Basic solution with best practice calling helper method to reduce code repetition
public class LastDigitChecker {
    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (!isValid(num1) || !isValid(num2) || !isValid(num3)) {
            return false;
        }
        
        if (num1%10 == num2%10 || num1%10 == num3%10 || num2%10 == num3%10) {
            return true;
        }
        return false;
    }
    
    public static boolean isValid(int num) {
        if (num >= 10 && num <= 1000) {
            return true;
        }
        return false;
    }
}


// Alternative solution using shorthand
public class LastDigitChecker {
    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (!isValid(num1) || !isValid(num2) || !isValid(num3)) {
            return false;
        }
        
        return num1%10 == num2%10 || num1%10 == num3%10 || num2%10 == num3%10;
    }
    
    public static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}


// Alternative solution with single-line return statement at the expense of a bit of readability
public class LastDigitChecker {
    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        return isValid(num1) && isValid(num2) && isValid(num3) && (num1%10 == num2%10 || num1%10 == num3%10 || num2%10 == num3%10);
    }
    
    public static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}


// Alternative solution using HashSet which doesn't allow for duplication
import java.util.*; // Set, HashSet, Arrays

public class LastDigitChecker {
    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (!isValid(num1) || !isValid(num2) || !isValid(num3)) {
            return false;
        }
        
        Set<Integer> set = new HashSet<> (Arrays.asList(num1%10, num2%10, num3%10));
        return set.size() != 3; // if size is 3, then no duplication
    }
    
    public static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}


// Alternative solution using HashSet and combining conditions
import java.util.*; // Set, HashSet, Arrays

public class LastDigitChecker {
    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        Set<Integer> set = new HashSet<> (Arrays.asList(num1%10, num2%10, num3%10));
        return isValid(num1) && isValid(num2) && isValid(num3) && set.size() != 3;
    }
    
    public static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}


// Alternative solution using HashSet as single-line return statement w/ readability impacted
import java.util.*; // Set, HashSet, Arrays

public class LastDigitChecker {
    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        return isValid(num1) && isValid(num2) && isValid(num3) && new HashSet<Integer> (Arrays.asList(num1%10, num2%10, num3%10)).size() != 3;
    }
    
    public static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}