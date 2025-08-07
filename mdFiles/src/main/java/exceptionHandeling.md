# 4.1 Exception Handling

## 1. What is Exception Handling

Orally, we often say there is an â€œerrorâ€ in the code, but technically, this might not be accurate since most issues are actually `exceptions` rather than errors.

Both `Error` and `Exception` exist at the same level in Javaâ€™s hierarchy, indicating problems in the code. However, an `Error` is more severe than an `Exception`.
â€¢	An `Error` represents critical issues, such as memory leaks, which are typically beyond the programmerâ€™s control.
â€¢	An `Exception` refers to less severe issues that can usually be handled and resolved by the programmer.

In Java, both `Error` and `Exception` are classes within the same hierarchy.

## 2. Checked VS Unchecked

A `checked exception` is an exception that Java detects at compile time, requiring you to handle it before execution; otherwise, the code will not compile.

An `unchecked exception`, on the other hand, is not detected by Java beforehandâ€”it occurs during runtime. For example, accessing an array element with an out-of-bounds index triggers an unchecked exception.

In Java:
- `Error` and `RuntimeException` are both `unchecked exceptions`.
- All other exceptions are checked exceptions.

## 3. Default Handler

When an exception or error is thrown, Java must handle it using a handler, which is a piece of code designed to respond to the issue.

Java provides a default exception handler, a built-in mechanism that automatically manages exceptions if the programmer does not define specific handlers.

The default exception handler performs the following actions:
1.	Prints the error or exception name along with a message (additional details) in the console.
2.	Prints the stack trace, showing where the issue occurred.
3.	Terminates execution, stopping the program.

## 4. User-defined Handler

There are two ways to handle an exception in Java:
- `try`-`catch`: The programmer provides a specific solution to handle the exception within the same method.
- `throws`: The method declares the exception, instructing Java to look for a handling solution in another method.

### 4.1 try-catch

#### 4.1.1 Basic Syntax of `try-catch` structure

The `try`-`catch` structure consists of at least two parts: try and catch.
- A `try` block cannot exist without a catch block.
- Similarly, a catch block cannot exist without a `try` block.
- There is an optional third part, `finally`, which always executes regardless of whether an exception occurs.

The `try` block acts as a sandboxâ€”it does not alter the behavior of the statements inside it. However, if an exception is thrown within the `try` block, the catch block can provide a user-defined solution to handle it.

```java
try {
    // sandbox, you can put whatever code that you think may throw an exception in this part 
}
catch (Type1 e) { // a handler that can handle Type kind of exception
    // if this kind of exception is thrown from the try part, this catch will be activated and the code in the body will be excuted
}
catch (Type2 e) { // you can have as many catches as you want
    // different catches can be used to handle different kinds of exceptions
}
finally {
    // optional (always executed)
}
```

If no exception is thrown inside the `try` block, the `try`-`catch` structure does nothing extraâ€”the code behaves as if the `try`-`catch` were not there.

It is not recommended to wrap all code inside `try`, as not every statement is prone to exceptions. Typically, only the code that may cause an exception is placed inside `try`.

Additionally, `try`-`catch` is primarily used for handling checked exceptions. Unchecked exceptions (such as `RuntimeException`) generally do not require explicit handlingâ€”if the code is written carefully, they can often be avoided.

A `try` block must have at least one `catch` block. However, you can have multiple `catch` blocks to handle different exceptions.
- Each `catch` block acts like a specialized worker, handling a specific type of exception.
- Once one `catch` is matched, other `catch` blocks will be skipped.
- Some `catch` blocks can handle multiple exceptions, while others are limited to a single exception type.
- The way an exception is handled is defined inside the `catch` blockâ€™s body.

#### 4.1.2 try-catch With Specific Handler

Here is an example of a `try` block with two `catch` blocks:
- The first catch handles `ArrayIndexOutOfBoundsException`.
- The second catch handles `ArithmeticException`.

The try block contains a for loop that runs 10 times. In each iteration:
1. A random number between `[0, 9]` is generated and used as an index to access an element in nums (an array with only 4 elements, one of which is 0).
2. If the index is too large, accessing `nums[rand.nextInt(10)]` will throw an `ArrayIndexOutOfBoundsException`.
3. If the index is `2`, the extracted number will be `0`, and dividing by `0` will throw an `ArithmeticException`.

Execution Scenarios:
1. If all 10 generated numbers are valid (none exceed the array length and none equal 2), no exceptions occur. The catch blocks are never triggered, and the try-catch structure does nothing.
2. If a random number 7 is generated, `nums[7]` will cause an `ArrayIndexOutOfBoundsException`.
    * Java stops execution and looks for a handler.
    * The first catch matches the exception and executes its code, setting `result = -1`.
    * The exception is handled, execution continues after the try-catch, and the result (-1) is printed.
