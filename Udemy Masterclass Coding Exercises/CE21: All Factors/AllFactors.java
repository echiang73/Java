// Basic solution, concise but not the most performant
public class FactorPrinter {
    public static void printFactors(int number) {  
        if (number < 1) {
            System.out.println("Invalid Value");
        }
        
        for(int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}


// Alternative solution optimized to loop half number of iterations
public class FactorPrinter {
    public static void printFactors(int number) {  
        if (number < 1) {
            System.out.println("Invalid Value");
            return;
        }
        
        for(int i = 1; i <= number/2; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
        System.out.println(number);
    }
}


// Alternative solution printing on one line separated by a space and trim whitespace at end
public class FactorPrinter {
    public static void printFactors(int number) {
        String str = "";
        if (number < 1) {
            str += "Invalid Value";
        } else {
            for(int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    str += i + " ";
                }
            }
        }
        System.out.println(str.trim());
    }
}


// Alternative solution printing on one line separated by a space optimized loop
public class FactorPrinter {
    public static void printFactors(int number) {
        String str = "";
        if (number < 1) {
            str += "Invalid Value";
        } else {
            for(int i = 1; i <= number/2; i++) {
                if (number % i == 0) {
                    str += i + " ";
                }
            }
            str += number;
        }
        System.out.println(str);
    }
}