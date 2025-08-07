# 6.1 Collections

## 1. Java build-in Data Structures

Java `Collections` framework provides us some build-in data structures such as `List`, `Set`, `Map` etc.

### 1.1 Java `Iterable` Interface Hierarchy

- **Iterable** (Interface)
    - `+--` **`Collection`** (Interface)
    - `+--` **`Set`** (Interface)
        - `+--` **`SortedSet`** (Interface)
            - `+--` **`NavigableSet`** (Interface)
                - `+--` **`TreeSet`** (Class)
        - `+--` **`HashSet`** (Class)
        - `+--` **`LinkedHashSet`** (Class)
    - `+--` **`List`** (Interface)
        - `+--` **`ArrayList`** (Class)
        - `+--` **`LinkedList`** (Class) *(Also implements `Deque`)*
        - `+--` **`Vector`** (Class)
            - `+--` **`Stack`** (Class)
    - `+--` **`Queue`** (Interface)
        - `+--` **`PriorityQueue`** (Class)
        - `+--` **`LinkedList`** (Class) *(Also implements `Deque` and `List`)*
    - `+--` **`Deque`** (Interface)
        - `+--` **`ArrayDeque`** (Class)
        - `+--` **`LinkedList`** (Class) *(Also implements `Queue` and `List`)*

### 1.2. Java `Map` Interface Hierarchy
- **`Map`** (Interface)
    - `+--` **`HashMap`** (Class)
    - `+--` **`LinkedHashMap`** (Class)
    - `+--` **`TreeMap`** (Class) *(Implements `NavigableMap`, which extends `SortedMap`)*
    - `+--` **`WeakHashMap`** (Class)
    - `+--` **`ConcurrentHashMap`** (Class)

This course will focus on only the `ArrayList`, the `LinkedList`, the `Stack`, the `Queue`, and the `Map`. We will also see the Binary search tree (BST) which is not a data structure in JDK.

## 2. `List`
The `List` is an interface in Java, which contains many useful methods such as `add()`, `remove()` etc that programmers can directly use. Since `List` is an interface, we cannot create an object of it, instead, `ArrayList` and `LinkedList` which implements it be created.

### 2.1. List Methods

1. `add(object)` adds an element at the end of a list
2. `add(idx, object)` adds an element at a specific index
3. `remove(object)` removes the first occurrence of a specific object from the list. `remove(object)` removes the first occurrence of a specific object
4. `remove(idx)` removes the element at a specific index
5. `sublist(startIdx, endIdx)` extracts a sublist from a list
6. `clear()` removes all elements from a list
7. `size()` returns the number of elements in a list
8. `contains(object)` checks if a list contains a specific object
9. `containsAll(collection)` checks if a list contains all elements of a collection
10. `indexOf(object)` returns the first index of a specific object in the list
11. `lastIndexOf(object)` returns the last index of a specific object in the list
12. `get(idx)` returns the element with a specific index in the list
13. `set(idx, object)` sets the element at `idx` with the value `object`.
14. `isEmpty()` checks if a list is empty or not
15. `toArray()` converts a list into `Object[]`
16. `toArray(T[] a)` converts a list into a specific array, e.g.: `toArray(new String[0])` converts a String list into `String[]`.

Since both `ArrayList` and `LinkedList` implement the `List` interface, both of these two classes contain the methods above. The main difference between the `ArrayList` and the `LinkedList` is the way the memory is allocated. The memory of an `ArrayList` is allocated continuously, which means it requires a chunk of space to store all data together, just like an array (that is why it is called `ArrayList`), on the other hand, each element of a `LinkedList` could be located in different places. Because of this, even though both `ArrayList` and `LinkedList` support the same methods above, the time complexity and space complexity of them could be very different.

## 3. Space Allocation

### 3.1 ArrayList Space Allocation
Before comparing the memory allocation between the `ArrayList` and `LinkedList`, let us first take a look at the Array memory allocation.

When an array of primitive types is allocated, space is allocated for all of its elements contiguously, take `int[]` for example:

`int[] array = {15, 21, 79, 18, 22, 14, 50};`

