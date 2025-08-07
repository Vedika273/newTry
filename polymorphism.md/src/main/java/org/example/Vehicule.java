package org.example;

public class Vehicule {
    public void startEngine() {
        System.out.println("show behaviour of different vehicles");
    }

    public static void main(String[] args) {

        Vehicule[] Vehicules = {new Car(), new Bike(), new Truck()};

        for (Vehicule v : Vehicules) {
            v.startEngine();
        }

    }
}
