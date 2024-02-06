// Basic solution following instruction's advice to get difference of count to print extra "Zero"
public class NumberToWords {
    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        } else if (number == 0) {
            System.out.println("Zero");
        } else {
            int reversedNumber = reverse(number);
            int numDigitCount = getDigitCount(number);
            int revNumDigitCount = getDigitCount(reversedNumber);
            int diffCount = numDigitCount - revNumDigitCount;
            
            while (reversedNumber > 0){
                switch (reversedNumber%10) {
                    case 0 -> System.out.println("Zero");
                    case 1 -> System.out.println("One");
                    case 2 -> System.out.println("Two");
                    case 3 -> System.out.println("Three");
                    case 4 -> System.out.println("Four");
                    case 5 -> System.out.println("Five");
                    case 6 -> System.out.println("Six");
                    case 7 -> System.out.println("Seven");
                    case 8 -> System.out.println("Eight");
                    case 9 -> System.out.println("Nine");
                }
                reversedNumber /= 10;
            }

            while (diffCount > 0) {
                System.out.println("Zero");
                diffCount--;
            }
        }
    }
    
    public static int reverse(int number) {
        int reverse = 0;
        while (number != 0) {
            reverse = reverse*10 + number%10;
            number /= 10;
        }
        return reverse;
    }
    
    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        } else if (number == 0) {
            return 1;
        } else {
            int count = 0;
            while (number > 0) {
                count++;
                number /= 10;
            }
            return count;
        }
    }  
}


// Alternative solution using existing switch case to print extra "Zero", and do while loop for getDigitCount()
public class NumberToWords {
    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }
        int reversedNumber = reverse(number);
        int numDigitCount = getDigitCount(number);
        
        while (numDigitCount > 0){
            switch (reversedNumber%10) {
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
            }
            reversedNumber /= 10;
            numDigitCount--;
        }
    }
    
    public static int reverse(int number) {
        int reverse = 0;
        while (number != 0) {
            reverse = reverse*10 + number%10;
            number /= 10;
        }
        return reverse;
    }
    
    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        int count = 0;
        do {
            count++;
            number /= 10;
        } while (number > 0);
        return count;
    }
}


// Alternative solution using String array. Uncomment getDigitCount() and reverse() methods to pass Udemy checker
public class NumberToWords {
    public static void numberToWords (int number) {
        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Invalid Value"};
        String numStr = "" + Math.abs(number);
        
        if (number < 0) {
            System.out.println(words[10]);
            return;
        }

        for (int i = 0; i < numStr.length(); i++) {
            int num = Integer.parseInt(numStr.substring(i, i+1));
            System.out.println(words[num]);
        }
        
    }
    
    // public static int getDigitCount(int number) { // unused by required to pass checker
    //     return number < 0 ? -1 : ("" + number).length();
    // }
    
    // public static int reverse(int number) { // unused by required to pass checker
    //     int ret = Integer.parseInt(new StringBuilder("" + Math.abs(number)).reverse().toString());
    //     return number < 0 ? ret * -1 : ret;
    // }
}


// Alternative methods for getDigitCount() using String manipulation
    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        String str = Integer.toString(number);
        return str.length();
    }


// Alternative methods for getDigitCount() using String manipulation with ternary operator and concatentation
    public static int getDigitCount(int number) {
        return number < 0 ? -1 : ("" + number).length();
    }
    

// Alternative methods for reverse() using built-in method in StringBuilder or StringBuffer
    public static int reverse(int number) {
        StringBuilder forward = new StringBuilder("" + Math.abs(number));
        StringBuilder reverse = forward.reverse();
        int result = Integer.valueOf(reverse.toString());
        return (number < 0) ? result * -1 : result;
    }


// Alternative methods for reverse() using built-in method in StringBuilder using ternary operator
    public static int reverse(int number) {
        int result = Integer.valueOf(new StringBuilder("" + Math.abs(number)).reverse().toString());
        return (number < 0) ? result * -1 : result;
    }

