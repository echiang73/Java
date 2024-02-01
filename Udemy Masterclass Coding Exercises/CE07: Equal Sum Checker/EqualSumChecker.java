// Basic solution
public class EqualSumChecker {
    public static boolean hasEqualSum(int num1, int num2, int num3){
        if (num1 + num2 == num3) {
            return true;
        }
        return false;
    }
}


// Alternative solution using shorthand
public class EqualSumChecker {
    public static boolean hasEqualSum(int num1, int num2, int num3){
        return num1 + num2 == num3;
    }
}