// Basic solution (hard coding Class name)
public class Holden extends Car {
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }
    
    @Override
    public String startEngine() {
        return ("The engine of the Holden is starting");
    }
    
    @Override
    public String accelerate() {
        return ("The Holden is accelerating");
    }
    
    @Override
    public String brake() {
        return ("The Holden is breaking.");
    }
}
