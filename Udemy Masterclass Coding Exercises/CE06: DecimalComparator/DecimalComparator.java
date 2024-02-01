// Basic solution
public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        int cal1 = (int) (num1*1000);
        int cal2 = (int) (num2*1000);
        if (cal1 == cal2) {
            return true;
        }
        return false;
    }
}


// Alternative solution using shorthand and no variables
public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        return (int) (num1*1000) == (int) (num2*1000);
    }
}