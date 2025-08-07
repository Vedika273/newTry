# Chapter 1-2 Multi-dimension Array

## 1. Definition

**A Multi-dimension array is an array of arrays**.

An `int` single-dimension array, like `int[] nums`, is an array of `int`, where each element is an individual integer.

An `int` 2D array, like `int[][] numss`, is an array of `int[]`, where each element is an integer array.

When naming a multi-dimensional array, we can:
1.	Add an `s` after the noun for a 1D array, like `clocks`, and `ss` after the noun for a 2D array, like `clockss`.
2.	Add `Array` after the noun for a 1D array, like `personArray`, and 2Array or `2dArray` for a 2D array, like `person2dArray`.

## 2. Initialization

1. Use the keyword `new` to initialize a 2D array

    ```java
    // initialize a 2D array with 1 size
    // the first [] indicates the row, the second [] indicates the column
    // [3][]: 3 rows, the column is not fixed

    int[][] numss = new int[3][];			// general way to initialize a 2D array {null, null, null}
    int[][][] numsss = new int[4][][];		// {null, null, null, null}

    // initialize a 2D array with 2 sizes
    // [2][3]: 2 rows, 3 columns
    int[][] numss2 = new int[2][3];				// {{0, 0, 0}, {0, 0, 0}}
    int[][][] numsss = new int[4][5][6];		// {null, null, null, null}
    ```

2. Use `{}` to initialize a 2D array

    ```java
    // each element inside of a 2D array is an 1D array
    int[][] numss = {null, {}, {1, 2, 3}, nums, new int[]{1, 2, 3}};

    int[][][] numsss = {null, {{}}, {null}, {{1, 2, 3}, {1, 2}}, new int[1][2]};
    ```

## 2 Index system

For a 2D array, since there are two sizes (rows and columns), if you provide a single index (inside the first `[]`), you will get a single-dimensional array (the row). If you provide two indexes (one for the row and one for the column), you can access the actual value at that position in the array.

For example:
* `array[2]` gives you the entire row (which is a 1D array).
* `array[2][3]` gives you the specific value at row 2, column 3.

    ```java
    // 1 2 3
    // 4 5 
    // 7 8 9 0
    int[][] numss = {{1, 2, 3}, {4, 5}, {7, 8, 9, 0}};
    // numss[row][col]
    // numss[1]   ->   a 1-d array: {4, 5}
    // numss[1][0]  -> a real value: 4   
    ```

The index may get out of bounds on both the row-level and the column-level.

```java
int[][] numss = {{1, 2, 3}, {4, 5}, {7, 8, 9, 0}};
// numss[3] -> out of bound
// numss[3][0] -> out of bound
// numss[0][3] -> out of bound
```

## 3. for loop

### 3.1 regular-for


To use a `regular-for` loop with a 2D array, you first need to find the size of the array:

1.	To check the number of rows in a 2D array, use `numss.length`.
2.	To check the number of columns in a matrix-like 2D array (where each row has the same number of columns), use `numss[0].length`.
3.	To check the number of columns in a non-matrix-like 2D array (where each row may have a different number of columns), use `numss[i].length`, where i represents the row index.

```java
// 1 2 3
// 4 5 6
int[][] numss = {{1, 2, 3}, {4, 5, 6}};

for (int i = 0; i < numss.length; i++) {			// row level
    for (int j = 0; j < numss[i].length; j++) {	// column level
        System.out.print(numss[i][j]);			// read an element
        numss[i][j]++;				// modify an element
    }
}
```

### 3.2 enhanced-for loop

```java
/**
 * Calculates the sum of a 2D array
 * @param numss the input 2D array
 * @return the sum of the 2D array
 */
public static double sum(double[][] numss) {
    int sum = 0;

    for (double[] nums : numss) {
        for (double num : nums) {
            sum += num;
        }
    }

    return sum;
}

```

### 3.3 mix of the two

It is common to see a mix of the `regular-for` and `enhanced-for` in multi-dimension arrays

```java
/**
 * Increases each element in the array by a specific value
 * @param numss the input array
 * @param value the amount to increase
 */
public static void increaseValue(double[][] numss, double value) {
    for (double[] nums : numss) {						// enhanced-for, nothing to change on 2d-array-level
        for (int j = 0; j < nums.length; j++) { 		// regular-for, value changes on 1d-array-level
            nums[j] += value;
        }
    }
}
```

## 4 `Arrays` class methods

1. `Arrays.deepToString()` for multi-dimension (2D or more) array
2. `Arrays.deepEquals()` for multi-dimension (2D or more) array