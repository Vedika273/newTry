# 5.2 TextIO: Output

In the previous section, we learned how to read data from an external file, and in this chapter, we will focus on how to write data to a file.

## 1. Output Syntax

### 1.1 Basic Syntax

Generally, there are 3 steps to read from a file:

1. create a `File` object and link it with the file path

   ```java
   File file = new File(path);
   ```

2. Create a `FileWriter` object and associate it with the previous `File` object. In this step, use the `try-with-resources` structure, making the `FileWriter` object the resource. If you provide only one parameter to the constructor, Java will open the file in overwrite mode, meaning it will replace the existing content with new data. If you pass true as the second parameter, Java will open the file in append mode, allowing new data to be added at the end of the file without removing the existing content.

   ```java
   // try (FileWriter fw = new FileWriter(file)) {		    // over-write mode
   try (FileWriter fw = new FileWriter(file, true)) {		// appending mode
       // code
   } catch (IOException e) {
       System.out.println("Fail to write to the file");
   }
   // once the try-catch structure is over, the input resource will be released
   ```

3. To write data to the file, use the `write()` method. Note that the `write()` method does not automatically add a line break (unlike `println()`), so if you want to insert a new line, you need to manually include `"\n"` at the end of the data.

   ```java
   try (FileWriter fw = new FileWriter(file, true)) {
       fw.write("hi\n");
   } catch (IOException e) {
       System.out.println("Fail to write to the file");
   }
   ```

Here is an example of a method to write a file. However, the second parameter (the data) is different case by case.

```java
/**
 * Writes data to a file
 *
 * @param path the path of the output file
 * @param num the data to write
 */
public static void writeFile(String path, int num) {
    // Step 1: create File object
    File file = new File(path);

    // Step 2: create FileWriter object
    try (FileWriter fw = new FileWriter(file, true)) {
        fw.write(num + "\n");
        //            PrintWriter pw = new PrintWriter(fw);
        //            pw.println(pw);
    } catch (IOException e) {
        System.out.println("Writing file failed");
    }
}
```

### 1.2 Write Multi-column Data

Earlier, we learned how to write a single piece of data to an external file. In this section, weâ€™ll explore a more complex scenario where we need to write an entire row of data. For example, the data might include a studentâ€™s score, separated by spaces, like this:

```markdown
1 2 3 4 5	
```

If the data is stored in an array, we can use an enhanced for loop to iterate through the elements and write them, with each value separated by a `,`.

```java
/**
 * Writes a row of data into a file
 *
 * @param path the path of the file
 * @param nums the data to write: 1 2 3 4 5
 */
public static void writeFileRow(String path, int[] nums) {
    File file = new File(path);

    try (FileWriter fw = new FileWriter(file, true)) {
        for (int num : nums) {
            fw.write(num + ",");
        }
    } catch (IOException e) {
        System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
    }
}
```

### 1.3. Write Multi-row Data

Letâ€™s say we want to write the same array to a file, but with each element on a new row. The only change we need to make is to replace `","` with `"\n"` in the `write()` method.

```java
/**
 * Writes a column of data into a file
 *
 * @param path the path of the file
 * @param nums the data to write
 */
public static void writeFileCol(String path, int[] nums) {
    File file = new File(path);

    try (FileWriter fw = new FileWriter(file, true)) {
        for (int num : nums)
            fw.write(num + "\n");
    } catch (IOException e) {
        System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
    }

}
```

### 1.4. Write Table-like Data

If we have data that contains multiple rows and columns, we can combine the two previous methods into one:

```java
/**
 * Writes a matrix of data into a file
 *
 * @param path the path of the file
 * @param numss the data to write
 */
public static void writeFileTable(String path, int[][] numss) {
    File file = new File(path);

    try (FileWriter fw = new FileWriter(file, true)) {
        for (int[] nums : numss) {
            for (int num : nums) {
                fw.write(num + ",");
            }
            fw.write("\n");
        }
    } catch (IOException e) {
        System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
    }
}
```