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
