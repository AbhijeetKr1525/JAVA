import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0, count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (true) {
            System.out.print("Enter a number (0 to stop): ");
            int num = sc.nextInt();

            if (num == 0) {
                break;
            }

            sum += num;
            count++;

            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Sum = " + sum);
            System.out.println("Average = " + average);
            System.out.println("Maximum = " + max);
            System.out.println("Minimum = " + min);
        } else {
            System.out.println("No numbers entered.");
        }
    }
}
