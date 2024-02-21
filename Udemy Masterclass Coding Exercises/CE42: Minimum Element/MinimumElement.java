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