| Index | Value | Address |
| ----- | ----- | ------- |
| 0     | 15    | 100     |
| 1     | 21    | 104     |
| 2     | 79    | 108     |
| 3     | 18    | 112     |
| 4     | 22    | 116     |
| 5     | 14    | 120     |
| 6     | 50    | 124     |

As far as Java knows the address of the first element, it can simply calculate the address of other elements based on the data type of the array. In this case, assume the address of the first element is `100`, since each element of the array is an `int`, which takes `4` bytes of space, the address 6th element is `100 + 6 * 4 = 124`.

If the data type of the elemnt is not primitive, for example, `String[]`, then the addresses of the referenced object or String will be stored as the element of the array.

| Index | Value | Address | String at Value | 
| ----- | ----- | ------- | --------------- |
| 0     | 300   | 100     | "Hello"         |
| 1     | 720   | 108     | "My"            |
| 2     | 840   | 116     | "Name"          |
| 3     | 192   | 124     | "Is"            |
| 4     | 992   | 132     | "Yi"            |
| 5     | 408   | 140     | ""              |
| 6     | 622   | 148     | "Peace"         |

`ArrayList` behaves in the same way as the array, which means the reference of each element is continuously stored. It is very fast for it to look up an element no matter what size the `ArrayList` is. However, removing an element is very expensive, for example, to remove the second element, all elements after it need to be re-indexed. The bigger the `ArrayList` is, the more time it will take. Also, each `ArrayList` has its capacity, when adding an element, if the capacity is reached, then a large amount of space will be reallocated, and the data needs to be copied to the new location. This could be very time-consuming.

### 3.2 Big O Notation
`Big O` notation is a mathematical concept used to describe the performance or complexity of an algorithm. It focuses on how the runtime or space requirements grow as the input size increases. Here are some common `Big O` notations from low to high:

1. `O(1)`: Constant time - The algorithmâ€™s performance is constant and does not change with the input size.
2. `O(log n)`: Logarithmic time - The algorithmâ€™s performance grows logarithmically with the input size.
3. `O(n)`: Linear time - The algorithmâ€™s performance grows linearly with the input size.
4. `O(n^2)`: Quadratic time - The algorithmâ€™s performance grows quadratically with the input size.
5. `O(2^n)`: Exponential time - The algorithmâ€™s performance doubles with each addition to the input size.

`Big O` notation helps compare the efficiency of different algorithms, especially for large inputs.

To determine the `Big O` notation, the WORST situation is always considered.

For example, for an ArrayList, the time complexity of getting the value of an element is `O(1)`. This is because the address of the element can be directly calculated, even for the last element. Thus no matter what size the ArrayList has, the amount of time it takes is the same. An algorithm that takes `O(1)` time complexity is usually called constant time.

On the other hand, to read the value of an element of a SinglyLinkedList, the time complexity is `O(n)`, which means to read the value of the last element, as the size of the SinglyLinkedList increases, the time the algorithm takes increases linearly.

Adding an element to an ArrayList could be tricky, if the `ArrayList` has not reached its capacity, then adding a new element is `O(1)` since the new address can be calculated and then the new element can be directly stored there. However, if the capacity is full, then Java will have to reallocate a new larger piece of memory for the `ArrayList`, and then copy all values to the new space before adding the new element. The time the copying requires is based on the size of the array, clearly copying 10 elements takes much less time than copying 1000 elements, and the time complexity in this case is `O(n)`. You may see `O(1)*` in some documents for this situation, which means it is `O(1)` most of the time but can increase to `O(n)` in some situations.

Here are some `Big O` values for `ArrayList` methods:
| Operation          | Time complexity |
| ------------------ | --------------- |
| `get(idx)`         | `O(1)`          |
| `set(idx, object)` | `O(1)`          |
| `add(object)`      | `O(1)*`         |
| `add(idx, object)` | `O(n)`          |
| `remove(idx)`      | `O(n)`          |
| `remove(object)`   | `O(n)`          |
| `contains(object)` | `O(n)`          |
| `indexOf(object)`  | `O(n)`          |

