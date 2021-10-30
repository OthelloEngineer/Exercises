import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_test {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Set a range");
            System.out.print("range lowerbound: ");
            int lowerbound = scanner.nextInt();
            System.out.print("range upperbound: ");
            int upperbound = scanner.nextInt();
            if (upperbound < lowerbound)
                Exceptions.boundControl(lowerbound, upperbound);
            System.out.println("Now pick a number within the range");
            int number = scanner.nextInt();
            if (number <= lowerbound || number >= upperbound)
                Exceptions.outOfRange(lowerbound, upperbound, number);
        } catch (InputMismatchException e) {
            System.out.println("please select an integer");
        } catch (Exception e1) {
            System.out.println(e1 + " error occurred");
        }
    }
}


