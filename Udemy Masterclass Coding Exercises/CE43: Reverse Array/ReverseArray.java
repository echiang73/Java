// Basic solution, most performant
import java.util.Arrays;

public class ReverseArray {
    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));
        int length = arr.length;
        for (int i = 0; i < length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[length-1 - i];
            arr[length-1 - i] = temp;
        }
        System.out.println("Reversed array = " + Arrays.toString(arr));
    }
}


// Alternative solution using copyOf, not performant by doubling memory
import java.util.Arrays;

public class ReverseArray {
    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = copyArr[arr.length-1 - i];
        }
        System.out.println("Reversed array = " + Arrays.toString(arr));
    }
}


// Alternative solution using clone, not performant by doubling memory
import java.util.Arrays;

public class ReverseArray {
    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));
        int[] cloneArr = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cloneArr[arr.length-1 - i];
        }
        System.out.println("Reversed array = " + Arrays.toString(arr));
    }
}