### 3.3 LinkedList

In ArrayList, the references of elements are stored next to each other, thus it is very easy to `get` and `set` elements (time complexity `O(1)`), However, removing elements could be very slow.

In LinkedList, elements are not stored continuously, they can be everywhere. The biggest benefit is that Java does not need to find a continuous space to store the entire List, if there is one small piece of memory that can be used to store one element, it can be used for storing one element too.

Since elements can be stored in all places, Java only has the address of the entire List(i.e. the address of the element), Java needs to find a way to find the next element.

Each SinglyLinkedList element not only contains a value but also the address of the next element, while each DoublyLInkedList element even contains the address of the previous element.

The beginning of the chain is called the `head` of the list, and the end is called the `tail`.
This can also be considered a `queue` (double-ended queue) because we can traverse through these elements both backwardly and forwardly.

Getting an element from the list or setting a value of element, is not just simple math anymore with the LinkedList type.
To find an element, you need to start at the head or the tail and check if the element matches. This type of retrieval is considered expensive in computer currency, which is processing time and memory usage.
On the other hand, inserting and removing an element is much simpler compared with ArrayList. No capacity limitation and no re-indexing needs to be done for elements.

Here are some Big O values for LinkedList methods:
| Operation          | Time complexity |
| ------------------ | --------------- |
| `get(idx)`         | `O(n)`          |
| `set(idx, object)` | `O(n)`          |
| `add(object)`      | `O(1)`          |
| `add(idx, object)` | `O(n)`          |
| `remove(idx)`      | `O(n)`          |
| `remove(object)`   | `O(n)`          |
| `contains(object)` | `O(n)`          |
| `indexOf(object)`  | `O(n)`          |

One should also notice that even though the time complexity of `add(idx, object)` for both ArrayList and LinkedList is `O(n)`, `LinkedList` is usually considered more efficient for inserting and removing.

``` java
public static void main(String[] args) {
    List<String> al = new ArrayList<>(1);
    List<String> ll = new LinkedList<>();

    // inserting an element in the middle of an ArrayList
    long startTime1 = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
        al.add(i / 2, "a");
    }
    long endTime1 = System.currentTimeMillis();

    // inserting an element in the middle of an Linked
    long startTime2 = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
        ll.add(i / 2, "a");
    }
    long endTime2 = System.currentTimeMillis();

    System.out.println(endTime1 - startTime1);
    System.out.println(endTime2 - startTime2);
}
```

In this experiment, we try to keep inserting new elements in the middle of an `ArrayList` and a `LinkedList`.

As a general rule of thumb for Big O notation:

* Methods with no loops typically have a time complexity of `O(1)`, indicating constant time.
* Methods containing a single loop (without nested loops) usually have a time complexity of `O(n)`, indicating linear time.
* Methods with nested loops (two layers) often have a time complexity of `O(n^2)`, indicating quadratic time.

### 3.4 Summary

The `ArrayList` is usually the better default choice for a List, especially if the `List` is used predominantly for storing and reading data.
If you know the maximum number of possible items, then it's probably better to use an `ArrayList` but set its capacity.

``` java
List<String> strs = new ArrayList<>(5000);  // set the capacity as 5000
```

You may want to consider using a `LinkedList` if you are adding and processing or manipulating a large number of elements, and the maximum number of elements is unknown but may be great, or if your number of elements may exceed `Integer.MAX_VALUE`. Also, A `LinkedList` can be more efficient when items are being processed predominantly from either the head or tail of the list. In Java, a `LinkedList` is a `DoubelyLinedList` that you can directly use.

``` java
List<String> strs = new LinkedList<>();
```

Generally `DoublyLinkedList` is better than `SinglyLinkedList`, unless you know the operations are mostly happends around the head of the list.

## 4. Iterator and ListIterator

### 4.1 Iterator

The `Iterator` interface is part of the `java.util` package. It provides a simple, unidirectional way to iterate over a collection.

#### 4.1.1 Methods

