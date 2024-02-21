// Basic solution
import java.util.Scanner;
import java.util.Arrays;
 
public class MinimumElement {
    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        return scanner.nextInt();
    }
    
    private static int[] readElements(int numElements) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            try {
                array[i] = scanner.nextInt();   
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }
        return array;
    }
    
    private static int findMin(int[] array) {
        Arrays.sort(array);
        return array[0];
    }
}


// Alternative solution, concise and using stream().min()
import java.util.Scanner;
import java.util.Arrays;
 
public class MinimumElement {
    private static int readInteger() {
        return new Scanner(System.in).nextInt();
    }
    
    private static int[] readElements(int numElements) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            array[i] = scanner.nextInt();   
        }
        return array;
    }
    
    private static int findMin(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }
}


/*
The scenario is:
1. readInteger() is called.
2. The number returned by readInteger() is then used to call readElements().
3. The array returned from readElements() is used to call findMin().
4. findMin() returns the minimum number.
[Do not try and implement this. It is to give you an idea of how the methods will be used]
TIP: Assume that the user will only enter numbers, never letters.

Here is the pseudocode that implements what the instruction tells you not to try, but we'll do it for fun.
1. I put in a main() method so that you can try it on your IDE and call readInteger() for step 1.
2. Calling readInteger() will ask the user to input an integer for the number of elements to create in the array, and then call readElements() in step 2.
3. Calling readElements() will create an array and loop through a nested while(true) loop that checks to make sure only numbers are entered, or else it prompts the user for a different input.  Once all elements have been inputed, it will call findMin() in step 3.
4.  Calling findMin() will return the min value of the array, i.e. step 4, and return it to the main() method to print.
*/

import java.util.Scanner;
import java.util.Arrays;
 
public class MinimumElement {
    
    public static void main(String args[]) {
        System.out.println("The min of the input entered is: " + readInteger()); // step 1
    }
    
    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int[] array = readElements(scanner.nextInt()); // step 2
        int min = findMin(array); // step 3
        return min; // step 4
    }
    
    private static int[] readElements(int para) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[para];
        for (int i = 0; i < para; i++) {
            System.out.println("Please enter a number.");
            while (true) { // TIP: how to handle non-integer
                try {
                    array[i] = scanner.nextInt();  
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input, please enter a number.");
                }
                scanner.nextLine(); // consume new line
            }
        }
        return array;
    }
    
    private static int findMin(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }
}