3. If a random number 2 is generated, `nums[2]` equals 0, leading to `ArithmeticException` (division by zero).
    * Java stops execution and looks for a handler.
    * The first catch does not match, so Java checks the second catch, which does match.
    * The second catch executes its code, setting `result = 0`.
    * The exception is handled, execution continues after the try-catch, and the result (0) is printed.

```java
public static void main(String[] args) {
    int num = 5;
    Random rand = new Random();
    int num2 = rand.nextInt(num);           // [0, 1, 2, 3, 4]
    int result = 0;
    int[] nums = {1, 2, 0, 3};

    try {
        for (int i = 0; i < 10; i++) {	// may throw ArithmeticException and ArrayIndexOutOfBoundException
            result = num / nums[rand.nextInt(10)];  
        }
    } 
    catch (ArrayIndexOutOfBoundsException e) {
        result = -1;
    }
    catch (ArithmeticException e) {
        result = 0;
    }
    System.out.print(result);
}
```

#### 4.1.2 try-catch With General Handler

Letâ€™s consider a special case: What if the code inside the `try` block throws an exception that is neither `ArrayIndexOutOfBoundsException` nor `ArithmeticException`?

For example, if a `StringIndexOutOfBoundsException` is thrown, Java will sequentially check each catch block to see if any of them can handle it. Since none of the existing catch blocks match, Java will fall back to its default exception handler, which:
1. Prints the exception type and message to the console.
2. Displays the stack trace showing where the exception occurred.
3. Terminates the program.

Handling Exceptions More Flexibly

What if we donâ€™t want Javaâ€™s default handler to handle unexpected exceptions, but listing every possible exception is impractical? The solution is to use a broader catch block that can handle multiple exceptions:
- `catch (RuntimeException e)` â†’ Catches all exceptions that inherit from `RuntimeException`.
- `catch (Exception e)` â†’ Catches all possible exceptions (both checked and unchecked).

Ordering Matters

Java processes catch blocks in order, from top to bottom.
- Specific exceptions (e.g., `ArrayIndexOutOfBoundsException`) must come first.
- General exceptions (e.g., `Exception`) must come last.
- If a general catch appears first, it will handle all exceptions, making the specific ones unreachable.

```java
public static void main(String[] args) {
    int num = 5;
    Random rand = new Random();
    int num2 = rand.nextInt(num);           // [0, 1, 2, 3, 4]
    int result = 0;
    int[] nums = {1, 2, 0, 3};

    try {
        for (int i = 0; i < 10; i++) {      					// new ArrayIndexOutOfBoundException();
            result = num / nums[rand.nextInt(nums.length)];       // may throw ArithmeticException
        }
    } 
    catch (ArrayIndexOutOfBoundsException e) {
        result = -1
    }
    catch (ArithmeticException e) {
        result = 0;
    } 
    catch (Exception e) {
        result = -2;
    }
    System.out.print(result);
}
```

#### 4.1.3 Meaningful Handlers

Previously, we created three different handlers, each setting the result variable to a different value. Technically, you can write any code inside a catch block. However, simply assigning result a random number is not always a meaningful way to handle exceptions.

To provide a more useful and informative handler, we often need to use the exception variable e inside the catch block.

How e Works in catch Blocks

When an exception is thrown, Java creates an object representing that exception. It then compares the type of this object with each catch parameter to determine which handler should be activated.
- If the exception type matches a catch block, Java passes the exception object as the variable `e`.
- This means that inside a catch block, `e` holds detailed information about the exception.
- By calling specific methods on e, we can get more details about what went wrong.

Since `e` is an instance of an exception class, we can use predefined methods to extract useful information:
1.	`e.getClass()` â†’ Returns the exact class (type) of the thrown exception.
2.	`e.getMessage()` â†’ Provides additional details, such as "divide by zero" or "Index 10 out of bounds for length 4".
3.	`e.getStackTrace()` â†’ Returns a stack trace showing:
      - Which line threw the exception.
      - Which method caused the error.
      - The sequence of method calls leading up to the exception.
      - Since multiple methods may appear in the stack trace, this method returns an array (`StackTraceElement[]`), so you need to use a loop to extract details.

```java
public static void main(String[] args) {
    int num = 5;
    Random rand = new Random();
    int num2 = rand.nextInt(num);           // [0, 1, 2, 3, 4]
    int result = 0;
    int[] nums = {1, 2, 0, 3};

    try {
        for (int i = 0; i < 10; i++) {      					// new ArrayIndexOutOfBoundException();
            result = num / nums[rand.nextInt(nums.length)];       // may throw ArithmeticException
        }
    } 
    catch (ArrayIndexOutOfBoundsException e) {
        result = -1
    }
    catch (ArithmeticException e) {
        result = 0;
    } 
    catch (Exception e) {						// a handler that mimic the default handler
        // exception information
        System.out.print(e.getClass() + ": ");
        System.out.println(e.getMessage());

        // exception stact trace
        StackTraceElement[] stes = e.getStackTrace();

        for (StackTraceElement ste : stes) {		
            System.out.println("\t\t at " + ste);
        }

        // stop the execusion with a special status 
        // 0 ususally represents normal, all other numbers indicate that there is a problem in the code
        // this line is optional, if you remove this line, then the handler will only print without stop the execusion
        System.exit(1);       
    }
    System.out.print(result);
}
```