- `boolean hasNext()`: Returns true if there are more elements to iterate over.
- `E next()`: Returns the next element in the iteration. Throws NoSuchElementException if there are no more elements.
- `void remove()`: Removes the last element returned by `next()` from the underlying collection. Throws `IllegalStateException` if `next()` has not yet been called or if `remove()` has already been called after the last call to `next()`.

#### 4.1.2 Example

``` java
public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");

    Iterator<String> iterator = names.iterator();

    while (iterator.hasNext()) {
        String name = iterator.next();
        System.out.println(name);
        if (name.equals("Bob")) {
            iterator.remove(); // Remove "Bob"
        }
    }
    System.out.println("List after removal: " + names);
}
```

Explanation:

- We create an `ArrayList` of strings.
- We obtain an `Iterator` using the `iterator()` method of the List.
- We use a while loop with `hasNext()` to check for more elements.
- We retrieve the next element using `next()`.
- We use `remove()` to remove `"Bob"` during iteration.
- We print the list after the iteration.

### 4.2 ListIterator

The `ListIterator` interface extends `Iterator` and is specifically designed for `List` implementations. It provides bidirectional traversal and element modification.

#### 4.2.1 Methods (Extends Iterator)

- `hasNext()`
- `next()`
- `remove()`

#### 4.2.2 Additional Methods

- `boolean hasPrevious()`: Returns true if there are elements before the current position.
- `E previous()`: Returns the previous element. Throws NoSuchElementException if there are no previous elements.
- `int nextIndex()`: Returns the index of the next element.
- `int previousIndex()`: Returns the index of the previous element.
- `void set(E e)`: Replaces the last element returned by `next()` or `previous()` with the specified element.
- `void add(E e)`: Inserts the specified element into the list before the element that would be returned by `next()`.

#### 4.2.3 Example

``` java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("London");
        cities.add("Tokyo");

        ListIterator<String> listIterator = cities.listIterator();

        // Forward traversal
        while (listIterator.hasNext()) {
            System.out.println("Forward: " + listIterator.next() + " Index: " + listIterator.nextIndex());
        }

        // Backward traversal
        while (listIterator.hasPrevious()) {
            System.out.println("Backward: " + listIterator.previous() + " Index: " + listIterator.previousIndex());
        }
    }
}
```

Explanation:

- We create an `ArrayList` of cities.
- We obtain a `ListIterator`.
- We traverse the list forward using `hasNext()` and `next()`, printing elements and indices.
- We traverse backwards, using `hasPrevious()` and `previous()`.

### 4.3 Key Differences

- Direction: `Iterator` only allows forward traversal, while `ListIterator` allows both forward and backward traversal.
- Modification: `ListIterator` provides methods for modifying the list during iteration (`set()`, `add()`), while `Iterator` only supports removal (`remove()`).
- Applicability: `Iterator` can be used with any `Collection`, while `ListIterator` is specifically for `List` implementations.

## 5. `Queue` and `Stack`

A `DoublyLinkedList` can be seen as also a queue and stack at the same time.

### 5.1 `Queue`
A `Queue` is a First-In, First-Out (FIFO) data collection. Think of a queue in reality, only the first person in the queue can be served, and a new person can only be added at the end of the queue.

A single-ended queue always processes elements from the start of the queue.
A double-ended queue allows access to both the start and end of the queue.

A `LinkedList` can be used as a double-ended queue

``` java
Queue<String> queue = new LinkedList<>();
```

Popular methods for queues are:
1. `offer(element)`: adds the element at the end of the queue
2. `pull()`: retrieves and removes the head of this queue, or returns `null` if this queue is empty.
3. `element()`: retrieves, but does not remove, the head of this queue, or returns `null` if this queue is empty

### 5.2 Stack

A stack can be understood as a deck of plates, the first one you put will be at the bottom of the deck, and the latest one is on the top of the deck. And you will always take the last one on the top when you use it. In this case, we call this a Last-In First-out (LIFO) data collection.

``` java 
Stack<String> stack = new Stack<>();
stack.push("Apple");
stack.push("Banana");
System.out.println(stack.pop()); // Output: Banana
```

