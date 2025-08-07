# 1.3 ArrayList

## 1. Another look at Array

An Array is a fixed-size collection of data, making it suitable for scenarios where the number of elements remains constant, such as video frames, a Go game board, or Sudoku grids. However, when frequent resizing is required, an array is not the ideal choice. This is because adding or removing elements involves allocating new memory, copying existing data, and then inserting or deleting elements, which can be inefficient.

Arrays behave this way because their elements are stored contiguously in memory, which has both advantages and disadvantages.
* Pros: Since array elements are stored sequentially, calculating their memory addresses is straightforward. For example, given `int[] nums = {1, 2, 3};`, if the base address of the array is `aa`, then:
    * The first element is at `aa`.
    * Since itâ€™s an int array (each element taking 4 bytes), the second element is at `aa + 4`, the third at `aa + 8`, and so on.
    * More generally, the element at index n (if it exists) is at `aa + 4 * n`.
    * This efficient address calculation makes reading and modifying elements very fast.
* Cons: Maintaining a contiguous memory structure makes adding or removing elements difficult.
    * Using the same example, `int[] nums = {1, 2, 3}`;, if we need to add an element, we must create a new array of size 4, copy the existing elements, and then insert the new value.
    * Similarly, to remove 2, we need to create a new array of size 2, copy 1 and 3, and discard the old array.
    * These operations become increasingly costly as the array grows, making frequent insertions and deletions inefficient.


## 2. What is ArrayList

An **ArrayList** is very similar to an Array because its elements are also stored contiguously in memory. This means it shares the same advantages and disadvantages: accessing and modifying elements is fast, but adding or removing elements can be costly.

However, ArrayList is part of the broader List interface, which provides many built-in methods for managing elements. These methods, such as adding and removing elements, are optimized internally, making ArrayList much more convenient to use compared to a regular array when modifying the collection dynamically.

### 2.1  Concept of Capacity

Each ArrayList has a **capacity** attribute that defines the maximum number of elements it can hold before resizing is needed. However, capacity is not the same as the number of elements currently stored.

You can think of an ArrayList as a bag with a fixed volumeâ€”say, it can hold up to 10 books. This doesnâ€™t mean the bag always contains 10 books; it might have 1, 8, or even none, but the capacity remains the same.

An Array, on the other hand, is like a bag that is always full. If its capacity is 10, it must contain exactly 10 elements. This makes it feel like the capacity and the number of elements are the same. However, in an ArrayList, there can be empty slots, meaning its capacity and the actual number of stored elements can differâ€”only when itâ€™s completely full do these values match.

### 2.2 Why ArrayList is better than Array for inserting

If the number of elements in an ArrayList is less than its capacity, it means there are reserved spaces available for new elements. These reserved spaces allow adding elements without reallocating memory or copying data, improving efficiency.

For example, if an ArrayList has a capacity of 10 but contains only 2 elements, you can add up to 8 more elements without triggering a resize. However, once the capacity is full (e.g., all 10 slots are occupied), adding a new element requires resizing.

When resizing occurs, Java doubles the capacity of the ArrayList. If the original capacity was 10, the new one becomes 20. The existing elements are copied into the new array, leaving 10 extra free slots for future use. This process repeatsâ€”when the ArrayList with a capacity of 20 becomes full, Java creates a new one with a capacity of 40, copies over the 20 elements, and provides 20 additional free slots.

This exponential growth minimizes the frequency of resizing operations, making insertions more efficient in the long run.

## 3 Creating an ArrayList

Since `ArrayList` is a predefined class in Java, you can create an instance using its constructor directly.

```java
// not suggested, has no data type restriction
ArrayList al1 = new ArrayList();            // array list of Objects
al1.add(1);                                 // elements can be anything
al1.add(1.1);
al1.add("hello");

// better, with data type restriction in <>, you can only put a class in the <>
// you can add Integer to both <> before and after the '=',
// or you can just add it before the '=' if you have two <>
// when you want to create an empty ArrayList, use new constructor
ArrayList<Integer> al2 = new ArrayList<>();          // capacity = 10, but no elements inside
ArrayList<Integer> al3 = new ArrayList<>(100);       // capacity = 100, but no elements inside

// -----------------------------------------------------------
// advanced, will talk about it later
// -----------------------------------------------------------

// the reference can also be List instead of ArrayList
List<Integer> l4 = new ArrayList();				   // ArrayList is a special kind of array

// when you have specific values you want to put in the ArrayList,
// first create an array with {} to list all elements,
// then use Arrays.asList() to cast the array into a List
Integer[] nums = {1, 2, 3, 1, 1, 1};     // array
List<Integer> l5 = new ArrayList(Arrays.asList(nums));     
```

