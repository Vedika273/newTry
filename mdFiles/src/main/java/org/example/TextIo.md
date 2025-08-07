# 5.1 TextIO: Input

## 1. What Is TextIO

When a programmer needs to communicate with a computer, the console is often used. However, if the goal is to share data with a colleague who isnâ€™t a programmer, they might send the data in a more familiar format like an Excel or text file. In such cases, the programmer needs to read data from the file, process it, and possibly write the results to another file, whether itâ€™s in Excel, text, or other formats. This process of reading and writing data from external text files is referred to as Java TextIO.

Key Concepts:
â€¢	`I` stands for Input: This refers to reading data from an external file into the Java program.
â€¢	`O` stands for Output: This refers to writing data from the Java program to an external file.

Itâ€™s important to remember that a fileâ€™s extension doesnâ€™t define its data content but rather indicates how the operating system should handle the file. For instance, whether a file is named data.txt, data.yi, or data (with no extension), the data inside the file could be the same. The extension merely helps the OS recognize the type of application that should open the file.

TextIO specifically refers to handling text data, meaning files that contain readable text. These files donâ€™t have to be .txt files. They can be any file type containing text-based content, and the Java program will handle them using text-based I/O operations.

For example, the data in a file can be read and processed as plain text, and the file could have any extension (like .data, .csv, .log, etc.). Javaâ€™s TextIO is focused on handling this kind of data, not binary formats such as images, movies, or zip files.

### 1.1 a csv File

When working with external files in Java, itâ€™s common to handle Excel files, which often have the .xlsx extension. However, .xlsx files arenâ€™t standard text files; they contain additional formatting information such as font styles, background colors, and images. Java does provide methods for reading and writing .xlsx files, but this isnâ€™t considered pure TextIO since the file contains more than just text data.

On the other hand, .csv (Comma-Separated Values) files are text-based, even though they can be opened by Excel. In a .csv file, data in different columns is separated by commas, making it easy to read and write as plain text. Unlike .xlsx files, .csv files can be opened with a basic text editor and can be easily read and written using Java TextIO methods.

If you have a .xlsx file, you can open it in Excel and save it as a .csv file. The reverse process is also possibleâ€”saving a .csv file as an .xlsx in Excel. This allows you to work with .csv files as text-based files in Java, while still maintaining compatibility with Excel for viewing and editing the data.

## 2. TextIO VS ConsoleIO

In Programming 1 we have learned how to read and write data through the console:

```java
// output: 
System.out.print(); 
System.out.println();
System.out.printf();

//input: 
Scanner console = new Scanner(System.in);

String str = console.next(); 
String str2 = nextLine(); 
int num = nextInt(); 
double num2 = nextDouble();
```

Console IO involves reading from and writing to the console, while TextIO deals with reading from and writing to external files. Despite the difference in source and destination, the methods used for both are quite similar. For output, you would use `print()`, `println()`, and `printf()`, and for input, you would use methods like `next()`, `nextLine()`, `nextInt()`, and `nextDouble()`.

## 3 Absolute Path VS Relative Path

Before diving into how to implement TextIO, we first need to understand how to represent the path of a file. There are two types of file paths:
- Absolute Path: This is a path that starts from the root of the operating system (OS), like `C:\Users\andre\Desktop\Programming2\Lecture\imgs\Chapter4\ExceptionHierarchy.png`. The absolute path remains constant, regardless of where the describer (the program or the person) is located.
- Pro: The absolute path guarantees that anyone can find the file, as it provides a specific, unambiguous address.
- Con: If the fileâ€™s location changes, the absolute path becomes invalid, and the file cannot be found.
- Relative Path: This is a path that starts from the location of the current file (the describer). For example, `imgs\Chapter4\ExceptionHierarchy`.png is a relative path. The relative path depends on the position of the current file.
- Pro: If the fileâ€™s location changes but the relationship between the files remains the same, you can still locate the file.
- Con: The fileâ€™s address is ambiguous, as it can only be found relative to the current file. If someone else tries to use the relative path, they wonâ€™t be able to locate the file unless their directory structure matches.

In computer science, relative paths are often preferred. For instance, if you develop a website locally on a Windows machine and later transfer the project to a server running Linux, absolute paths would break. However, if the relative paths between files remain consistent, the server can still access the files correctly, even though the operating systems are different.

## 4 Text Input

### 4.1 Basic Syntax

Generally, there are 3 steps to read from a file:

1. create a `File` object and link it with the file path

    ```java
    File file = new File(path);
    ```

2. To create a `Scanner` object and link it with the previous `File` object, you should use the `try-with-resources` structure and declare the Scanner object as the resource within the parentheses. The `try-with-resources` structure functions similarly to the standard `try-catch` block, with the key difference being that it automatically releases the resources defined within the parentheses. It is essential to release the resource when reading a file; otherwise, Java will maintain the connection to the external file even after the reading is completed.

    ```java
    try (Scanner input = new Scanner(file)) {		// try with resource
        // code
    } catch (IOException e) {
        System.out.print("File not found");
    }
    // once the try-catch structure is over, the input resource will be released
    ```

3. read data from the file. You can use `nextLine()`, `next()`, `nextInt()` or `nextDouble()` to read data from the file.

    ```java
    try (Scanner input = new Scanner(file)) {
        String str = input.nextDouble();		// read a string
        String str2 = input.next();				// read a string
        int num = input.nextInt();				// read an int
        double num2 = input.nextDouble();		// read a double
    } catch (IOException e) {
        System.out.println(String.format("File %s does not exist", path));
    }
    ```

Here is an example of a method to read a file. However, the return type and the body of the `try-catch` may be different case by case.