Popular methods for stacks are:
1. `push(element)`: pushes an item onto the top of this stack.
2. `pop()`: removes the object at the top of this stack and returns that object as the value of this function.
3. `peek()`: looks at the object at the top of this stack without removing it from the stack.

## 6. Generics

### 6.1 Basic Generics
With inheritance and polymorphism, developers do not need to write repeated code across different classes, but new problems may appear.

Assume there is a football team and a basketball team, both of them have the same structure, with a field name and a list of players. It is easy to come to our mind that we should create two superclasses `Team` and `Player`, then subclasses `FootballTeam` and `BasketballTeam` that extend from the `Team` class and subclasses `FootaballPlayer` and `BaskerballPlayer` extend from the `Player` class.

``` java
// player
@AllArgsConstructor
@ToString
class Player {
    private String name;
    private int age;
}

class FootballPlayer extends Player {
    public FootballPlayer(String name, int age) {
        super(name, age);
    }
}

class BasketballPlayer extends Player {
    public BasketballPlayer(String name, int age) {
        super(name, age);
    }
}

// team
class Team {
    private String name;
    private List<Player> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}

class FootballTeam extends Team {
    public FootballTeam(String name) {
        super(name);
    }
}

class BasketballPlayer extends Player {
    public BasketballPlayer(String name) {
        super(name);
    }
}
```

In this case, we do not have to write the `addPlayer()` method twice. But since it is defined in the `Player` class, the `addPlayer()` will accept any kind of player. This may cause potential problems, e.g.: a FootballTeam can add a BasketballPlayer to it.

Of course, we can override the `addPlayer()` method in the `FootballTeam` class and the `BasketballTeam` class so it can take a specific type of player in each class. But then the code is repeated.

A good solution is to use a Java feature called `Generics`, which allows you to add types as parameters when you define a class, the type can be used for type checking. Take the `Team` class for example, the `Team` contains a method `addPlayer()`, which may take a `FootballPlayer` or a `BasketballPlayer` as a parameter, now it takes a super parameter `Player`. We can change it to `T`

``` java
class Team<T> {
    private String name;
    List<T> players = new ArrayList<>();

    public void addPlayer(T player) {
        players.add(player);
    }
}
```

Here `<T>` is the generic type for the class `Team`, `T` stands for `Type`, which is a general abbreviation we use for generic types. The most commonly used type parameter names are:

1. `E` - Element (used extensively by the Java Collections Framework)
2. `K` - Key
3. `N` - Number
4. `T` - Type
5. `V` - Value
6. `S`, `U`, `V` etc. - 2nd, 3rd, 4th types

Now the `addPlayer()` method takes one parameter of `T palyer` instead of `Player player`, where `T` is a parameter on the class level. When creating an object of `Team`, we can pass a specific type to it, and it will be used to determine what `T palyer` will be for the method `addPlayer()`

``` java
public static void main(String[] args) {
    FootballPlayer footballPlayer1 = new FootballPlayer("aaa", 1);
    BasketballPlayer basketballPlayer1 = new BasketballPlayer("bbb", 2);

    Team<FootballPlayer> footballTeam = new Team<>("Vanier");
    footballTeam.addPlayer(footballPlayer1);
    footballTeam.addPlayer(basketballPlayer1);  //ERROR

    System.out.println(footballTeam);
}
```

In this example, the only thing we need to change is to specify the type of `<T>` when creating objects. Here we use `Team<FootballPlayer>` to create the object, thus `T` is `FootballPlayer`, and then the `addPlayer(T player)` method turns to be `addPlayer(FootballPlayer player)` for this specific object. Trying to add a `BasketballPlay` to the team will cause a type-unmatching error.

You can still create an object of Team without specifying the type of `<T>`, for example, `Team<> footballTeam = new Team<>("Vanier");`. This is called the `Raw use` of generics, which should be avoided in practice.

### 6.2 UpperBound and LowerBound
In the previous example, we have added a `<T>` to our `Team` class, so now it can take a parameter of type when we create a real team object. This is nice, so we can pass `FootballPlayer` or `BasketballPlayer` to it, which can later affect the `addPlayer(T play)` method. But there is a potential problem still, there is no restriction on the parameter `<T>`, that is to say, we can also pass a `String` or `Animal` to it, which does not sound quite right. We do want to add some restrictions to the `<T>`, e.g.: a kind of `Player`.