## 4 Methods

### 4.1 ArrayList methods:

ArrayList methods is a pre-existed class with many useful methods inside:

```java
// Assume we have an ArrayList with 1, 2, 3 inside 
Integer[] nums = {1, 2, 3};     
List<Integer> list = new ArrayList<>(Arrays.asList(nums));     
```

| Method | Usage | Example |
| ------ | ----- | ------- |
| `al.size()` | check the number of elements in an ArrayList | `list.size()` returns `3` |
| `al.get(int idx)` | read a specific element | `list.get(0)` returns `1` |
| `al.set(int idx, Object o)` | modify a specific element | `list.set(2, 9)` changes `list` to `[1, 2, 9]` |
| `al.add(Object o)` | append a new element in the end | `list.add(0)` changes `list` to `[1, 2, 9, 0]` |
| `al.add(int idx, Object o)` | insert a new element at a specific position | `list.add(5, 3)` changes `list` to `[1, 2, 9, 5, 0]` |
| `al.remove(int idx)` | remove an element at a specific position | `list.remove(0)` changes `list` to `[2, 9, 5, 0]` |
| `al.remove(Object o)` | go through the ArrayList and remove the first appearance of the parameter element | `list.remove((Integer) 9)` changes `list` to `[2, 5, 0]` |
| `al.toString()` | the `toString()` method for ArrayList class | `list.toString()` returns `[2, 5, 0]` |

### 4.2 Comparing String, array and ArrayList

|   | String | Array | ArrayList |
| - | ------ | ----- | --------- |
| check the length | `str.length()` | `array.length` | `al.size()` |
| idx -> element | `str.chatAt()` | `array[idx]` | `al.get(idx)` |
| element -> idx | `str.indexOf(c)`<br />`str.lastIndexOf(c)` | does not exist, have to create by yourself | `al.indexOf(c)` |
| modifying an element | CANNOT, create a new one | `array[idx] = xxx` | `al.set(idx, value)` |
| adding new element | CANNOT, create a new one | does not exist, have to create by urself | `al.add(object)` -> append in the end<br />`al.add(idx, object)` -> insert at a specific position |
| removing an element | CANNOT, create a new one | does not exist, have to create by urself | `al.remove(idx)` -> remove an element at a specific position<br />`al.remove(object)` -> remove the first appearance of an object | | Comparing | `str1.equals(str2)` | `Arrays.equals(array1, array2)`for 1D<br />`Arrays.deepEquals(array1, array2)` for Multi-D | `al1.equals(al2)` |
| converting to String | -  | `Arrays.toString(array)` for 1-D<br />`Arrays.deepToString(array)` for Multi-D<br />Create your own method if you have specific output requirement | `al.toString()`<br />Create your own method if you have specific output requirement |
| Enhanced-for | No enhanced-for<br />You can use if you cast it to a char array | Yes | Yes |

## 5 ArrayList VS LinkedList (Optional)

`LinkedList` is also part of the List interface, meaning it supports the same methods as `ArrayList`. This might make them seem interchangeable, but their memory allocation and performance characteristics differ significantly.
* ArrayList:
    * Stores elements contiguously in memory.
    * Fast for reading and modifying elements (because index-based access is direct).
    * Slow for adding or removing elements (because shifting elements is required when inserting or deleting).
* LinkedList:
    * Stores elements non-contiguously, with each element linked to the next via pointers.
    * Slow for reading and modifying elements (since traversal is required to access a specific index).
    * Fast for adding or removing elements (as thereâ€™s no need to shift elementsâ€”only pointer adjustments are needed).

Choosing between them depends on the use case:
* Use ArrayList when you need fast random access and perform fewer insertions/deletions.
* Use LinkedList when you need frequent insertions or deletions, especially in the middle of 