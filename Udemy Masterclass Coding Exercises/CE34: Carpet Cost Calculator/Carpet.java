// Basic solution
public class Carpet {
    private double cost;
 
    public Carpet(double cost) {
        if (cost < 0) {
            this.cost = 0;
        } else {
            this.cost = cost;
        }
    }
    
    public double getCost() {
        return cost;
    }
}


// Alternative solution using ternary operator
public class Carpet {
    private double cost;
 
    public Carpet(double cost) {
        this.cost = cost < 0  ? 0 : cost;
    }
    
    public double getCost() {
        return cost;
    }
}