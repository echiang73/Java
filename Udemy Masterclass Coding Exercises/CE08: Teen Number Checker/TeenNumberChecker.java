/* Note that isTeen() is a helper method that "helps" with repetitive tasks.  In the hasTeen() method,
call the helper method instead of having code repetition.  This is considered best practice as it reduces
the potential for bugs by having the teen evaluation in one location. */

// Basic solution
public class TeenNumberChecker {
    public static boolean hasTeen(int num1, int num2, int num3) {
        if (isTeen(num1) || isTeen(num2) || isTeen(num3)) {
            return true;
        }
        return false;
    }
    
    public static boolean isTeen(int num) {        
        return num >= 13 && num <= 19;
    }
}


// Alternative solution using shorthand
public class TeenNumberChecker {
    public static boolean hasTeen(int num1, int num2, int num3) {
        return isTeen(num1) || isTeen(num2) || isTeen(num3);
    }
    
    public static boolean isTeen(int num) {        
        return num >= 13 && num <= 19;
    }
}


// Alternative solution using stream and lambda (extra method won't pass Udemy checker)
import java.util.List;
 
public class TeenNumberChecker {
    public static boolean hasTeen(int num1, int num2, int num3) {
        return List.of(num1, num2, num3).stream().anyMatch(num -> isTeen(num));
    }
    
    public static boolean isTeen(int num) {        
        return num >= 13 && num <= 19;
    }
}


// Alternative solution using stream and use of reference method to pass (will pass checker):
import java.util.List;

public class TeenNumberChecker {
    public static boolean hasTeen(int num1, int num2, int num3) {
        return List.of(num1, num2, num3).stream().anyMatch(TeenNumberChecker::isTeen);
    }
    
    public static boolean isTeen(int num) {        
        return num >= 13 && num <= 19;
    }
}