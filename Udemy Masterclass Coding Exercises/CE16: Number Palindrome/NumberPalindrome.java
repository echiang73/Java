// Basic solution
public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int numToProcess = number; // mutate variable, not argument
        while (numToProcess != 0) {
            reverse = reverse*10 + numToProcess%10;
            numToProcess /= 10;
        }
        return reverse == number;
    }
}


// Alternative solution using for loop
public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        int reverse = 0;
        for (int i = number; i != 0; i /= 10) {
            reverse = reverse*10 + i%10;
        }
        return reverse == number;
    }
}


// Alternative solution using String and loop to match char
public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        String str = "" + Math.abs(number); // or Integer.toString(Math.abs(number));
        for (int i = 0; i <= (str.length()-1)/2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length()-1-i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }
}


// Alternative solution using built-in .reverse() in StringBuilder (or StringBuffer) class
public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        String numStr = "" + Math.abs(number); // or Integer.toString(Math.abs(number));
        StringBuilder numSb = new StringBuilder(numStr); // or new StringBuffer(numStr);
        StringBuilder revSb = numSb.reverse();
        String revStr = revSb.toString();
        return numStr.equals(revStr);
    }
}


// Alternative solution using StringBuilder as single line return statement
public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        return ("" + Math.abs(number)).equals(new StringBuilder("" + Math.abs(number)).reverse().toString());
    }
}


// Alternative solution using StringBuilder with compareTo()
public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        String numStr = "" + Math.abs(number);
        StringBuilder numSb = new StringBuilder(numStr);
        StringBuilder revSb = new StringBuilder(numStr).reverse();
        return numSb.compareTo(revSb) == 0; // 0 for true
    }
}


