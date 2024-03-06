// Basic solution
public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour) {
        long conversion = Math.round(kilometersPerHour / 1.609);
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            return conversion;
        }
    }
    
    public static void printConversion(double kilometersPerHour ) {
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }
}


// Alternative solution using ternary operators
public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour) {
        long conversion = Math.round(kilometersPerHour / 1.609);
        return kilometersPerHour < 0 ? -1 : conversion;
    }
    
    public static void printConversion(double kilometersPerHour ) {
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        System.out.println(kilometersPerHour < 0 ? "Invalid Value" : (kilometersPerHour + " km/h = " + milesPerHour + " mi/h"));
    }
}


// Alternative solution using ternary operators as single-line code
public class SpeedConverter {
    public static long toMilesPerHour (double kilometersPerHour) {
        return kilometersPerHour < 0 ? -1 : Math.round(kilometersPerHour / 1.609);
    }
    
    public static void printConversion (double kilometersPerHour ) {
        System.out.println(kilometersPerHour < 0 ? "Invalid Value" : (kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h"));
    }
}
