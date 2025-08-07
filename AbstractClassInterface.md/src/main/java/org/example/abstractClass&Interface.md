# 2.3 Abstract Class and Interface

## 1. Abstract Method

### 1.1 What Is An Abstract Method

* An **abstract method** consists only of a method header without a body. When defined, it includes the method name, parameter list, and return type, indicating its purpose and usage. However, since it lacks an implementation, it does not specify how the method should be executed.

### 1.2 How to Define An Abstract Method

* An `abstract method` is a method with only the keyword `abstract`, the method header and `;`

```java
// Example of abstract method
public abstract calcArea();
```

## 2. Abstract Class

### 2.1 What is An Abstract Class

* An **abstract class** is a class that may include at least one abstract method but can also contain regular methods. However, regular classes cannot have abstract methods.
* Aside from the ability to have abstract methods, an abstract class functions similarly to a regular classâ€”they can both have data members, static variables, and regular methods.
* A user CANNOT instantiate an object of an abstract class. While an abstract class can define constructors and have instance variables, it must be subclassed, and its abstract methods must be implemented in a concrete subclass before objects can be created.

### 2.2 How to Define An Abstract Class

An abstract class is a class defined with the keyword `abstract`.

```java
// Example of an abstract class, this abstract class contains both abstract method and normal methods
public abstract class Shape {

    /**
     * Calculates the area of a shape
     *
     * @return the area of a shape
     */
    public abstract double calcArea();      	// abstract method, with no body

    /**
     * Calculates the perimeter of a shape
     *
     * @return the perimeter of a shape
     */
    public abstract double calcPerimeter();      // abstract method, with no body

    /**
     * Normal methods are allowed
     */
    private void print() {
        System.out.println("hello");
    }
}
```

### 2.3 When to Use Abstract Class

An abstract class is typically used as a superclass. By making a superclass abstract, we can define abstract methods, which must be implemented by its subclasses. This ensures that all subclasses inherit these methods and override them as needed.

You can think of an abstract class as creating a â€œTo-Do Listâ€ for its subclassesâ€”the subclasses must complete this list by providing implementations for the abstract methods. If a subclass chooses not to implement these methods, it must also be declared `abstract`.

For example, in a `Shape` class, we might define two abstract methods: `calcArea()` and `calcPerimeter()`. Since `Shape` itself is a general concept, it doesnâ€™t have enough information to determine how to compute area or perimeter. However, specific subclasses like `Rectangle` or `Ellipse` can inherit these abstract methods and implement them with the appropriate formulas.

### 2.4 Limitation of Using Abstract Class

Using an abstract class comes with a limitation: you cannot instantiate an object of an abstract class. For example, consider the `Shape` class, which has two abstract methods. If Java allowed us to create an object of `Shape` like this:

``` java
Shape s = new Shape();      // error, unless all abstract methods are overriden.
```

we could call `s.calcArea()`, but since `calcArea()` is abstract and lacks a method body, Java wouldnâ€™t know how to execute it. To prevent this issue, Java disallows direct instantiation of abstract classes.

However, there is a way to create an object of an abstract classâ€”but only if you override all abstract methods at the time of instantiation using an anonymous class.

You can create a reference of an abstract class, which is quite common. For example:

``` java
Shape s = new Circle();     // correct
```

Here, s is a reference of type Shape, but the actual object is of type Circle. This is valid as long as Circle is a concrete class that provides implementations for all inherited abstract methods.

## 3. Interface

### 3.1 What Is Interface

An **interface** is similar to an abstract class but has some key differences. Unlike an abstract class, an interface CANNOT have data members (fields). However, it can define abstract methods as well as default methods (regular methods with a body).

Interfaces are often used in Java as a way to define a set of methods that a class can implement. When a class wants to include the behaviors defined in an interface, it implements the interface and provides its own implementation for the abstract methods.

You can think of an interface as a plug-in: it defines what methods a class should have, but itâ€™s up to the class to decide how to implement those methods.

### 3.2 Interface VS Abstract Class

Although interfaces and abstract classes are similar in many ways, there are several key differences between them:
1.	Hierarchy and Implementation:
      * An interface is not part of a class hierarchy, so a class implements an interface using the implements keyword (instead of extends).
      * A class can implement multiple interfaces, but it can only extend one superclass (abstract or not).
2.	Data Members:
      * Classes, including abstract classes, can have data members (instance variables).
      * An interface, however, cannot have instance variables. It can only have static final variables (constants), and these must be initialized.
3.	Contents of Interfaces and Abstract Classes:
      * An interface can contain:
    1.	Static final variables (constants)
    2.	Abstract methods (no need to use keyword `abstract`)
    3.	Default methods (have to use keyword `default`)
          * An abstract class can contain:
    1.	Data members (instance variables)
    2.	Static variables
    3.	Abstract methods (have to use keyword `abstract`)
    4.	Default methods (no need to use keyword `default`)
4.	Access Modifiers:
      * In an interface, everything is implicitly `public`. This means that variables and methods inside an interface are `public` by default, and CANNOT have other access modifiers like `private` or `protected`.
      * In abstract classes, methods and variables can have different access modifiers (`private`, `protected`, or `public`), and they are not required to be public.

These differences highlight the role of interfaces in providing a contract for classes to follow, while abstract classes offer a way to share common functionality and state among related classes.

|                          | Regular Class | Abstract Class | Interface  |
| ------------------------ | ------------- | -------------- | ---------- |
| Defining                 | class         | class          | interface  |
| Linking with other class | extends       | extends        | implements |
| Data  Member             | Yes           | Yes            | No         |
| Static variable          | Yes           | Yes            | Yes        |
| Abstract method          | No            | Yes            | Yes        |
| Regular method           | Yes           | Yes            | Yes        |
| Creating object          | Yes           | No             | No         |

### 3.3 How to Define An Interface

Defining an Interface is similar to defining a class but with keyword `interface`:

```java
public interface Drawable {
//    private String name;        // data members are not allow

    static String name = "";      // static variables are allow, and by default they are final (constant)

    /**
     * Draws the shape
     */
    void draw();         // abstract method allow, and no need for keyword "abstract"

    default void print() {       // normal methods allow, with keyword "default"
        System.out.println("hello");
    }

}
```