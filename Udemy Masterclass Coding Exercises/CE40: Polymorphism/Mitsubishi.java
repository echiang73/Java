// Basic solution (hard coding Class name)
public class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }
    
    @Override
    public String startEngine() {
        return ("The engine of the Mitsubishi is starting");
    }
    
    @Override
    public String accelerate() {
        return ("The Mitsubishi is accelerating");
    }
    
    @Override
    public String brake() {
        return ("The Mitsubishi is breaking.");
    }
}