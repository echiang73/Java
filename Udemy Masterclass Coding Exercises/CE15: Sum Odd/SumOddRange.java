// Basic solution
public class SumOddRange {
    public static boolean isOdd(int number) {
        return number > 0 && number % 2 != 0;
    }
     
    public static int sumOdd(int start, int end) {
        int sum = 0;
        if (start < 0 || start > end) {
            return -1;
        }
     
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum += i;
            }
        }
        return sum;
    }
}


// Alternative solution improving code performance by finding first odd and iterating by 2
public class SumOddRange {
    public static boolean isOdd(int number) {
        return number > 0 && number % 2 != 0;
    }
     
    public static int sumOdd(int start, int end) {
        int sum = 0;
        if (start < 0 || start > end) {
            return -1;
        }
     
        int oddStart = isOdd(start) ? start : start + 1;
        for (int i = oddStart; i <= end; i+=2) {
            sum += i;
        }
        return sum;
    }
}


// Alternative solution nesting ternary operator inside for loop condition
public class SumOddRange {
    public static boolean isOdd(int number) {
        return number > 0 && number % 2 != 0;
    }
     
    public static int sumOdd(int start, int end) {
        int sum = 0;
        if (start < 0 || start > end) {
            return -1;
        }

        for (int i = isOdd(start) ? start : start + 1; i <= end; i+=2) {
            sum += i;
        }
        return sum;
    }
}


// Alternative solution using Math.pow() trick
// sumOdd(5, 9) = 5 + 7 + 9 = 21
// return (int) (Math.pow((9+1)/2, 2) - Math.pow(5/2, 2));
// return (int) (Math.pow(5, 2) - Math.pow(2, 2));
// return (int) (25 - 4); // 21
public class SumOddRange {
    public static boolean isOdd(int number) {
        return number > 0 && number%2 != 0;
    }
    
    public static int sumOdd(int start, int end) {
        int evenEnd = isOdd(end) ? end + 1 : end;
        int oddStart = isOdd(start) ? start : start + 1;
        return (start < 0 || start > end) ? -1 : (int) (Math.pow(evenEnd/2, 2) - Math.pow(oddStart/2, 2));
    }
}
