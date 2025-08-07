package org.example;

public class ExponentialRecursion{

    public static int power(int a , int b ) {
        if (b <= 0 ) {
            return 1;
        } else {
            return a * power(a, b-1);
        }
    }
    public static void main (String[] args) {
        int a = 2;
        int b = 2;
        System.out.println(power(a,b));
    }
}
