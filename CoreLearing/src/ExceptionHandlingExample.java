/**
 * Exception Handling Example
 * Demonstrates: try, catch, throw, throws, and finally
 */

public class ExceptionHandlingExample {

    // Example 1: Method that throws exception
    public static void divideNumbers(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        System.out.println("Result: " + (a / b));
    }

    // Example 2: Method that throws custom exception
    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120!");
        }
        System.out.println("Valid age: " + age);
    }

    // Example 3: Method with try-catch-finally
    public static void readFile() {
        String filename = "test.txt";
        try {
            System.out.println("Attempting to read file: " + filename);
            // Simulate file reading
            throw new java.io.FileNotFoundException("File not found!");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block: Cleanup code executed");
        }
    }

    // Example 4: Multiple catch blocks
    public static void processData(String data) {
        try {
            int number = Integer.parseInt(data);
            int result = 100 / number;
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format - " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: Arithmetic error - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Unexpected error - " + e.getMessage());
        }
    }

    // Example 5: Nested try-catch
    public static void nestedExceptionHandling() {
        try {
            try {
                int[] array = {1, 2, 3};
                System.out.println(array[5]); // Will throw ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: Array index out of bounds!");
                throw new RuntimeException("Rethrowing as RuntimeException");
            }
        } catch (RuntimeException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
    }

    // Example 6: Try-catch-finally with return
    public static String tryFinallyReturn() {
        try {
            System.out.println("In try block");
            return "Try block return";
        } finally {
            System.out.println("Finally block always executes (even with return)");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exception Handling Examples ===\n");

        // Example 1: Using throws keyword
        System.out.println("--- Example 1: Division with throws ---");
        try {
            divideNumbers(10, 2);
            divideNumbers(10, 0); // Will throw exception
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n--- Example 2: Custom validation with throw ---");
        try {
            validateAge(25);
            validateAge(150); // Will throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n--- Example 3: Try-Catch-Finally ---");
        readFile();

        System.out.println("\n--- Example 4: Multiple catch blocks ---");
        processData("abc");   // NumberFormatException
        processData("0");     // ArithmeticException
        processData("25");    // Success

        System.out.println("\n--- Example 5: Nested try-catch ---");
        nestedExceptionHandling();

        System.out.println("\n--- Example 6: Try-Finally with return ---");
        String result = tryFinallyReturn();
        System.out.println("Returned: " + result);
    }
}
