// Basic solution (verbose)
public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getVolume() {
        return height*getArea();
    }
}


// Alternative solution using ternary operator
public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = (height < 0) ? 0 : height;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getVolume() {
        return height*getArea();
    }
}