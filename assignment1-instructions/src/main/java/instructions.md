# P2 - Assignment02

## **Due Date:**

02-14 23:57:00

## **Submission:**

**Please submit four .java files in total. Do not zip your files**.

* one .java files for task 1, 2 and 3 (Main.java)
* one .java files for task 4.1 (Author.java)
* one .java files for task 4.2 (Book.java)
* one .java files for task 4.3 (MyLibrary.java)

**Full Score**: 100

## Key Concepts for This Assignment

1. 1D array
2. Enhanced for (for-each) loop
3. Arrays class
4. 2D array
5. ArrayList

## Task 1

### Requirement

Implement the following methods:
1. `public static double sum(double[] nums)`
2. `public static double avg(double[] nums)`
3. `public static double min(double[] nums)`

## Task 2

### Requirement

Write a method to calculate the final score of an athlete.

`public static double calcFinalScore(double[] scores)`

### Hint

In some sports, such as diving, multiple judges (e.g., 5) score an athlete’s performance. To determine the final score, the process is as follows:
1. Sum all the scores.
2. Remove one instance of the highest score and one instance of the lowest score. If the highest or lowest score appears multiple times, only one occurrence is removed.
3. Compute the average of the remaining scores.

### Example
1. `{10, 9.8, 9.6, 9.2, 9.7}` -> `9.7`
2.	`{7.4, 7.4, 8.0, 8.2, 7.6}` -> `7.7`

## Task 3

Implement the following methods:
1. `double[] minOfRow(double[][] numss)` that finds the mininum value of each row of a 2D double array
2. `double[] minOfCol(double[][] numss)` that finds the mininum value of each column of a 2D double array

## Task 4

### Task 4.1

#### Requirement

Write a Class `Author`, that contains

* **Data members**：

    * `name`
    * `nationality`
    * `email`

* **Methods**:

    * Default constructor
    * Constructor with all data members

    * `equals()`
    * `toString()`
        * Example

      ```markdown
      Name        : Yi Wang
      Nationality : Canadian
      Email       : wangy@vaniercollege.qc.ca
      ```
    * getters and setters

### Task 4.2

#### Requirement

Write a Class `Book`, that contains

* **Data members**：

    * `title`
    * `authors`
        * a book may have more than one author
    * `price`

* **Methods**:

    * Default constructor
    * Constructor with all data members
    * `equals()`
    * `toString()`
        * Example:

      ```markdown
      Title:    Java Programming
      Author:   Yi Wang, Jon Snow	  // only show the author's name
      Price:    $9.99
      ```

    * getters and setters

### Task 4.3

#### Requirement

Write a Class `MyLibrary`, that contains

* **Data members**:

    * `books`
        * a collection of books, the number is fixed

* **Methods**:

    * Default constructor
    * Constructor with all data members
    * `selectBook()` that selects a random book
    * `selectBook(int idx)` that selects a book with a specific index. If `idx` is not valid, then select a random book
    * `int calcTotalPrice()` that calculates the total price of all the books in the library
    * `int countAuthor(String nationality)` that counts the number of times authors with the given nationality appear in the library’s books. Since an author can be counted multiple times (if they have written multiple books), the count should reflect the total occurrences across all books rather than the number of unique authors.
    * `equals()`
    * `toString()`
        * Example:

      ```markdown
      Title:    Introduction to Magic
      Author:   Bran Strark, Night King						
      Price:    $9.99
          
      Title:    How to kill a dragon
      Author:   Night King, Euron Greyjoy
      Price:    $12.98
      ```

    * getters and setters
