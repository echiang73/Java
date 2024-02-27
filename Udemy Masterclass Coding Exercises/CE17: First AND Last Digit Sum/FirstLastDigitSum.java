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


// Alternative solution using String array and ternary operator
public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        String[] str = ("" + number).split("");
        return number < 0 ? -1 : Integer.valueOf(str[0]) + Integer.valueOf(str[str.length-1]);
    }
}


// Alternative solution using String and charAt of ASCII char (offset by 48)
public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        String str = ("" + number);
        int first = Integer.valueOf(Character.valueOf(str.charAt(0)))-48;
        int last = Integer.valueOf(Character.valueOf(str.charAt(str.length()-1)))-48;
        return number < 0 ? -1 : first + last;
    }
}


// Alternative solution using String and charAt of ASCII char (offset where '0' == 48)
public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        String str = ("" + number);
        int first = (int) (str.charAt(0) - '0');
        int last = (int) (str.charAt(str.length()-1) - '0');
        return number < 0 ? -1 : first + last;
    }
}