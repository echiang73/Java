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


// Alternative solution using getSimpleName
public class Holden extends Car {
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }
    
    @Override
    public String startEngine() {
        return ("The engine of the " + getClass().getSimpleName() + " is starting");
    }
    
    @Override
    public String accelerate() {
        return ("The " + getClass().getSimpleName() + " is accelerating");
    }
    
    @Override
    public String brake() {
        return ("The " + getClass().getSimpleName() + " is breaking.");
    }
}


// Alternative solution without unnecessary overriding methods (works on IDE but won't pass checker since not polymorphism)
public class Holden extends Car {
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }
}