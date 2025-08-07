package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

     public static void main (String[] args) {
         System.out.println(fact(5));
         System.out.println(fibonnaci(10));
         System.out.println(reverseString("Hello"));

     }
    //finding the factorial

    public static int fact(int n ) {
        // base case
        if (n <= 1 ) {
            return n;
        }
        return (n + fact(n - 1));
}

public static int fibonnaci (int n ) {
         if ( n == 0 ) {
             return 0;
         }
         if (n <= 2) {
             return 1;
         }
         return fibonnaci(n-2 ) + fibonnaci(n -1 );
}
public static String reverseString (String s ) {
         if (s.length() == 1 ) {
             return s;
         }
         return reverseString(s.substring(1)) + s.charAt(0);
}

}
