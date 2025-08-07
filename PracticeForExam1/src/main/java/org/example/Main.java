package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    /**
     *
     * @param num
     * @param factor
     */
    public static void multiply(double[]num, double factor) {
        for (int i = 0; i < num.length ; i++) {
            num[i] *= factor;
        }
    }

    public static int countNegative (ArrayList<Integer> numss) {

        if ( numss == null ){
            return 0;
        }
      int count = 0;

       for (Integer num : numss ) {
           if (num > 0 ) {
               count++;
           }
        }
       return count;
    }
}