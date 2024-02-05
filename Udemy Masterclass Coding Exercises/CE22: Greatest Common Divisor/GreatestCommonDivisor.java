// Basic solution, not performant
public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }
    
        int gcd = 0;
        for (int i = 1; i <= first; i++) {
            if (first % i == 0 && second % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}


// Alternative solution, optimized to stop iterating with smaller argument
public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }
    
        int gcd = 0;
        int min = Math.min(first, second);
        for (int i = 1; i <= min; i++) {
            if (first % i == 0 && second % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}


// Alternative solution without min variable, but using Math.min() inside for loop condition
public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }
    
        int gcd = 0;
        for (int i = 1; i <= Math.min(first, second); i++) {
            if (first % i == 0 && second % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}


// Alternative solution decrementing loop and short-circuit with first common divisor
public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first >= 10 && second >= 10) {
            for (int i = Math.min(first, second); i > 1; i--) {
                if (first % i == 0 && second % i == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}


// Alternative solution using subtraction-based Euclidean algorithm
public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if ((first < 10) || (second < 10)) {
            return -1;
        }
     
        while (first != second) {
            if (first > second) {
                first -= second;
            } else {
                second -= first;
            }
        }
        return first;
    }
}


// Alternative solution using performant division-based Euclidean algorithm
public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }
 
        while (second != 0) {
            int temp = second;
            second = first % second;
            first = temp;
        }
        return first;
    }
}


// Alternative solution using recursion-based Euclidean algorithm (won't pass Udemy checker with 2-digit validation)
public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) { // note: requirement prevents recursion from functioning as expected
            return -1;
        }
 
        if (second == 0) {
            return first;
        } else {
            return getGreatestCommonDivisor(second, first%second);
        }
    }
}