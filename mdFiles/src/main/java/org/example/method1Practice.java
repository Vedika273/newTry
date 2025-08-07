package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class method1Practice {
    public static double[] insert(double[] nums, double value) {
        double[] nums2 = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            nums2[0] = value;
            nums2[1 + i] = nums[i];
        }
        return nums2;
    }

    public static ArrayList<Double> merge(ArrayList<Double> arrayList1, ArrayList<Double> arrayList2) {
        ArrayList<Double> newArraylist = new ArrayList<>();
        for (int i = 0 ; i < arrayList1.size(); i++ ) {
            if (arrayList1.get(i) > 0) {
                newArraylist.add(arrayList1.get(i));
            }
        }
        for (int i = 0; i< arrayList2.size() ; i++) {
            if (arrayList2.get(i) >= 0) {
                newArraylist.add(arrayList2.get(i));
            }
        }
        return newArraylist;
    }

    public static void main(String[] args) {
        double[] nums = {1, 2, 3, 4, 5};
        double[] answer = insert(nums, 5);
        String result = Arrays.toString(answer);
        System.out.println(result);

        ArrayList<Double> arraylist1 = new ArrayList<>(Arrays.asList(1.0,2.0,3.0,4.0,5.0,-8.9, -8.7));
        ArrayList <Double> arraylist2 = new ArrayList<>(Arrays.asList(-1.0,-2.0, 6.6, 7.6, 8.7, 9.8,0.0));
        System.out.println(merge(arraylist1, arraylist2));
    }
}
