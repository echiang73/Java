// Basic solution
import java.util.ArrayList;
 
public class Customer {
    private String name;
    private ArrayList<Double> transactions;
 
    public Customer(String name, double initialTransaction) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(initialTransaction);
    }
 
    public String getName() {
        return name;
    }
 
    public ArrayList<Double> getTransactions() {
        return transactions;
    }
 
    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }
}


// Alternative solution initialize transactions on one line
import java.util.*; // ArrayList, Arrays

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
 
    public Customer(String name, double initialTransaction) {
        this.name = name;
        transactions = new ArrayList<Double>(Arrays.asList(initialTransaction));
    }
 
    public String getName() {
        return name;
    }
 
    public ArrayList<Double> getTransactions() {
        return transactions;
    }
 
    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }
}