// Basic solution (hard coding Class name)
public class Ford extends Car {
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }
    
    @Override
    public String startEngine() {
        return ("The engine of the Ford is starting");
    }
    
    @Override
    public String accelerate() {
        return ("The Ford is accelerating");
    }
    
    @Override
    public String brake() {
        return ("The Ford is breaking.");
    }
}