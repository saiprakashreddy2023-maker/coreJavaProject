# Exception Handling in Java - Complete Guide for Beginners

## Table of Contents
1. [What are Exceptions?](#what-are-exceptions)
2. [Types of Exceptions](#types-of-exceptions)
3. [Try-Catch Block](#try-catch-block)
4. [Throw Keyword](#throw-keyword)
5. [Throws Keyword](#throws-keyword)
6. [Finally Block](#finally-block)
7. [Complete Example](#complete-example)
8. [Best Practices](#best-practices)

---

## What are Exceptions?

An **exception** is an event that occurs during program execution that disrupts the normal flow of the program.

### Real-World Example:
Imagine you're trying to open a door, but the key doesn't fit. That's an exception - something went wrong!

### In Programming:
- **Dividing by zero**: `10 / 0` → ArithmeticException
- **Accessing invalid array index**: `array[10]` when array has 5 elements → ArrayIndexOutOfBoundsException
- **File not found**: Trying to read a file that doesn't exist → FileNotFoundException

### What Happens Without Exception Handling?
```
Program encounters error → Program crashes → User sees nothing helpful
```

### What Happens With Exception Handling?
```
Program encounters error → Program catches it → Shows helpful message → Program continues
```

---

## Types of Exceptions

### 1. **Checked Exceptions** (Must be handled)
- Must be caught or declared in the method signature
- `IOException`, `FileNotFoundException`, `SQLException`
- Checked at **compile time**

### 2. **Unchecked Exceptions** (Optional to handle)
- Don't need to be caught or declared
- `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`
- Checked at **runtime**

### 3. **Error** (System-level problems)
- Not meant to be caught
- `StackOverflowError`, `OutOfMemoryError`

---

## Try-Catch Block

### What is Try-Catch?
A **try-catch block** allows you to:
1. Try to run risky code (in try block)
2. Catch and handle errors if they occur (in catch block)

### Basic Syntax:
```java
try {
    // Risky code that might throw an exception
    int result = 10 / 0;  // This will throw ArithmeticException
} catch (ArithmeticException e) {
    // Handle the exception
    System.out.println("Error: Cannot divide by zero!");
}
```

### Step-by-Step Explanation:

#### Step 1: The TRY Block
```java
try {
    int result = 10 / 0;  // Risky operation
    System.out.println(result);  // This line won't execute
}
```
- Code inside `try` block runs line by line
- When an exception occurs, execution jumps to `catch` block
- Remaining lines in `try` block are **skipped**

#### Step 2: The CATCH Block
```java
catch (ArithmeticException e) {  // e is the exception object
    System.out.println("Error: " + e.getMessage());  // Prints error message
}
```
- **Catches** the specific exception type
- `e` variable contains exception details
- You can access error message with `e.getMessage()`

### Real Example:
```java
public class DivisionExample {
    public static void main(String[] args) {
        System.out.println("Program starts");
        
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // Exception thrown here!
            System.out.println("Result: " + result);  // Skipped
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero! Error: " + e);
        }
        
        System.out.println("Program continues");
    }
}
```

**Output:**
```
Program starts
Cannot divide by zero! Error: java.lang.ArithmeticException: / by zero
Program continues
```

### Multiple Catch Blocks:
You can catch different exceptions with multiple catch blocks:

```java
try {
    int number = Integer.parseInt("abc");  // String to number conversion
    int result = 100 / number;
    System.out.println(result);
} catch (NumberFormatException e) {
    System.out.println("Error: Invalid number format!");
} catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero!");
} catch (Exception e) {  // Catches any other exception
    System.out.println("Error: Something went wrong!");
}
```

**How it works:**
1. If `Integer.parseInt("abc")` fails → `NumberFormatException` is caught
2. If division by zero happens → `ArithmeticException` is caught
3. If any other error occurs → `Exception` is caught

---

## Throw Keyword

### What is Throw?
The **throw** keyword allows you to **manually throw an exception** when something is invalid.

### When to Use Throw?
When you want to **reject invalid input** or **create custom errors**

### Syntax:
```java
throw new ExceptionType("Error message");
```

### Real Example: Age Validation
```java
public static void validateAge(int age) {
    if (age < 0 || age > 120) {
        throw new IllegalArgumentException("Age must be between 0 and 120!");
    }
    System.out.println("Valid age: " + age);
}
```

**How it works:**
- User enters age = 150
- Condition `age > 120` is true
- Exception is thrown: `IllegalArgumentException`
- Program stops at that point
- Error message is displayed

**Usage in main:**
```java
try {
    validateAge(25);   // Valid → prints "Valid age: 25"
    validateAge(150);  // Invalid → throws exception
} catch (IllegalArgumentException e) {
    System.out.println("Caught: " + e.getMessage());
}
```

**Output:**
```
Valid age: 25
Caught: Age must be between 0 and 120!
```

---

## Throws Keyword

### What is Throws?
The **throws** keyword indicates that a method **might throw an exception**, and the **caller** must handle it.

### When to Use Throws?
When a method doesn't handle the exception but wants to inform the caller about possible exceptions.

### Syntax:
```java
public static void methodName() throws ExceptionType {
    // Method body
}
```

### Real Example:
```java
// Method declares it might throw ArithmeticException
public static void divide(int a, int b) throws ArithmeticException {
    if (b == 0) {
        throw new ArithmeticException("Cannot divide by zero!");
    }
    System.out.println("Result: " + (a / b));
}

// Caller must handle the exception
public static void main(String[] args) {
    try {
        divide(10, 2);  // Works fine
        divide(10, 0);  // Throws exception
    } catch (ArithmeticException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
```

### Difference Between Throw and Throws:

| Throw | Throws |
|-------|--------|
| Throws an exception | Declares that exception might be thrown |
| Used inside method body | Used in method signature |
| `throw new Exception("msg")` | `throws ExceptionType` |
| Stops execution immediately | Just informs caller |

---

## Finally Block

### What is Finally?
The **finally** block contains code that **always executes**, whether an exception occurred or not.

### Use Finally For:
- Closing files
- Releasing resources
- Cleanup operations
- Code that must run no matter what

### Syntax:
```java
try {
    // Risky code
} catch (Exception e) {
    // Handle exception
} finally {
    // Always executes
}
```

### Real Example: File Reading
```java
public static void readFile() {
    try {
        System.out.println("Opening file...");
        throw new java.io.FileNotFoundException("File not found!");
        // Code below is skipped
        System.out.println("Reading file...");
    } catch (java.io.FileNotFoundException e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        System.out.println("Closing file... (ALWAYS EXECUTES)");
    }
}
```

**Output:**
```
Opening file...
Error: File not found!
Closing file... (ALWAYS EXECUTES)
```

### Finally with Return:
Even if try block returns, finally still executes!

```java
public static String example() {
    try {
        System.out.println("In try block");
        return "Try returns this";
    } finally {
        System.out.println("Finally executes (even with return)");
    }
}

// Output:
// In try block
// Finally executes (even with return)
// Return value: Try returns this
```

---

## Complete Example

### Program: Bank Withdrawal System

```java
public class BankAccount {
    private double balance = 1000;
    
    // Throws keyword - indicates method might throw exception
    public void withdraw(double amount) throws IllegalArgumentException {
        
        // Throw keyword - manually throw exception if invalid
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        
        balance -= amount;
        System.out.println("Withdrawal successful! New balance: " + balance);
    }
    
    public double getBalance() {
        return balance;
    }
}

public class BankMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        
        // Try-catch-finally block
        try {
            System.out.println("Current balance: " + account.getBalance());
            
            account.withdraw(500);      // Success
            account.withdraw(700);      // Insufficient balance - exception thrown
            
        } catch (IllegalArgumentException e) {
            // Catch the exception
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Always execute - cleanup
            System.out.println("Final balance: " + account.getBalance());
        }
    }
}
```

**Output:**
```
Current balance: 1000.0
Withdrawal successful! New balance: 500.0
Error: Insufficient balance!
Final balance: 500.0
```

---

## Best Practices

### ✅ DO:

1. **Catch Specific Exceptions**
   ```java
   // Good
   try {
       // code
   } catch (ArithmeticException e) {
       // handle
   }
   ```

2. **Provide Meaningful Error Messages**
   ```java
   throw new IllegalArgumentException("Age must be between 0 and 120!");
   ```

3. **Clean Up Resources in Finally**
   ```java
   finally {
       file.close();  // Always close files
   }
   ```

4. **Use Throws for Checked Exceptions**
   ```java
   public void readFile(String filename) throws IOException {
       // method body
   }
   ```

### ❌ DON'T:

1. **Don't Catch Everything**
   ```java
   // Bad
   try {
       // code
   } catch (Exception e) {  // Too broad!
       // handle
   }
   ```

2. **Don't Ignore Exceptions**
   ```java
   // Bad
   try {
       // code
   } catch (Exception e) {
       // Doing nothing
   }
   ```

3. **Don't Use Exceptions for Flow Control**
   ```java
   // Bad - exceptions are expensive
   try {
       int value = Integer.parseInt(input);
   } catch (NumberFormatException e) {
       // Don't use this for validation
   }
   ```

---

## Summary Table

| Keyword | Purpose | Example |
|---------|---------|---------|
| **try** | Contains risky code | `try { 10/0; }` |
| **catch** | Handles exception | `catch (ArithmeticException e)` |
| **throw** | Throws exception manually | `throw new Exception("msg")` |
| **throws** | Declares possible exception | `public void method() throws Exception` |
| **finally** | Always executes | `finally { cleanup(); }` |

---

## Practice Exercises

1. Create a method that validates email and throws exception if invalid
2. Create a program that reads user input and handles NumberFormatException
3. Create a method with finally block that always prints "Operation completed"
4. Create multiple catch blocks for different exception types

---

## Next Steps

- Run `ExceptionHandlingExample.java` to see all concepts in action
- Modify the code and test different scenarios
- Create your own exception handling examples
- Practice with real file I/O operations

Happy Learning! 🎓
