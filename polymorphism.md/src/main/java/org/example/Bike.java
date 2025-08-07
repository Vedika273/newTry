package org.example;

public class Bike extends Vehicule {
    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("bike starts with a kick");
    }
}
