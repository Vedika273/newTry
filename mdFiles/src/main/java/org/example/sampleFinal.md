# Exam02-Example

Submission: Please submit 7 java files one by one, i.e.:
1. Main.java
2. MainTest.java
3. User.java
4. Technician.java
5. Ticket.java
6. TicketSystem.java
7. TechnicianTest.java

Theory is answered direclty in the comment at the very beginning of your `Main` class.

## Theory

### 1. True or False (Write T of F for each question) (2 point X 5)

1. If two Cat objects have different filed values, e.g.: different names, ages or genders, their hash code must be different too.
2. ArrayList supports methods that LinkedList does not support.
3. Binary search tree allows duplicated values
4. Map contains two generics values
5. The return type of `stream().forEach()` is `Stream`

### 2. Multiple Choice (2 point X 5)

1. The time complexity of `add(int idx, E value)` for an arraylist is ___

   A. O(1)

   B. O(1)*

   C. O(n)

   D. O(n^2)

2. Which of the following operation is not supported for a standard Stack with 3 elements ___

   A. Checking the value of the last element

   B. Adding a value at the end of a stack

   C. Removing the last element

   D. Adding a value at the beginning of a stack

3. To find the amount of even numbers in an ArrayList, we can use the `stream` operation(s) ____

   A. first `filter` and then `count`

   B. first `map` and then `count`

   C. first `forEach` and then `count`

   D. just `count`

4. ___ is an operation ArrayList good at while LinkedList bad at

   A. `get(int idx)`

   B. `contains(E value)`

   C. `add(E value)`

   D. `remove(E value)`

5. The latest Junit test verion is __?

   A. 3

   B. 4

   C. 5

   D. 6

### 3. Filling the Blank (2 point X 5)

1. Queue is ___ and Stack is ____. (choose between FIFO and FILO)
2. An interface with only one abstract method is called ____
3. To count the number of male students and female students in a `List<Student>`, where `gender` is a `String` filed in `Student` class, the data type of the map should be _____
4. The best time complexity (big O notation) is ___
5.
pre: 5 3 1 4 8 7 9
in:  1 3 4 5 7 8 9
post:1 4 3 7 9 8 5
   ```
         5
       3   8
      1 4 7 9
   ```
      The pre-order travelling result of the above BST is _____ 

## Coding

### Static (10 point x 2)

1. Create a `static` method `reverse(String str)` that accepts a string and reverse it. Students must implement this method with recursion. Unit testing must applied.
2. Create a `static` method `process` that takes a list of string, count the average length of the string, then removes all strings inside with length bigger than the average length, for the remaining strings, convert it to lowercase and repeat it twice, and return the new list, e.g.: {"Hi", "What", "is", "your", "name"} -> {"hihi", "isis"}

### Project (50 points)

1. Design an abstract `User` superclass containing:
    1. `id`
    2. `name`
    4. `gender` (`MALE`, `FEMALE`)
    5. constructor with `name` and `gender`, (`id` should increase automatically)
    7. equals method
    8. toString method
    9. getters and setters
    10. Comparable implementation, sorting first by `id`.
    11. `createTicket(String title, String context)` to create a new ticket, and add the new ticket into the `openedTicket` in the ticket system. The creator is the user herself/himself, the createdTime is the current system time, the status is `OPEN`, the technician is `null`
2. Implement a `Technitian` subclass with:
    1. `onGoingTickets` (`List`)
    2. constructor with `name` and `gender`
    3. equals method
    4. toString method
    5. getters and setters
    6. `fetchNewTicket()` to get a new ticket from the tickey system `openedTickets`, update the ticket status as `PROCESSING`, update the `technician` of the ticket to the technician himself/herself and add it to the `onGoingTickets`. This method should also call the `export()` method in the `TicketSystem` class to update the external files.
    7. `closeTicket(Ticket ticket)` to change the ticket's status to `closed` and remove it from the technician `onGoingTickets` list, add it to the tickey system `completedTicket`. This method should also call the `export()` method in the `TicketSystem` class.
    8. `reassignTo(Ticket ticket, Technician technician)` to reassign the ticket to another technician, remove it from the current technician's `onGoingTickets` and add it to the new technician's `onGoingTickets`.
    9. `serachCompletedTicket(String keyword)` to search a keyword in the title (case-insensitive) of `completedTickets`, return a list as a result. (MUST use stream). Unit testing must applied (only one test case for general case is enough).
3. Create a `Ticket` class with:
    1. `id`
    2. `title`
    3. `detail`
    4. `creator` (`String` only the name)
    5. `createdTime` (`LocalDateTime`)
    6. `status` (`OPEN`, `PROCESSING`, `CLOSED`)
    7. `technician` (`String` only the name)
    8. constructor with `title`, `detail` and `creator`. The `id` should be increased automatically, `creastedTime` should be the current system time, `status` should be `OPEN`, and `technician` should be `null`.
    9. all arguments constructor
    10. equals method
    11. toString method
    12. getters and setters
4. Create a `TicketSystem` class with:
    1. `public static openedTickets` (first come first serve)
    2. `public static completedTicket` (can be read at any index)
    3. `initTickets(String path)` to read a file that contains a collection of tickets, and convert the data into a `LinkedList` of `Ticket`, this method is used to initialize the `openedTickets` and the `completedTicket` above. This method should also update the nextId in the `Ticket` class, the value equals to the the `id` of the last ticket read from the `openedTickets` plus 1.
    7. `export()` to write the current `openedTickets` and `completedTIcket` into two seperated csv files. 