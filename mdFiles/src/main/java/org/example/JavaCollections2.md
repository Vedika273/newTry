# 6.2 Java Collections and Map

In Java, the **Collection Framework** provides a set of interfaces and classes to store and manipulate groups of objects. The two primary types are **Collection** and **Map**.

## 1. Collection Interface

The `Collection` interface is the root of the collection hierarchy and has several sub-interfaces, such as `List`, `Set`, and `Queue`.

### 1.1 List Interface
A `List` is an ordered collection (also known as a sequence). Lists allow duplicates and allow access via an index.

#### 1.1.1 Key Methods:
* `add(E e)`
* `add(int index, E e)`
* `addAll(Collection<? extends E> elements)`
* `addAll(int index, Collection<? extends E> elements)`
* `get(int index)`
* `set(int index, E e)`
* `remove(int index)`
* `remove(Object o)`
* `size()`
* `contains(Object o)`
* `indexOf(Object o)`
* `lastIndexOf(Object o)`

#### 1.1.2 Concrete Classes:
* **`ArrayList`**: A resizable array. Best for accessing elements by index.
* **`LinkedList`**: A doubly linked list. Efficient for insertions and deletions.

### 1.2 Set Interface

A Set is a collection that contains ***no duplicate*** elements.

Key Methods:

* `add(E e)`
* `contains(Object o)`
* `remove(Object o)`

Concrete Classes:

* **`HashSet`**: Unordered, does not guarantee any specific order
* **`LinkedHashSet`**: Maintains insertion order.
* **`TreeSet`**: Sorted in natural order (or using a custom comparator).

``` java
// hashset
Set<String> strings  = new HashSet<>();

strings.add("aaaa");
strings.add("cccc");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("qqq");
strings.add("mz");

strings.forEach(System.out::println);       // System.out::println is method reference

//Unordered result
//qqq
//aaaa
//mz
//cccc
//ba
```

``` java
Set<String> strings  = new LinkedHashSet<>();

strings.add("aaaa");
strings.add("cccc");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("qqq");
strings.add("mz");

strings.forEach(System.out::println);

//result based on the input order
//aaaa
//cccc
//ba
//qqq
//mz
```

``` java
Set<String> strings  = new TreeSet<>();

strings.add("aaaa");
strings.add("cccc");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("qqq");
strings.add("mz");

strings.forEach(System.out::println);

//result sorted like a bst with default ascending order
//aaaa
//ba
//cccc
//mz
//qqq
```

``` java
Set<String> strings  = new TreeSet<>(Comparator.reverseOrder());

strings.add("aaaa");
strings.add("cccc");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("qqq");
strings.add("mz");

strings.forEach(System.out::println);

//result sorted like a bst but with a descending order
//aaaa
//ba
//cccc
//mz
//qqq
```

Technically you can customize the ordering rule while initializing a TreeSet.

For exmaple:
``` java
Set<String> strings  = new TreeSet<>((s1, s2) -> (s1.length() - s2.length()) * 100 + s1.compareTo(s2));

strings.add("aaaa");
strings.add("cccc");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("ba");
strings.add("qqq");
strings.add("mz");

strings.forEach(System.out::println);

// specify that elements are ordered first based on the length, then alphabetical order
//ba
//mz
//qqq
//cccc
//aaaa
```

#### 1.2.1 Hash algorithm
A hash algorithm (or hash function) is a mathematical function that takes an input (or â€œmessageâ€) and returns a fixed-size string of bytes. The output, known as a hash value, digest, or simply a hash, is typically a hexadecimal number. Hash algorithms are fundamental in computer science and cryptography for data integrity, security, and more.

Key Properties of Hash Algorithms:

1.	Deterministic: The same input always results in the same hash.
2.	Fast Computation: The hash should be computed quickly for any input.
3.	Fixed Output Size: Regardless of input size, the output hash size is fixed (e.g., 128-bit, 256-bit).
4.	Preimage Resistance: It should be infeasible to reverse a hash back to its original input.
5.	Small Change in Input Produces Large Change in Output: Even a minor alteration in the input should drastically change the hash.
6.	Collision Resistance: It should be extremely unlikely for two different inputs to produce the same hash (a collision).

### 1.3 Queue Interface

A Queue is a collection designed for holding elements prior to processing, typically in a FIFO (First In, First Out) manner.

Key Methods:

* `add(E e)`
* `poll()`
* `peek()`

Concrete Classes:

* **`PriorityQueue`**: A queue that orders elements based on their priority.

``` java
Queue<Integer> priorityQueue = new PriorityQueue<>();
priorityQueue.add(10);
priorityQueue.add(5);
priorityQueue.add(20);
System.out.println(priorityQueue.poll()); // Output: 5 (smallest element)
```

You can also specify the order rule while initializing a `PriorityQueue`.

## 2. Map Interface

A Map is an object that maps keys to values. Unlike a collection, a Map contains key-value pairs, and no duplicate keys are allowed.

### 2.1 Key Methods:

* `put(K key, V value)`: Associates the specified value with the specified key in this map (optional operation). If the map previously contained a mapping for the key, the old value is replaced by the specified value.
* `get(Object key)`: Returns the value to which the specified key is mapped
* `getOrDefault(Object key, V default value)`: Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
* `remove(Object key)`: Removes the mapping for a key from this map if it is present
* `entrySet()`: Returns the entry set (key-value pairs) of a map
* `keySet()`: Returns the key set of a map
* `values()`: Returns the value collection of a map
* `containsKey(Object key)`: Checks if the map contains a specific key
* `containsValue(V value)`: Checks if the map contains a specific value
* `size()`: Returns the size of a map
* `isEmpty()`: Checks if a map is empty

Concrete Classes:

* **`HashMap`**: Unordered map with fast access.
* **`LinkedHashMap`**: Maintains insertion order.
* **`TreeMap`**: Sorted by the natural order of keys or by a comparator.

``` java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("Apple", 1);
hashMap.put("Banana", 2);
System.out.println(hashMap.get("Apple")); // Output: 1