# P2 - Assignment02

## **Due Date:**

03-03 23:57:00

## **Submission:**

**Please submit four .java files in total. Do not zip your files**.

* for each task, you will have to create three packages (i.e.: `employeemanagementsystem`, `librarycatalogsystem`, and `flexiblestudentcomparator`) and put all files related to each task inside.
* `Main.java` does not belong to any package above.
* one zip file that contains the entire project

**Full Score**: 100

## Key Concepts for This Assignment

1. Inheritance
2. Polymorphism
3. Abstract class
4. Interface
5. Comparable
6. Comparator

## Task 1: Employee Management System

### Description:

Design an Employee Management System that has different types of employees. The system should be able to display employee details, calculate salaries, and apply bonuses.

### Requirements:

1. Create an abstract class `Employee` with the following fields:
- `String name`
- `int id`
- `double baseSalary`
- Default constructor
- All arguments constructor
- Abstract method `double calculateSalary()`
- Concrete method `void displayDetails()` to print employee information (use `toString()` method).
- `toString()`
- `equals()`
- Getters and setters
2. Create two subclasses:
- `FullTimeEmployee`:
    - `int performanceRating`
    - Default constructor
    - All arguments constructor
    - The salary is calculated as `baseSalary + performanceBonus`.
    - `toString()`
    - `equals()`
    - Getters and setters
- `PartTimeEmployee`:
    - `int hoursWorked`
    - `double hourlyRate`
    - Default constructor
    - All arguments constructor
    - The salary is calculated as `hourlyRate * hoursWorked`.
    - `toString()`
    - `equals()`
    - Getters and setters
3. Create an interface `BonusEligible` with a method:
- `double calcBonus()`;
- Only `FullTimeEmployee` should implement this interface. If the rating is `>= 8`, give a `10%` bonus, otherwise, `5%`.
4. Test the system by creating an array of Employee objects (both full-time and part-time), displaying their details, and calculating their salaries.

## Task 2: Library Catalog System

### Description:

You need to design a Library Catalog System that keeps track of books and their details.

### Requirements:
1. Create an abstract class `Book` with:
- `String title`
- `String author`
- `int publicationYear`
- Default constructor (`publicationYear = 2000`)
- All arguments constructor
- `toString()`
- `equals()`
- Getters and setters
2. Create two subclasses:
- `Ebook`:
    - `double fileSizeMB`
    - Default constructor
    - All arguments constructor
- `PrintedBook`:
    - `int numOfPages`
    - Default constructor
    - All arguments constructor
3. `Book` class Implement `Comparable<Book>`:
- Compare books by `publicationYear` (older books first).
4. `Ebook` override the `compareTo()`
- If the other book is also an ebook, compare books by `fileSizeMB` assendingly.
- Else compare by using the `compareTo()` defined in the super class.
5. `PrintedBook` override the `compareTo()`
- If the other book is also a printedBook, compare books by `numOfPages` desendingly.
- Else compare by using the `compareTo()` defined in the super class.
5. Sort and display books:
- Store books in an `ArrayList<Book>` and sort them using `Collections.sort()` and print the result.
- Store books in an `ArrayList<Ebook>` and sort them using `Collections.sort()` and print the result.
- Store books in an `ArrayList<PrintedBook>` and sort them using `Collections.sort()` and print the result.

## Task 3: Flexible Student Comparator

### Description:

You need to compare students dynamically using a single comparator that supports three different sorting strategies. The default sorting is by id, and when there is a tie, a secondary field will be used.

### Requirements:

1. Create a class `Student` with:
- `int id`
- `String name`
- `double score`
- `int age`
- Default constructor
- All arguments constructor
- `toString()`
- `equals()`
- Getters and setters
2. Create a `StudentComparator` class as an inner class in `Student` class that implements `Comparator<Student>` with a private field:
- `String sortType` (values: `"score"`, `"name"`, `"id"`)
- Constructor: `public StudentComparator(String sortType)`
- In `compare()`, apply the following logic:
    - If `sortType.equals("score")`, sort by `score` descending → if `scores` are equal, sort by `age` ascending.
    - If `sortType.equals("name")`, sort by `name` ascending → if `names` are equal, sort by `id` ascending.
    - Default sorting is by `id` ascending → if `IDs` are equal, sort by `age` descending.
3.	Test the system in main():
- Create an `ArrayList<Student>` with at least 5 students.
- Use `StudentComparator("score")` to sort and display results.
- Use `StudentComparator("name")` to sort and display results.
- Use `StudentComparator("id")` to sort and display results.

### Example:

| ID  | Name    | Score | Age |
|-----|---------|-------|-----|
| 102 | Alice   | 85.0  | 20  |
| 104 | Bob     | 85.0  | 22  |
| 101 | Charlie | 92.0  | 19  |
| 103 | David   | 85.0  | 20  |

- `"score"` → Sorted by `score` descending, `age` ascending
  Charlie → Alice → David → Bob
- `"name"` → Sorted by `name` ascending, `id` ascending
  Alice → Bob → Charlie → David
- `"id"` (default) → Sorted by `id` ascending, `age` descending
  101 → 102 → 103 → 104
