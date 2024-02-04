// Basic solution
public class BarkingDog {
    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (!barking || hourOfDay < 0 || hourOfDay > 24) {
             return false;
        }
        return (hourOfDay >= 0 && hourOfDay < 8) || hourOfDay == 23;
     }
}


// Alternative solution using shorthand
public class BarkingDog {
    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        return barking && hourOfDay >= 0 && (hourOfDay < 8 || hourOfDay == 23);
    }
}
