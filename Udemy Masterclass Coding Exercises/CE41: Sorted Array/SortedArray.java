// Basic solution using nested loops to sort array (bubble sort, O(n^2))
import java.util.Scanner;
import java.util.Arrays;
 
public class SortedArray {
    public static int[]getIntegers (int size) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        return array;
    }
 
    public static int[] sortIntegers(int[] array) {
        int len = array.length;
        int[] copyArray = Arrays.copyOf(array, len);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-1 - i; j++) {
                if (copyArray[j] < copyArray[j + 1]) {
                    int temp = copyArray[j];
                    copyArray[j] = copyArray[j + 1];
                    copyArray[j + 1] = temp;
                }
            }
        }
        return copyArray;
    }
 
    public static void printArray (int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
}


// Alternative and advanced solution using stream and Collection to reverseOrder and mapToInt
import java.util.*; // Scanner, Arrays, List, ArrayList
import java.util.stream.*; // Collectors, IntStream
 
public class SortedArray {
    public static int[]getIntegers (int size) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        return array;
    }
 
    public static int[] sortIntegers(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
 
    public static void printArray (int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
}


/* sortIntegers() method:  there are several approaches for this sorting method.  Each method is extracted out of
the solution and listed below for ease of comparison.  Note some of the method will require importing modules, i.e. 
import java.util.*; // Scanner, Arrays, List, ArrayList
import java.util.stream.*; // Collectors, IntStream
*/

    // Basic method using nested loops to sort array (bubble sort, O(n^2))...shown in above solution
    public static int[] sortIntegers(int[] array) {
        int len = array.length;
        int[] copyArray = Arrays.copyOf(array, len);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-1 - i; j++) {
                if (copyArray[j] < copyArray[j + 1]) {
                    int temp = copyArray[j];
                    copyArray[j] = copyArray[j + 1];
                    copyArray[j + 1] = temp;
                }
            }
        }
        return copyArray;
    }

    // Alternative method using flag with nested loops (bubble sort)
    public static int[] sortIntegers(int[] arr){
        int[] copyArray = Arrays.copyOf(arr, arr.length);
        boolean isSorting = true;

        while (isSorting){
            isSorting = false;
            for(int i = 0; i < copyArray.length - 1; i++){
                if(copyArray[i] < copyArray[i + 1]){
                    int temp = copyArray[i];
                    copyArray[i] = copyArray[i + 1];
                    copyArray[i + 1] = temp;
                    isSorting = true;
                }
            }
        }
        return copyArray;
    }
    
    // Alternative method by sorting array, creating new empty array and fill in reverse order, O(n)
    public static int[] sortIntegers(int[] array){
        Arrays.sort(array);
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[array.length-1 -i];
        }
        return newArray;
    }
 
    // Alternative method by creating copyOf array, sorting, and reverse by flipping ends of elements using half length
    public static int[] sortIntegers(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);
        int len = copyArray.length - 1;
        for (int i = 0; i < len/2; i++) {
            int temp = copyArray[i];
            copyArray[i] = copyArray[len-i];
            copyArray[len-i] = temp;
        }
        return copyArray;
    }
    
    // Alternative method by creating clone array, sorting, and reverse by flipping ends of elements using half length
    public static int[] sortIntegers(int[] array) {
        int[] clone = array.clone();
        Arrays.sort(clone);
        int len = clone.length - 1;
        for (int i = 0; i < len/2; i++) {
            int temp = clone[i];
            clone[i] = clone[len-i];
            clone[len-i] = temp;
        }
        return clone;
    }
    
    
    // Alternative method using IntStream and Collection to reverseOrder
    public static int[] sortIntegers(int[] array) {
        // Create List with values from int array using IntStream
        List<Integer> list = new ArrayList<>(IntStream.of(array).boxed().collect(Collectors.toList()));
        
        // Reverse and sort using Collections
        Collections.sort(list, Collections.reverseOrder());
        
        // Create new int array and insert List values
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = list.get(i);
        }
        return newArray;
    }
    
    // Alternative method using stream and Collection to reverseOrder
    public static int[] sortIntegers(int[] array) {
        // Create List with values from int array
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        
        // Reverse and sort using Collections
        Collections.sort(list, Collections.reverseOrder());
        
        // Create new int array and insert List values
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = list.get(i);
        }
        return newArray;
    }
    
    // Alternative method using stream and Collection to reverseOrder and mapToInt...shown in above solution
    public static int[] sortIntegers(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // Alternative method using stream and Collection to reverseOrder and mapToInt as single line return statement
    public static int[] sortIntegers(int[] array) {
        return Arrays.stream(array).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }