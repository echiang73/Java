// Basic solution
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = (age < 0 || age > 100) ? 0 : age;
    }   
     
    public boolean isTeen() {
        return age > 12 && age < 20;
    }
    
    public String getFullName() {
        if (firstName.isEmpty() && !lastName.isEmpty()) {
            return lastName;
        } else if (!firstName.isEmpty() && lastName.isEmpty()) {
            return firstName;
        } else if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        }
        return firstName + " " + lastName;
    }
}


// Alternative getFullName() method using String.format()
    public String getFullName() {
        if (firstName.isEmpty() && !lastName.isEmpty()) {
            return lastName;
        } else if (!firstName.isEmpty() && lastName.isEmpty()) {
            return firstName;
        } else if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        }
        return String.format("%s %s", firstName, lastName);
    }


// Alternative getFullName() method using trim()
    public String getFullName() {
         return  (firstName + " " + lastName).trim();
    }
