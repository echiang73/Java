// Basic solution using try catch
import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner input = new Scanner(System.in);
        int sum=0;
        long avg = 0;
        int count=0;

        while (true) {
            String str = input.nextLine();
            try{
                int num = Integer.parseInt(str);
                sum += num;
                count++;
            } catch (NumberFormatException e) {
                break;
            }
        }
        avg = Math.round((double)sum/count);
        System.out.println("SUM = " + sum + " AVG = " + avg);
        input.close();
    }
}


// Alternative solution using hasNextInt()
import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        long avg = 0;
        int count = 0;

        while (input.hasNextInt()) {
            sum += input.nextInt();
            count++;
        }
        avg = Math.round((double)sum/count);
        System.out.println("SUM = " + sum + " AVG = " + avg);
        input.close();
    }
}