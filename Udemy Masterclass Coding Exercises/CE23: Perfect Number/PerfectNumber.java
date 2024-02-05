// Basic solution, not performant
public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        if (number < 1) {
            return false;
        }
        for(int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}


// Alternative solution, initialize sum = 1 and optimize loop to stop at number/2
public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        int sum = 1;
        if (number < 1) {
            return false;
        }
        for(int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}


// Alternative solution, initialize sum = 1 and optimize loop with Math.sqrt and adding 2 values to sum
public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        int sum = 1;
        if (number < 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum += (i + number/i);
            }
        }
        return sum == number;
    }
}