```java
public static String readFile(String path) {
    File file = new File(path);     

    String str = "";

    try (Scanner input = new Scanner(file)) {
        str = input.nextLine();
    } catch (IOException e) {
        System.out.println(String.format("File %s does not exist", path));
    }
    
    return str;
}
```

### 4.2 Read Multi-column Data

Previously, we learned how to read a single piece of data from an external file. However, in practice, itâ€™s uncommon to encounter a file with only one piece of data. Typically, the file contains multiple pieces of data, and programmers need to read and process all of them.

In this section, weâ€™ll explore a more complex scenario where the data consists of rows. For example, the file may contain student scores separated by spaces, like this:

```markdown
1 Yi Wang 98		
```

What we can do is to read the entire line and keep it in a String.

```java
public static void readFile(String path) {
    File file = new File(path);     

    try (Scanner input = new Scanner(file)) {
        String row = input.nextLine();			// read the entire row
    } catch (IOException e) {
        System.out.println(String.format("File %s does not exist", path));
    }
}
```

Once we have the entire line, we no longer need to worry about TextIO. Since the data is organized in rows, we simply need to extract the values from the row. We can use the `split()` method from the String class, which divides a string into multiple substrings based on a specified delimiter. For instance, if the row contains the value `1 Yi Wang 98`, it consists of four parts separated by spaces. We can split the row by spaces using the following code: `String[] strs = row.split(" ")`;. This will store the result in a String array.

```java
public static void readFile(String path) {
    File file = new File(path);     

    try (Scanner input = new Scanner(file)) {
        String row = input.nextLine();			// read the entire row
        String[] strs = row.split(" ");			// extract each part
    } catch (IOException e) {
        System.out.println(String.format("File %s does not exist", path));
    }
}
```

Next, we can use the index to access each part of the split data and process it as needed. For instance, if there is a Student class with data members `id`, `fname`, `lname`, and `score`, along with an appropriate constructor, we can use the following code to create a `Student` object:

```java
public static Student readFile(String path) {
    File file = new File(path);     
    Student stu = null;

    try (Scanner input = new Scanner(file)) {
        String row = input.nextLine();			// read the entire row
        String[] strs = row.split(" ");			// extract each part
        stu = new Student(strs[0], strs[1], strs[2], strs[3]);			// id, fname, lname, score
    } catch (IOException e) {
        System.out.println(String.format("File %s does not exist", path));
    }
    
    return str;
}
```

### 4.3 Read Multi-row Data

In some cases, you may have a file with data spanning multiple rows, and a single nextLine() wonâ€™t be sufficient to read all the data. Additionally, as the file grows (e.g., from 100 rows to 120 rows, then 200 rows), hard-coding the number of rows becomes impractical, as youâ€™d have to constantly update the code to match the file length.

The proper solution is to use the `hasNext()` method from the Scanner class. This method checks if the scanner has reached the end of the file. If `hasNext()` returns true, there is more data to read, and if it returns false, the end of the file has been reached.

We can use a while loop with `hasNext()` as the condition. Inside the loop, weâ€™ll read the data line by line. The loop will automatically stop once the end of the file is reached, without worrying about the fileâ€™s length.

The following code reads numbers from a file and adds them to an ArrayList. If the data canâ€™t be parsed as an integer, a special value of -1 will be added.

```java
/* data
	1
	2a			// bad data, should be handle with a try-catch inside the loop
	3
	4
	5
 */
public static ArrayList<Integer> readFile(String path) {
    File file = new File(path);
    ArrayList<Integer> nums = new ArrayList<>();

    try (Scanner input = new Scanner(file)) {
        while (input.hasNext()) {        // boolean method to check if the scanner reach the end of the file or not
            try {
                nums.add(Integer.parseInt(input.next()));
            } catch (NumberFormatException e) {
                nums.add(-1);			// if a data cannot be converted to an integer, add -1 instead
            }
        }
    } catch (IOException e) {
        System.out.println(String.format("File %s does not exist", path));
    }

    return nums;
}
```

### 4.4 Read From A Table

In many cases, your data wonâ€™t be limited to just a single row or column, but instead, it will be organized as a table with multiple rows and columns (like a matrix), and youâ€™ll need to read that data.

To read data from a table, we need to combine our knowledge of reading multi-row and multi-column data. Specifically, we start by using a loop to iterate through each row. For each row, we first read the entire line and then split it into individual parts.

Hereâ€™s an example of how to read student data and return an ArrayList of student objects as the result.

```java
/**
 * Read data from StudentData.txt and store all information of students in
 * an ArrayList.
 *
 * @param path the path of the file
 * @return the arraylist of student that contains information of all
 * students
 */
public static ArrayList<Student> readStudentData(String path) {
    File file = new File(path);

    ArrayList<Student> students = new ArrayList<>();

    try (Scanner input = new Scanner(file)) {
        input.nextLine();           // read the header, but not touch it

        while (input.hasNext()) {           // read multi-row
            String row = input.nextLine();
            String[] data = row.split(" ");     // {"0001", "yi", "wang", "registered", "98", "78"}

            String id = data[0];
            String fname = toTitleCase(data[1]);
            String lname = toTitleCase(data[2]);
            double score1;
            double score2;
            boolean registered = !data[3].toLowerCase().contains("un");

            try {										// make sure the data can be casted to a double
                score1 = Double.parseDouble(data[4]);
            } catch (java.lang.NumberFormatException e) {
                score1 = -1;
            }

            try {
                score2 = Double.parseDouble(data[5]);
            } catch (java.lang.NumberFormatException e) {
                score2 = -1;
            }
            
            double[] scores = {score1, score2};

            Student student = new Student(id, fname, lname, registered, scores);
            students.add(student);						// add the new student to the arraylist
        }
    } catch (IOException e) {
        System.out.println(String.format("File %s does not exist", path));
    }

    return students;
}
```