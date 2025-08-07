// Arrays.fill() can also indicates where to start and end
Arrays.fill(nums, 1, 2, 9)  // {1, 9, 1}
```

Conclusion:

| Method | Usage |
| ------ | ----- |
| `Arrays.toString(array)` | converts an array to a string | 
| `Arrays.equals(array1, array2)` | compares two arrays |
| `Arrays.fill(array, val)` | fills an array with a specific value |
| `Arrays.fill(array, startIdx, endIdx, val)` | fills part of an array with a speicifc value |
| `Arrays.copyOf(array, len)` | returns a new array as a copy of the original array |
| `Arrays.copyOfRange(array, startIdx, endIdx)` | returns a new array as a copy of part of the original array |
| `Arrays.sort(array)` | sorts an array assendingly |
| `Arrays.sort(array, startIdx, endIdx)` | sorts part of an array assendingly |

## 5. Enhanced-for loop

### 5.1 What is the enhanced-for loop

In a `traditional for` loop, we need to create and manage an index to iterate through a collection. However, in most cases, our main concern is the values of the elements in the collection, not the index itself.

```java
// Regualr for loop for a String. String only supports regular for loop
String str = "hello";

for (int i = 0; i < str.length(); i++)
    System.out.print(str.charAt(i));
```

Another type of loop we can use for working with collections (excluding Strings) is the `enhanced-for` loop (also known as the `for-each` loop). The purpose of the `enhanced-for` loop is to iterate through a collection without relying on an index.

### 5.2 Comparison between **regular for** loop and **enhanced for** loop

| - | Regular for | Enhanced for |
| - | ----------- | ------------ |
| index              | uses index system | no index system |
| writing difficulty | more difficult to write | easier to write |
| features           | can customize the index, so can go through the collection with a specific rule | cannot customize the index, can only go through the collection from the 1st element to the last element |
| local variable     | most of time, you create `int i` | the data type of the variable is the same as the data type of the array , and that's the reason you should name any array plural. |
| read as       | - | `for (double num : nums)` can be read as "*for each `num` in `nums`*" |
| reading            | Yes | Yes |
| writing            | Yes | No |
| visit more than one collections synchronously | Yes | No |

### 5.3 Using enhanced-for loop to read elements (YOU SHOULD)

Enhanced-for **can be used to go through a collection and read each of its elements** without an index.

```java
// Array can support both regular for loop and enhanced-for loop
double[] num = {1.1, 2.2, 3.3, 4.4};

// Regular for loop for an array
for (int i = 1; i < nums.length - 1; i += 2) {
    System.out.print(nums[i]);
}

// Enhance for loop for any array
for (double num : nums) {
    System.out.print(num);
}
```

### 5.4 Using enhanced-for loop to modify elements (YOU SHOULD NOT)

An enhanced-for loop **CANNOT be used to iterate through a primitive collection and modify each element of it** since the modification will only be applied to the local variable instead of the real collection.

```java
int[] nums = {1, 2, 3};

// increase values of elements in an array by using enhanced-for loop
// won't work, nums will still be {1, 2, 3}
for (int num : nums) {
   num++;      				// num is a local variable, it will not affect the array
}

// increase values of elements in an array by using regular for loop
// will work, nums will be {2, 3, 4}
for (int i = 0; i < nums.length; i++) {
    nums[i]++;				// changes applied on nums
}
```

An enhanced-for loop can be used to iterate through an object collection and modify each element.

```java
Student[] students = {student1, student2, student3};

// assume there is a method increaseAge() in the Student class that increase the age of an student by 1
for (Student student : students) {
   student.increaseAge();      
}
```

### 5.5 YOU SHOULD NOT use enhanced-for loop if the index is used

If the task requires using the index system, you cannot use the enhanced-for loop. The `enhanced-for` loop does not provide access to the index, so a regular for loop should be used instead.

```java
/**
 * Adds elements in an array with odd index 
 * Example: {4, 6, 1, 9} -> 6 + 9 -> 15
 * @param nums the input array
 * @return the sum of elements in an array with odd index 
 */
