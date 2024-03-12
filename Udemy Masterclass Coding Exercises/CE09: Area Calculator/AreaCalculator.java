// Basic solution
public class AreaCalculator {
    public static double area(double radius) {
        if (radius < 0) {
            return -1;
        }
        return Math.PI * radius * radius;
    }
 
    public static double area(double width, double height) {
        if (width < 0 || height < 0) {
            return -1;
        }
        return width * height;
    }
}


// Alternative solution using ternary operator
public class AreaCalculator {
    public static double area(double radius) {
        return radius < 0 ? -1 : Math.PI * radius * radius;
    }
 
    public static double area(double width, double height) {
        return width < 0 || height < 0 ? -1 : width * height;
    }
}