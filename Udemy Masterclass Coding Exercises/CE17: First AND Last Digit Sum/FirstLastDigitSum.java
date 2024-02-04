// Basic solution
public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int last = number%10;
        int first = number;
        
        while(first >= 10) {
            first /= 10;
        }
        
        return first + last;
    }
}


// Alternative solution mutating argument
public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int last = number%10;
        
        while(number >= 10) {
            number /= 10;
        }
        
        return number + last;
    }
}


// Alternative solution with ternary operator
public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        int last = number%10;
        
        while(number >= 10) {
            number /= 10;
        }
        
        return number < 0 ? -1 : number + last;
    }
}


// Alternative solution using String array
public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        if(number < 0) {
            return -1;
        }
        String[] str = ("" + number).split("");
        return Integer.valueOf(str[0]) + Integer.valueOf(str[str.length-1]);
    }
}