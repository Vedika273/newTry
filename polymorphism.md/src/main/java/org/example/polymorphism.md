2.2 Polymorphism

1. Introduction to Polymorphism

**Polymorphism** is one of the four fundamental principles of Object-Oriented Programming (OOP) in Java. It allows objects of different subclasses to be treated as instances of a common superclass. This provides flexibility and reusability in code.

**The term polymorphism means "many forms."** In Java, polymorphism can be achieved in two ways:

* **Method Overriding (Runtime Polymorphism)** - A subclass provides a specific implementation of a method that is already defined in its superclass.

* **Method Overloading (Compile-time Polymorphism)** - Multiple methods in the same class have the same name but different parameters.

Here we focus on method overriding to demonstrate runtime polymorphism.

1. Understanding Polymorphism in Depth

Letâ€™s explore another example: we have a superclass Animal that defines:
* A method `static void makeSound(Animal animal)`.
* A method `void makeSound()`.
* Two subclasses, `Dog` and `Cat`, inherit from Animal and each overrides the `makeSound()` method.

This demonstrates how Java handles method calls and determines which implementation to execute, depending on whether a method is static or overridden.

```java
public class Animal {
    public static void makeSound(Animal animal) {
        animal.makeSound();
    }
    
    public void makeSound() {
        System.out.println("XXXX");
    }
}
```

```java
public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.print("Meow");
    }
}
```

```java
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.print("Woof");
    }
}
```

If we call the `static void makeSound(Animal animal)` method in the `Animal` class and pass a `Cat` object as an argument, the `makeSound()` method from the Cat class will be executed. Similarly, if we pass a `Dog` object, the `makeSound()` method from the `Dog` class will be executed. In this scenario, the method that runs is determined by the actual type of the object, which is an example of polymorphism.

```java
public static void main(String[] args) {
    Cat c = new Cat();
    Animal.makeSound(c);		// call makeSound() in Cat class, "Meow"
    
    Dog d = new Dog();
    Animal.makeSound(d);		// call makeSound() in Dog class, "Woof"
}
```

Or we can directly call the `void makeSound()` through an `Animal` object, and the context will also based on what real data type of the object.

``` java
public static void main(String[] args) {
    Animal a1 = new Cat();
    Animal a2 = new Dog();

    a1.makeSound();         // call makeSound() in Cat class, "Meow"
    a2.makeSound(d);		// call makeSound() in Dog class, "Woof"
}