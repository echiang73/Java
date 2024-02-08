// Basic solution, using nested loops which is not performant
public class LargestPrime {
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }
        
        int prime = -1;

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                boolean isPrime = true;
                
                // check if i is divisible further
                for (int j = 2 ; j < i; j++) {
                    if(i%j == 0) { // if i is divisible, then not a prime
                        isPrime = false;
                        break;
                    }
                }
                
                if (isPrime) {
                    prime = i;
                }
            }
        } 
        return prime;
    }
}


// Alternative solution, stop inner loop at j <= i/2 instead of j < i for 50% improvement in code performance
public class LargestPrime {
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }
        
        int prime = -1;

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                boolean isPrime = true;

                for (int j = 2 ; j <= i/2; j++) { // performant, stop at i/2
                    if(i%j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                
                if (isPrime) {
                    prime = i;
                }
            }
        } 
        return prime;
    }
}


// Alternative solution using one loop to keep checking for divisors
public class LargestPrime {
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }
        
        int i = 2;
        while (i < number) {
            if (number % i == 0) {
                number /= i;
                continue;
            }
            i++;
        }
        return number;
    }
}


// Alternative solution using one loop to keep checking for divisors
public class LargestPrime {
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }

        for (int i = 2; i < number; i++) {
            if(number % i == 0) {
                number /= i;
                i--; // to negate i++
            }
        }
        return number;
    }
}


// Alternative solution iterating loop by decrementing down toward 1 and assigning argument as divisor
public class LargestPrime {
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }

        for (int i = number-1; i > 1; i--) { // decrementing
            if (number % i == 0) {
                number = i; // set argument as the divisor
            }
        }
        return number;
    }
}