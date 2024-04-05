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