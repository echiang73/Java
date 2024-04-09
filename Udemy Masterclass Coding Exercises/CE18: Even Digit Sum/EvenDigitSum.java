// Basic solution
public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;
        while (number > 0) {
            if (number%2 == 0) {
                sum += number%10;
            }
            number /= 10;
        }
        return sum;
    }
}


// Alternative solution with ternary operator
public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            if (number%2 == 0) {
                sum += number%10;
            }
            number /= 10;
        }
        return number < 0 ? -1 : sum;
    }
}


// Alternative solution summing List of num with stream
import java.util.*; // List, ArrayList
 
public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        List<Integer> nums = new ArrayList<>();

        while (number > 0) {
            if (number%2 == 0) {
                nums.add(number%10);
            }
            number /= 10;
        }
        return number < 0 ? -1 : nums.stream().mapToInt(Integer::intValue).sum();
    }
}


// Alternative solution using String manipulation, chars(), and map() to sum
public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        String numStr = String.valueOf(number);
        int sum = numStr.chars().map(Character::getNumericValue).filter(c -> c%2 == 0).sum();
        return number < 0 ? -1 : sum;
    }
}


// Alternative solution using String manipulation, chars(), and map() to sum with ternary operator
public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        return number < 0 ? -1 : (""+number).chars().map(Character::getNumericValue).filter(c -> c%2 == 0).sum();
    }
}


// Alternative solution using String manipulation with stream of String array to sum
import java.util.List;
 
public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        String[] numStrArray = String.valueOf(number).split("");
        int sum = List.of(numStrArray).stream().mapToInt(Integer::parseInt).filter(i -> i%2 == 0).sum();
        return number < 0 ? -1 : sum;
    }
}

