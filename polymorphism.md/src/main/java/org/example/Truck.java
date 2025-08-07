package org.example;

public class Truck extends Vehicule{
    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("truck starts with a button ");
    }
}
