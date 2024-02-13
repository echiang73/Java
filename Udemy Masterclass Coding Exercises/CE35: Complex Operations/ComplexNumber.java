// Basic solution (verbose)
public class ComplexNumber {
    private double real;
    private double imaginary;
    
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public double getReal(){
        return real;
    }
    
    public double getImaginary(){
        return imaginary;
    }
    
    public void add(double real, double imaginary){
        this.real += real;
        this.imaginary += imaginary;
    }
    
    public void add(ComplexNumber complexNumber){
        real += complexNumber.real;
        imaginary += complexNumber.imaginary;
    }
    
    public void subtract(double real, double imaginary){
        this.real -= real;
        this.imaginary -= imaginary;
    }
    
    public void subtract(ComplexNumber complexNumber){
        real -= complexNumber.real;
        imaginary -= complexNumber.imaginary;
    }
}


// Alternative solution (preferred) with best practices for overloaded methods
public class ComplexNumber {
    private double real;
    private double imaginary;
    
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public double getReal(){
        return real;
    }
    
    public double getImaginary(){
        return imaginary;
    }
    
    public void add(double real, double imaginary){
        this.real += real;
        this.imaginary += imaginary;
    }
    
    public void add(ComplexNumber complexNumber){
        add(complexNumber.real, complexNumber.imaginary);
    }
    
    public void subtract(double real, double imaginary){
        this.real -= real;
        this.imaginary -= imaginary;
    }
    
    public void subtract(ComplexNumber complexNumber){
        subtract(complexNumber.real, complexNumber.imaginary);
    }
}