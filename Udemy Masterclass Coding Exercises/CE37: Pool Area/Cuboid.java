// Basic solution (verbose)
public class Cuboid extends Rectangle {
    private double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
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
public class Cuboid extends Rectangle {
    private double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = (height < 0) ? 0 : height;
    }
   
    public double getHeight() {
        return height;
    }
 
    public double getVolume() {
        return height*getArea();
    }
}