// Basic solution
public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        if (temperature < 25 ||  temperature > 45) {
            return false;
        }
        
        if (!summer && temperature <= 35) {
            return true;
        } else if (summer && temperature <= 45) {
            return true;
        }
        return false;
    }
}


// Alternative solution combining conditions
public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        if ((summer && temperature >= 25 && temperature <= 45) || (temperature >= 25 && temperature <= 35)) {
            return true;
        }
        return false;
    }
}


// Alternative solution defining valid "lower" and "upper" temperature with ternary operator
public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        int lowerTemp = 25;
        int upperTemp = summer ? 45 : 35;
        return temperature >= lowerTemp && temperature <= upperTemp;
    }
}


// Alternative solution as single line return statement with ternary operator
public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature) {
        return temperature >= 25 && temperature <= (summer ? 45 : 35);
    }
}