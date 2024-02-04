// Basic solution
public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        long hours = minutes/60;
        long days = hours/24;
        long years = days/365;
        long remainingDays = days%365;
 
        if (minutes < 0) {
             System.out.println("Invalid Value");
        } else {
            System.out.println(minutes + " min = " + years + " y and " + remainingDays + " d");
        }
    }
}


// Alternative solution with fewer variables
public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        long years = minutes/(60*24*365);
        long remainingDays = (minutes/(60*24)) % 365;
 
        if (minutes < 0) {
             System.out.println("Invalid Value");
        } else {
            System.out.println(minutes + " min = " + years + " y and " + remainingDays + " d");
        }
    }
}


// Alternative solution using ternary operator
public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        long hours = minutes/60;
        long days = hours/24;
        long years = days/365;
        long remainingDays = days%365;
 
        System.out.println(minutes < 0 ? "Invalid Value" : (minutes + " min = " + years + " y and " + remainingDays + " d"));
    }
}


// Alternative solution using ternary operator without variables (not recommended as it impacts readability 
// and ability to create breakpoints and debug calculated values)
public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        System.out.println(minutes < 0 ? "Invalid Value" : (minutes + " min = " + (minutes)/(60*24*365) + " y and " + (minutes/(24*60)%365) + " d"));
    }
}