// Basic solution
public class AreaCalculator {
    public static double area(double radius) {
        if (radius < 0) {
            return -1;
        }
        return Math.PI * radius * radius;
    }
 
    public static double area(double x, double y) {
        if (x < 0 || y < 0) {
            return -1;
        }
        return x * y;
    }
}


// Alternative solution using ternary operator
public class AreaCalculator {
    public static double area(double radius) {
        return (radius < 0) ? -1 : Math.PI * radius * radius;
    }
 
    public static double area(double x, double y) {
        return (x < 0 || y < 0) ? -1 : x * y;
    }
}