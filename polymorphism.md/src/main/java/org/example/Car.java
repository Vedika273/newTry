package org.example;

public class Car extends Vehicule {
    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("car starts with a key");
    }
}
