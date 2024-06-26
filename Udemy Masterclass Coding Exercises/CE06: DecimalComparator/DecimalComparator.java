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


// Alternative solution using BigDecimal and Round DOWN toward 0
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


// Alternative solution using BigDecimal as single-line return statement
import java.math.BigDecimal;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces (double num1, double num2) {
        return new BigDecimal("" + num1).setScale(3, BigDecimal.ROUND_DOWN).doubleValue() == new BigDecimal("" + num2).setScale(3, BigDecimal.ROUND_DOWN).doubleValue();
    }
}


// Alternative solution using BigDecimal with .equals()
import java.math.BigDecimal;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces (double num1, double num2) {
        BigDecimal bd1 = new BigDecimal("" + num1).setScale(3, BigDecimal.ROUND_DOWN);
        BigDecimal bd2 = new BigDecimal("" + num2).setScale(3, BigDecimal.ROUND_DOWN); 
        return bd1.toString().equals(bd2.toString());
    }
}


// Alternative solution using BigDecimal with .equals() as single-line return statement
import java.math.BigDecimal;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces (double num1, double num2) {
        return new BigDecimal("" + num1).setScale(3, BigDecimal.ROUND_DOWN).toString().equals(new BigDecimal("" + num2).setScale(3, BigDecimal.ROUND_DOWN).toString());
    }
}


// Alternative solution using DecimalFormat with ternary operators for FLOOR and CEILING
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        DecimalFormat df1 = new DecimalFormat("###.###");
        DecimalFormat df2 = new DecimalFormat("###.###");
        df1.setRoundingMode(num1 > 0 ? RoundingMode.FLOOR : RoundingMode.CEILING);
        df2.setRoundingMode(num2 > 0 ? RoundingMode.FLOOR : RoundingMode.CEILING);
        return df1.format(num1).equals(df2.format(num2));
    }
}


// Alternative solution using DecimalFormat and Round DOWN toward 0
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        DecimalFormat df1 = new DecimalFormat("###.###");
        DecimalFormat df2 = new DecimalFormat("###.###");
        df1.setRoundingMode(RoundingMode.DOWN);
        df2.setRoundingMode(RoundingMode.DOWN);
        return df1.format(num1).equals(df2.format(num2));
    }
}


// Alternative solution using String manipulation with substring
public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        String str1 = "" + num1;
        String str2 = "" + num2;
        int decimalIndex1 = str1.indexOf(".");
        int decimalIndex2 = str2.indexOf(".");
        String sub1 = str1.substring(0, decimalIndex1 + Math.min(str1.length()-decimalIndex1, 4));
        String sub2 = str2.substring(0, decimalIndex2 + Math.min(str2.length()-decimalIndex2, 4));
        return sub1.equals(sub2);
    }
}


// Alternative solution using String manipulation with loop to compare substring
public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        String str1 = "" + num1;
        String str2 = "" + num2;
        int decimalIndex1 = str1.indexOf(".");
        int decimalIndex2 = str2.indexOf(".");
        int stop = Math.min(decimalIndex1 + Math.min(str1.length()-decimalIndex1, 4), decimalIndex2 + Math.min(str2.length()-decimalIndex2, 4));
        for (int i = 0; i < stop; i++) {
            if (!str1.substring(i, i+1).equals(str2.substring(i, i+1))) {
                return false;
            }
        }
        return true;
    }
}


// Alternative solution using String manipulation with loop to compare charAt
public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        String str1 = "" + num1;
        String str2 = "" + num2;
        int decimalIndex1 = str1.indexOf(".");
        int decimalIndex2 = str2.indexOf(".");
        int stop = Math.min(decimalIndex1 + Math.min(str1.length()-decimalIndex1, 4), decimalIndex2 + Math.min(str2.length()-decimalIndex2, 4));
        for (int i = 0; i < stop; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}