### 4.2 throws

Another way to handle an exception is by using `throws`. However, the `throws` statement itself doesnâ€™t actually handle the exception; itâ€™s more like an announcement from the method. It tells Java that if a specific exception occurs within the method, the method wonâ€™t handle it directly. Instead, it shifts the responsibility of handling the exception to the method that calls it.

Think of it like this: In a company, a manager assigns tasks to employees. If an employee encounters a specific problem that they cannot solve, they inform the manager and ask the manager to address it, rather than solving it themselves.

This approach might seem a bit unreasonable at first. Why would the employee not handle the issue themselves? In a company, the manager might be managing multiple employees, all of whom could encounter the same problem while working on their tasks. Instead of creating and updating individual solutions for each employee, the manager could create a single document outlining the solution and give it to everyone. This way, all employees can solve the problem independently. If the solution changes, only the manager needs to update the document.

In programming, this concept applies similarly. If we think of the manager as a method that calls five other methods, each of those methods might throw the same exception. We could write a try-catch block in each method, but this would make the code repetitive and harder to maintain (often called WET â€” Write Everything Twice). A better solution is to handle the exception in one place â€” in the calling method â€” by using throws.

By using throws at the end of a methodâ€™s signature, we announce that if a specified exception occurs inside the method, Java will defer the responsibility of handling it to the calling method. This way, we can centralize the exception handling, making the code cleaner and more maintainable.

```java
// throws ArithmeticException: if ArithmeticException is thrown in m1(), Java will go to the previous method who calls m1() to find the hander
public static void m1() throws ArithmeticException {    
    Random rand = new Random();
    int num1 = rand.nextInt(5);
    int num2 = rand.nextInt(5);
    int result = num1 / 0;
}
```

You can announce more than one exception after the `throws`, separated by `,`. For example:

```java
// throws ArithmeticException, IndexOutOfBoundException
public static void m1() throws ArithmeticException, IndexOutOfBoundException {    
    Random rand = new Random();
    int num1 = rand.nextInt(5);
    int num2 = rand.nextInt(5);
    int result = num1 / 0;
}
```

and then in the method which calls `m1()` provides the handler.

```java
public static void main(String[] args) {
    try {
        m1();
        m2();	// a method also may throw ArithmeticException
        m3();
    } catch (ArithmeticException e) {
        System.out.println("Cannot divid by zero");
    } catch (IndexOutOfBoundException e) {
        System.out.println("Index ouf of bound");
    }
}
```

The previous methods donâ€™t necessarily need to provide a `try`-`catch` solution. Instead, they can use the same approach as before by announcing that if an exception occurs, they will defer responsibility to the calling method. In this case, if `main()` calls `m1()`, and `m1()` calls `m2()`, both `m1()` and `m2()` can declare that they might throw exceptions using throws. This means that Java will ultimately ask `main()` to handle the exception.

In fact, `main()` can also use throws to announce that it might throw an exception. While this syntax is perfectly valid, since there is no method above `main()`, Java will resort to the default exception handler to deal with the exception if it is not handled within `main()`.

## 5. User-Defined Exception

To create a user-defined exception in Java, you need to define a new class that extends either `Exception` or `RuntimeException`, depending on whether you want it to be a checked exception or an unchecked exception.

Steps to Create a User-Defined Exception:
1.	Extend the `Exception` class: Choose between `Exception` (for checked exceptions) or `RuntimeException` (for unchecked exceptions).
2.	Define Constructors: You need to define at least two constructors:
â€¢	A default constructor with no arguments.
â€¢	A constructor that takes a String message to describe the exception.

```java
// extends RuntimeException: unchecked exception
// extends Exception: checked exception
public class TwoNumberTheSameException extends RuntimeException {           
    // default constructor
    public TwoNumberTheSameException() {
    }
    
    // with String message
    public TwoNumberTheSameException(String message) {
        super(message);
    }
}
```

Once the class is declared, you can create an object of it to represent an exception and then throw it manually. You can use the keyword `throw` to throw an exception manually.

```java
// "throws" is an anounance, it does not do any real action
// "throw" is a verb, that notice java to handle exception 
public static void m1() throws ArithmeticException, TwoNumberTheSameException {    
    Random rand = new Random();
    int num1 = 2;//rand.nextInt(5);
    int num2 = 2;//rand.nextInt(5);
    if (num1 == num2)
        // throw new TwoNumberTheSameException();  // default constructor with no message
        throw new TwoNumberTheSameException(num1 + "");  // or adding a String as message    
    int result = num1 / 0;
    System.out.println();      // Runtime exception: Arithmatic
}
```

You can use `try-catch` or `throws` to handle the exception.