public static double sumElementsWithOddIdx(double[] nums) {
    double sum = 0;

    // solution 1;
    for (int i = 0; i < nums.length; i++) {
        if (i % 2 == 1)	{	// have to check if the index is odd or not, cannot use an enhanced-for loop
            sum += nums[i];
        }
    }

    // solution 2;
    for (int i = 1; i < nums.length; i += 2) {
        sum += nums[i];
    }

    return sum;
}
```

### 5.6 YOU SHOULD NOT use enhanced-for loop to go through more than one array synchronously

If you need to iterate over more than one array at the same time, you will need an index to synchronize the two arrays. Since you require the index in this case, you should not use the `enhanced-for` loop, as it doesnâ€™t provide direct access to the index. Instead, a regular for loop would be more appropriate for this situation.

```java
/**
 * Add elements of an double array if at the same position, the boolean 
 * array has a value of true, if the two array have different size, 
 * calculate the sum based on the short one.
 * Example: {1, 2, 3, 4, 5} {true, false, true} -> 4
 *           {1, 2, 3} {true, false, true, true, true} -> 4
 * @param nums the number array
 * @param flags the boolean array
 * @return the sum
 */
public static double sum(double[] nums, boolean[] flags) {
    double sum = 0;
    int len = Math.min(nums.length, flags.length);

    // should use the regular for loop since we need the index system to 
    // synchronize the two array
    for (int i = 0; i < len; i++) 
        if (flags[i])       // do not write "flags[i] == true"
            sum += nums[i];

    return sum;
}
```

### 5.7 Converting a string to an array

You cannot use the `enhanced-for` loop directly to iterate over a string. Instead, you need to use the index system. However, you can first convert the String into a char array, and since a char array is an array, you can then use the `enhanced-for` loop to iterate over it:

```java
String str = "hello!";
// convert the string into a char array and then print each element of it
for (char c : str.toCharArray())
    System.out.println(c);

// convert the string into a char array and then count the number of digits in it
int digitCount = 0;
for (char c : str.toCharArray())
    if (Character.isDigit(c))
        digitCount++;
```

## 6 Array of objects

Arrays in Java can store both primitive data types and objects. The general rules for arrays apply to both types, with the key difference being that an array of objects stores references to those objects rather than the objects themselves.

```java
Clock[] clocks = new Clocks[3];			// {null, null, null}
Arrays.fill(clocks, new Clock());		// fill all null by a real object

Clock[] clocks2 = {new Clock(), new Clock(1, 2, 3), new Clock(2, 3, 4)};

Clock[] clocks3;
Clock c1 = new Clock();
Clock c2 = new Clock(8, 8, 8);
Clock c3 = new Clock(9, 9, 9);
clocks3 = new Clock[]{c1, c2, c3};
```

You can also use the index to access each element inside an object array, just like you would with an array of primitive types. The index will reference the object stored at that position in the array.

```java
Clock[] clocks = {new Clock(), new Clock(1, 2, 3), new Clock(2, 3, 4)};

System.out.print(clocks[0]);				// clocks[0] is a Clock object
clocks[0].increaseHr();						// you can use . to visit methods of the object
```

You can use the `enhanced-for` loop to iterate over an object array, and you can modify the data members of the objects during the iteration. However, the `enhanced-for` loop gives you access to the object references, so when you modify the data members, youâ€™re modifying the original objects in the array, not a copy of them.

```java
Clock[] clocks = {new Clock(), new Clock(1, 2, 3), new Clock(2, 3 ,4)};		// only the address is stored in the array

// increase each clock's hour by 1
// you CAN use enhanced-for even for modifying the data member of an object in an object array
for (Clock clock : clocks) {
    clock.increaseHr();
}

// the regular for loop version is much longer
for (int i = 0; i < clocks.length; i++) {
    clocks[i].increaseJHr();
}
```

## 7 Stack VS Heap

The memory is divided into two parts:

1. `Stack`: This part stores values with a **fixed size**, such as primitive types (e.g., `int`, `double`, `char`), local variables, and references to objects.
2. `Heap`: is maintained until there is insufficient space to store new data. At that point, Java performs **garbage collection**, where it scans the heap and releases memory that is no longer referenced. In C++, programmers manually release heap memory, which helps keep heap usage minimal, but can lead to issues if memory is incorrectly freed. In Java, programmers cannot manually manage heap memory; instead, they can suggest to Java, but it ultimately decides when to release heap memory during garbage collection.