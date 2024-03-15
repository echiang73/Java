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


// Alternative solution using Math.abs()
public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        return Math.abs(num1*1000 - num2*1000) < 1;
    }
}


// Alternative solution using BigDecimal
import java.math.BigDecimal;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        BigDecimal bd1 = new BigDecimal("" + num1);
        BigDecimal bd2 = new BigDecimal("" + num2);
        double rd1 = bd1.setScale(3, BigDecimal.ROUND_DOWN).doubleValue();
        double rd2 = bd2.setScale(3, BigDecimal.ROUND_DOWN).doubleValue();
        return rd1 == rd2;
    }
}