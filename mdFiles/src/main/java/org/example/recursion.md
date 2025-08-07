# 3.1 Recursion

## 1. What is recursion

`Recursion` is a programming technique where a function solves a problem by **calling itself**. Think of it as a function that breaks down a task into smaller, self-similar subtasks. While loops can handle repetitive tasks, recursion often provides a more elegant and intuitive solution for certain problems.

This is an example of an infinity loop:

```java
public static void printInfo() {
    System.out.print("Hello");
    printInfo();		// calls itself
}

public static void printInfo() {
    while (true) {
        System.out.print("Hello");
    }
}

public static void main() {
    printInfo();			// "Hello""Hello""Hello""Hello""Hello""Hello""Hello""Hello""Hello""Hello""Hello"...
}
```

Controlled Recursion (Equivalent to a Loop):

```java
public static void printInfo(int num) {
    for (int i = 0; i < num; i++) {
        System.out.print("Hello");
    }
}

public static void printInfo(int num) {    
    // base case: pre-knowledge, you know what to do without any calcualtion
    if (num == 0) {
        return;
    }

    // general pattern: real action you want to do for general situation, and you should call the method itself with an update in this part, 
    System.out.print("Hello");
    printInfo(num - 1);
}

public static void main() {
    printInfo(1000000);			// "Hello""Hello""Hello"
}
```

## 2 How to Write A Recursion

A recursion method always contains two parts:

1. **base case**
2. **Recursive Step (General Pattern)**

### 2.1 Base case

- This is the simplest form of the problem, where you know the answer directly, without further recursion.
- It's the stopping condition that prevents infinite recursion.
- Example (sum of numbers up to x): If `x` is 0, the sum is 0.

    ```java
    if (x == 0) {
        return 0;
    }
    ```

### 2.2 Recursive Step (General Pattern):

- This is where the function calls itself with a modified input, moving closer to the base case.
- It breaks the problem down into smaller, similar subproblems.
- Example (sum of numbers up to `x`): The sum of numbers up to `x` is the sum of numbers up to `(x-1)` plus `x`.

For example, for the `sum(x)` task, `x = 3` and `x = 4` are two general cases, you can analysis them as:

``` puretext
sum(3) = 1 + 2 + 3
sum(4) = 1 + 2 + 3 + 4

so 

sum(4) = sum(3) + 4
```

And you may realize there is a pattern here for general `sum(x)`, which would be `sum(x) = sum(x - 1) + x`

So you can have the conclusion, for a general situation, you can also give the solution, even though it is an equation instead of a number, and since you have the answer, you should also directly return it.

```java
return sum(x - 1) + x;
```

### 2.3 Final solution

If you mix the base case and the general pattern together, you have the final solution of the recursion.

```java
public static int sumRecursion(int num) {
    // base case
    if (num == 0) {
        return 0;
    }

    // general pattern
    return sumRecursion(num - 1) + num;
}
```

## 3. Pros and Cons

- Pros:

    - Readability: Recursive solutions are often more concise and easier to understand, especially for problems with inherent recursive structures.
    - Simplicity: for some problems, finding a recursive solution is much easier than an iterative one.
- Cons:

    - Memory Overhead: Each recursive call adds a new stack frame, consuming memory. Deep recursion can lead to stack overflow errors.
    - Performance: Recursive calls can be slower than iterative loops due to the overhead of function calls.

## 4. How Recursion Works

Recursion works differently than a loop that we are familiar with, which will move to the next iteration after it finishes the current one:

```java
public static int sum(int num) {
    int sum = 0;
    
    // the iterator i equals 0 at first, and it will execute the body part of the for loop, once it is finished (adding 0 to the sum), it will move on to the next iteration.
    for (int i = 0; i < 5; i++) {
        sum += i;
    }
    
    return sum;
}
```

Recursion uses a stack data structure. It operates on a "first call, last return" principle (LIFO: Last-In, First-Out).

When a recursive function is called, a new stack frame is created, holding the function's variables and state.
The function continues to call itself until it reaches the base case.
Then, the base case returns, and the stack unwinds, with each function call returning in reverse order.

```java
public static int sumRecursion(int num) {
    if (num == 0) {
        return 0;
    }

    return sumRecursion(num - 1) + num;
}

public static void main(String[] args) {
    System.out.println(sumRecursion(3));
}
```

Explanation of the example above:

`sumRecursion(3)` is called.
`sumRecursion(2)` is called.
`sumRecursion(1)` is called.
`sumRecursion(0)` is called (base case).
`sumRecursion(0)` returns 0.
`sumRecursion(1)` returns 1 (0 + 1).
`sumRecursion(2)` returns 3 (1 + 2).
`sumRecursion(3)` returns 6 (3 + 3).