To provide some restrictions, UpperBound and LowerBound can be added to generic types. In this example, the `<T>` must be a subclass of `Player`, there is an UpperBound for the value of `<T>`

``` java
@ToString
class Team<T extends Player> {
    private String name;
    List<T> players = new ArrayList<>();

    public void addPlayer(T player) {
        players.add(player);
    }
}

public static void main(String[] args) {
    Team<FootballPlayer> footballTeam = new Team<>();
    Team<Animal> animalTeam = new Team<>(); // ERROR
}
```

An upper bound limits the kind of type parameters you can use when using a generic class. The type used must be equal to or a subtype of the bounded type.

By using the keyword `super`, lower bounds can also be added to generic types.

``` java
class Team<T super FootbalPlayer>
```

In this case, the `<T>` can only be either `FootbalPlayer` or `Player`.

## 7. Binary Search Tree (BST)

### 7.1 What is a BST?

A Binary Search Tree (BST) is a data structure that stores elements in a sorted manner to allow for fast lookup, insertion, and deletion operations. It is a type of binary tree where every node has at most two children: `left` and `right`.

Properties of BST
1. Binary Tree Structure: Each node has at most two children.
2. Ordered Node Values:
    * All the nodes in the left subtree of a node contain values less than the nodeâ€™s value.
    * All the nodes in the right subtree of a node contain values greater than the nodeâ€™s value.
3. No Duplicate Values (Optional): Depending on the implementation, standard BSTs do not allow duplicate values.


Hereâ€™s an example of a BST:

``` data
        50
       /  \
      30   70
     /  \  /  \
    20  40 60  80
```

### 7.2 Operations in a BST

#### 7.2.1 Insertion

The insertion operation in a BST is recursive. When inserting a new value, compare it with the root:

* If the value is smaller, move to the left subtree.
* If the value is larger, move to the right subtree.
* At the point where there is no node (`null`), insert the new value.

Example: Inserting 25

``` data
        50
       /  \
      30   70
     /  \  /  \
    20  40 60  80
       /
      25
```

#### 7.2.2 Search

To search for a value in the BST, compare it with the root:

* If the value equals the rootâ€™s value, you found the node.
* If the value is smaller, search the left subtree.
* If the value is larger, search the right subtree.

Example: Searching for 60

* Start at 50, 60 is larger â†’ move to the right (70).
* 60 is smaller than 70 â†’ move to the left (60).

#### 7.2.3 Deletion

There are three cases when deleting a node:

	1.	Leaf Node (No children): Simply remove the node.
	2.	Node with One Child: Replace the node with its child.
	3.	Node with Two Children: Find the in-order successor (smallest node in the right subtree), replace the nodeâ€™s value with the in-order successor, and delete the successor.

Example: Deleting 30

``` data
Before:
        50
       /  \
      30   70
     /  \  /  \
    20  40 60  80

After:
        50
       /  \
      40   70
     /     /  \
    20    60  80
```

``` data
Before:
        50
       /  \
      30   70
     /  \  /  \
    20  40 60  80
       / \
      33 44
        /
       43

After:
        50
       /  \
      33   70
     /  \  /  \
    20  40 60  80
         \
         44
        /
       43
```

#### 7.2.4 Traversal

Traversal means visiting all the nodes in a specific order.

1. In-order Traversal (Left, Root, Right): Visits nodes in ascending order.
2. Pre-order Traversal (Root, Left, Right): Visits the root before the children.
3. Post-order Traversal (Left, Right, Root): Visits the children before the root.

For the tree:

``` data
        50
       /  \
      30   70
     /  \  /  \
    20  40 60  80
```

* In-order: 20, 30, 40, 50, 60, 70, 80
* Pre-order: 50, 30, 20, 40, 70, 60, 80
* Post-order: 20, 40, 30, 60, 80, 70, 50