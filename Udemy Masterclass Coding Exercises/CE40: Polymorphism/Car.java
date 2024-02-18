// Basic solution (hard coding Class name)
public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;
    
    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        engine = true;
        wheels = 4;
    }
    
    public String startEngine() {
        return ("The engine of the Car is starting");
    }
    
    public String accelerate() {
        return ("The Car is accelerating");
    }
    
    public String brake() {
        return ("The Car is breaking.");
    }
    
    public int getCylinders() {
        return cylinders;
    }
    
    public String getName() {
        return name;
    }
}


// Alternative solution using getSimpleName
public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;
    
    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        engine = true;
        wheels = 4;
    }
    
    public String startEngine() {
        return ("The engine of the " + getClass().getSimpleName() + " is starting");
    }
    
    public String accelerate() {
        return ("The " + getClass().getSimpleName() + " is accelerating");
    }
    
    public String brake() {
        return ("The " + getClass().getSimpleName() + " is breaking.");
    }
    
    public int getCylinders() {
        return cylinders;
    }
    
    public String getName() {
        return name;
    }
}