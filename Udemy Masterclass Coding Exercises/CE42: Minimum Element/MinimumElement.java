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
            array[i] = scanner.nextInt();   
        }
        return array;
    }
    
    private static int findMin(int[] array) {
        Arrays.sort(array);
        return array[0];
    }
}