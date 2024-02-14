// Basic solution
public class Circle {
    private double radius;

    public Circle(double radius) {
        if (radius < 0) {
            this.radius = 0;
        } else {
            this.radius = radius;
        }
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getArea() {
        return radius*radius*Math.PI;
    }
}


// Alternative solution using ternary operator
public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = (radius < 0) ? 0 : radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getArea() {
        return radius*radius*Math.PI;
    }
}
