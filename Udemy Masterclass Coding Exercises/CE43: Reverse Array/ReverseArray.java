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


// Alternative (crazy) solution using IntStream and Collection to reverse (printing new object)
import java.util.*; // Arrays, List, ArrayList
import java.util.stream.*; // Collectors, IntStream

public class ReverseArray {
    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));

        // Create List with values from int array using IntStream
        List<Integer> list = new ArrayList<>(IntStream.of(arr).boxed().collect(Collectors.toList()));
        
        // Reverse using Collections
        Collections.reverse(list);
        
        // Create new int array and insert List values
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = list.get(i);
        }
        
        System.out.println("Reversed array = " + Arrays.toString(newArr));
    }
}


// Alternative (crazy) solution using stream and Collection to reverse (printing new object)
import java.util.*; // Arrays, List, ArrayList
import java.util.stream.*; // Collectors, IntStream

public class ReverseArray {
    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));

        // Create List with values from int array using stream
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        // Reverse using Collections
        Collections.reverse(list);
        
        // Create new int array and insert List values
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = list.get(i);
        }
        
        System.out.println("Reversed array = " + Arrays.toString(newArr));
    }
}


// Alternative (crazy) solution using stream and Collection to reverse and mapToInt (printing new object)
import java.util.*; // Arrays, List, ArrayList
import java.util.stream.*; // Collectors, IntStream

public class ReverseArray {
    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));

        // Create List with values from int array using stream
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        // Reverse using Collections
        Collections.reverse(list);
        
        // Create new int array and insert List values
        int[] newArr = list.stream().mapToInt(Integer::intValue).toArray();
        
        System.out.println("Reversed array = " + Arrays.toString(newArr));
    }
}


// Alternative (uber crazy) solution using StringBuilder and built-in reverse() (printing new object)
import java.util.Arrays;

public class ReverseArray {
    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));

        // Create SB and insert each int with space
        StringBuilder sb = new StringBuilder();
        for (int e : arr) {
            sb.append("" + e + " ");
        }
        
        // Reverse sb and insert as String array
        String[] revStrArr = sb.reverse().toString().trim().split(" ");
        
        // Reverse each element of the String array
        for(int i = 0; i < revStrArr.length; i++) {
            String tempStr = new StringBuilder(revStrArr[i]).reverse().toString();
            revStrArr[i] = tempStr;
        }
        
        System.out.println("Reversed array = " + Arrays.toString(revStrArr));
    }
}


// Alternative (uber crazy) solution using nested StringBuilder and built-in reverse() (printing new object)
import java.util.Arrays;

public class ReverseArray {
    private static void reverse(int[] arr) {
        System.out.println("Array = " + Arrays.toString(arr));

        // Create SB and insert each int with space
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            // Reverse each element of the String array before appending to sb
            String tempIntStr = new StringBuilder("" + arr[i] + " ").reverse().toString();
            sb.append(tempIntStr);
        }
        
        // Reverse sb and insert as String array
        String[] revStrArr = sb.reverse().toString().trim().split(" ");
        
        System.out.println("Reversed array = " + Arrays.toString(revStrArr));
    }
}
