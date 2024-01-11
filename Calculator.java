import java.util.*;

public class Calculator {

    public static double Addition(double... operands) {
        return Arrays.stream(operands).sum();
    }

    public static double Subtraction(double... operands) {
        double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result -= operands[i];
        }
        return result;
    }

    public static double Multiplication(double... operands) {
        double result = 1;
        for (double operand : operands) {
            result *= operand;
        }
        return result;
    }

    public static double Division(double... operands) {
        double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            if (operands[i] == 0) {
                System.out.println("Error: Division by zero is not allowed.");
                return Double.NaN;
            }
            result /= operands[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("0. Exit");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.println("Enter the number of operands:");
                int numOperands = scanner.nextInt();

                double[] operands = new double[numOperands];
                for (int i = 0; i < numOperands; i++) {
                    System.out.println("Enter Operand " + (i + 1) + ":");
                    operands[i] = scanner.nextDouble();
                }

                switch (choice) {
                    case 1:
                        System.out.println("Result: " + Addition(operands));
                        break;
                    case 2:
                        System.out.println("Result: " + Subtraction(operands));
                        break;
                    case 3:
                        System.out.println("Result: " + Multiplication(operands));
                        break;
                    case 4:
                        System.out.println("Result: " + Division(operands));
                        break;
                }
            } else if (choice != 0) {
                System.out.println("Invalid choice. Please choose a valid operation.");
            }

        } while (choice != 0);
        scanner.close();
        System.out.println("Exiting the Calculator.");
    }
}
