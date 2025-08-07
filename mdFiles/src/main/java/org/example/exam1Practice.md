# Exam01-Example

Submission: Please submit 8 java files one by one, i.e.:
1. Main.java
2. User.java
3. Student.java
4. Teacher.java
5. Course.java
6. Payable
7. ManageCourse
8. School

Theory is answered direclty in the comment at the very beginning of your `Main` class.

## Theory

### 1. True or False (Write T of F for each question) (2 point X 5)

1. When `int[] nums = null;`, `nums.length` is equal to 0.
2. All methods within an interface are abstract.
3. A class can inherit from multiple parent classes.
4. The size of an ArrayList is dynamically changeable after its creation.
5. A single `try` block can be followed by multiple `catch` blocks.

### 2. Multiple Choice (2 point X 5)

1. A subclass implementing a method with its own solution to replace the method the super class provides is called ___

   A. overload

   B. override

   C. overload or override

   D. overload and override at the same time

2. Assuming we have a super class `Animal`, and a subclass `Cat`, with default constructors in both of them, which of the following might cause exception ___

   A. `Animal a = new Animal();`

   B. `Cat c = new Cat();`

   C. `Animal a = new Cat();`

   D. `Cat c = (Cat) animal;`

3. To find the number of elements in an ArrayList, we can use __

   A. `length()`

   B. `length`

   C. `size()`

   D. `size`

4. Which of the following exception types is considered a checked exception?

   A. `IndexOutOfBoundException`

   B. `IOException`

   C. `NullPointerException`

   D. `ArithmeticException`

5. In which scenario is an enhanced for loop unsuitable?

   A. calculating the average of an integer Arraylist

   B. increasing the age of each user in an User ArrayList

   C. summing the values at the same index in two arrays into a new array.

   D. calculating the sum of elements in an integer array

### 3. Filling the Blank (2 point X 5)

1. The keyword ___ signifies that a class is a subclass of another.
2. The keyword ___ denotes a non-abstract method within an interface.
3. Implementing the ___ interface allows a class to support multiple sorting strategies.
4. Construct an empty `ArrayList` capable of storing long integers.
5. The ___ class facilitates writing data to a text file in Java.

## Coding

### Static (10 point x 2)

1. Create a static method `multiply()` that accepts a `double` array and a `double` factor, and modifies the array by multiplying each element by the factor.
2. Develop a static method `countNegative()` that takes an `Integer` ArrayList and returns the count of negative numbers within it.

### Project (50 points)

1. Design an abstract `User` superclass containing:
    1. id
    2. name
    3. age
    4. gender
    5. default constructor
    6. all-arguments constructor
    7. abstract `void report(String title, String content)` method
    8. equals method
    9. toString method
    10. getters and setters
    11. Comparable implementation, sorting first by `name`, then by `age`.
2. Implement a `Student` subclass with:
    1. courses (dynamic size)
    2. default constructor
    3. all argus constructor
    4. implement `report(title, content)` method, that print:
       ``` 
       Student, ID: xxxx, Name: xxxx
       Title: xxxx
       Context: xxxx
       ```
    5. equals method
    6. toString method
    7. getters and setters
    8. implementation of the `ManageCourse` interface:
        1. register a course only if it's not already in the student's `courses`.
        2. drop a course only if it's present in the student's `courses`.
3. Create a `Teacher` subclass with:
    1. workExperience (integer, represents woring years)
    2. a static field with 10 values to indicate the baseAnnual Salary for different workExperience. i.e.: `double[] salaries = { 
    80208, 82972, 85737, 88502, 91266, 95507, 99748, 103989, 108230, 112471 };` (The first one is for 0 year work experience, and the second one is for 1 year work experience, etc.)
    3. default constructor
    4. all argus constructor
    5. implement `report(title, content)` method, that print:
       ``` 
       Teacher, ID: xxxx, Name: xxxx
       Title: xxxx
       Context: xxxx
       ```
    6. equals method
    7. toString method
    8. getters and setters
    9. implementation of the `Payable` interface, calculating salary based on work experience.
4. Create a `Course` class with:
    1. name
    2. Constructor with name
    3. toString method
    4. equals method
    5. getters and setters
5. Define a `Payable` interface with the abstract method:
    1. `double calcSalary()`
6. Establish a `ManageCourse` interface with abstract methods:
    1. `boolean register(Course)`
    2. `boolean drop(Course)`
7. Build a `School` class that includes:
    1. users (dynamically sized)
    2. default constructor
    3. all-arguments constructor
    4. `export(fileName)` method to write user data (overwrite mode) to a CSV file.
    5. equals method
    6. toString method
    7. getters and setters