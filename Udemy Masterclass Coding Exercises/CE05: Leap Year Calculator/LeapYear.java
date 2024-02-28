// Basic solution
public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        
        if (year%4 == 0) {
            if (year%100 == 0) {
                if (year%400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}


// Alternative solution without if/else
public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        return year%4 == 0 && year%100 != 0 || year%400 == 0;
    }
}


// Alternative solution using single-line return statement
public class LeapYear {
    public static boolean isLeapYear(int year) {
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
}
