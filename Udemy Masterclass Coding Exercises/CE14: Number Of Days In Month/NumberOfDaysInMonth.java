// Basic solution using traditional switch case
public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            return year%4 == 0 && year%100 != 0 || year%400 == 0;
        }
        return false;
    }
 
    public static int getDaysInMonth(int month, int year) {
        if (year >= 1 && year <= 9999 && month >= 1 && month <= 12) {
            switch (month) {
                case 2: 
                    return isLeapYear(year) ? 29 : 28;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                default:
                    return -1;
            }
        }
        return -1;
    }
}


// Alternative solution for conciseness, using default to return 31
public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
 
    public static int getDaysInMonth(int month, int year) {
        if (year >= 1 && year <= 9999 && month >= 1 && month <= 12) {
            switch (month) {
                case 2: 
                    return isLeapYear(year) ? 29 : 28;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 31;
            }
        }
        return -1;
    }
}


// Alternative solution for using enhanced switch with yield
public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
 
    public static int getDaysInMonth(int month, int year) {
        if (year >= 1 && year <= 9999 && month >= 1 && month <= 12) {
            return switch (month) {
                case 2: 
                    yield isLeapYear(year) ? 29 : 28;
                case 4:
                case 6:
                case 9:
                case 11:
                    yield 30;
                default:
                    yield 31;
            };
        }
        return -1;
    }
}


// Alternative solution for using enhanced switch with commas in multiple cases
public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
 
    public static int getDaysInMonth(int month, int year) {
        if (year >= 1 && year <= 9999 && month >= 1 && month <= 12) {
            return switch (month) {
                case 2: 
                    yield isLeapYear(year) ? 29 : 28;
                case 4, 6, 9, 11:
                    yield 30;
                default:
                    yield 31;
            };
        }
        return -1;
    }
}


// Alternative solution using enhanced switch case with arrow function
public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
 
    public static int getDaysInMonth(int month, int year) {
        if (year >= 1 && year <= 9999 && month >= 1 && month <= 12) {
            return switch (month) {
                case 2 -> isLeapYear(year) ? 29 : 28;
                case 4, 6, 9, 11 -> 30;
                default -> 31;
            };
        }
        return -1;
    }
}


// Alternative solution using ternary operator with nested enhanced switch case
public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
 
    public static int getDaysInMonth(int month, int year) {
        return (year < 1 || year > 9999 || month < 1 || month > 12) ? -1 :
            switch (month) {
                case 2 -> isLeapYear(year) ? 29 : 28;
                case 4, 6, 9, 11 -> 30;
                default -> 31;
            };
    }
}


// Alternative solution using modulo, since 31 days for odd months 1, 3, 5, 7 unless after 7 then even months 8, 10, 12.
// Use 31 - (0 or 1), to get 31 or 30 days. Thus, ((month - 1) % 7) % 2 will evaluate 0 or 1 to subtract from 31.
public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
    
    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        }
        
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return 31 - ((month - 1) % 7) % 2;
    }
}


// Alternative solution using modulo with nested ternary operators to subtract 0, 1, 2, 3 days from 31
public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
    
    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        }
        // return month == 2 ? (isLeapYear(year) ? 29 : 28) : 31 - ((month - 1) % 7) % 2;
        return 31 - (((month - 1) % 7) % 2) - (month == 2 ? (isLeapYear(year) ? 1 : 2) : 0);
    }
}


// Alternative solution using imported Calendar
import java.util.Calendar;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
    
    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        // cal.set(Calendar.YEAR, year);
        // cal.set(Calendar.MONTH, month - 1);
        cal.set(year, month - 1, 1); // YEAR, MONTH, DATE as alternative .set()
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}


// Alternative solution using imported YearMonth
import java.time.YearMonth;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
    
    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        }
        return YearMonth.of(year, month).lengthOfMonth();
    }
}


// Alternative solution using imported YearMonth with ternary operator
import java.time.YearMonth;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        return year >= 1 && year <= 9999 && (year%4 == 0 && year%100 != 0 || year%400 == 0);
    }
    
    public static int getDaysInMonth(int month, int year) {
        return (month < 1 || month > 12 || year < 1 || year > 9999) ? -1 : YearMonth.of(year, month).lengthOfMonth();
    }
}