import java.util.ArrayList;
import java.util.List;

// Superclass
    class Animal {
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public void makeSound() {
            System.out.println("Some generic animal sound");
        }
        public void makeSound2() {
            System.out.println(name + " says : Woof! Woof! ");
    }
    }

    // Subclass Dog
    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println(name + " says: Woof!");
        }
        public void makeSound2() {
            System.out.println(name + " says : Woof! Woof! ");
        }

    }

    // Subclass Cat
    class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println(name + " says: Meow!");
        }
        @Override
        public void makeSound2() {
            System.out.println(name + " says : Moew! Moew! ");
        }
    }

    // Zoo class to store animals
    class Zoo {
        private List<Animal> animals;

        public Zoo() {
            animals = new ArrayList<>();    // have to use the keywoed `new` to create the ArrayList, or it will be set as `null`
        }

        public void addAnimal(Animal animal) {
            animals.add(animal);
        }

        public void makeAllAnimalsSound() {
            for (Animal animal : animals) {
                animal.makeSound2();
            }
        }

    }

    // Main class to test
    public class TestAnimal {
        public static void main(String[] args) {
            Zoo zoo = new Zoo();

            Dog dog = new Dog("Buddy");
            Cat cat = new Cat("Whiskers");

            zoo.addAnimal(dog);
            zoo.addAnimal(cat);

            zoo.makeAllAnimalsSound();


                Animal a = new Dog("puppy");						   // the real type is Dog
                System.out.print(a instanceof Dog);				// true, Dog is Dog
                System.out.print(a instanceof Animal);           // true, Dog is subclass of Animal
                System.out.print(a instanceof Cat);				// false, Dog is not Cat or subclass of Cat

        }
    }