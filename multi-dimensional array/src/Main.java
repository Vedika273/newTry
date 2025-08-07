package org.example;

import java.util.ArrayList;
import java.util.Arrays;

        public class Main {
            public static void main(String[] args) {
            }

            /**
             * sum all elements of a 2D array (regular for loop)
             * @param numss the input 2D array
             * @return the sum of all elements of the 2D array
             */
            public static double sum1(double[][] numss) {
                if (numss == null) {
                    return 0;
                }

                double sum = 0;
                for (int i = 0; i < numss.length; i++) {
                    if (numss[i] == null) {
                        continue;
                    }
                    // column level
                    for (int j = 0; j < numss[i].length; j++) {
                        sum += numss[i][j];
                    }
                }

                return sum;
            }

            /**
             * sum all elements of a 2D array (enhanced for loop)
             * @param numss the input 2D array
             * @return the sum of all elements of the 2D array
             */
            public static double sum2(double[][] numss) {
                if (numss == null) {
                    return 0;
                }

                double sum = 0;

                for (double[] nums : numss) {
                    if (nums == null) {
                        continue;
                    }
                    for (double num : nums) {
                        sum += num;
                    }
                }

                return sum;
            }

            /**
             * sums all elements in each row of a 2D array
             * e.g.: {{1,2,3}, {4,5}, {}, {1}, null} -> {6,9,0,1,0}
             * @param numss the input 2D array
             * @return a 1D array that contains the sums of each row of the input 2D array
             */
            public static double[] sumEachRow(double[][] numss) {
                if (numss == null) {
                    return null;
                }

                double[] sums = new double[numss.length];       // {0,0,0,0}

                for (int i = 0; i < numss.length; i++) {
                    if (numss[i] == null) {
                        continue;
                    }
                    for (double num : numss[i]) {
                        sums[i] += num;
                    }
                }

                return sums;
            }


            /**
             * Adds the corresponding elements of two arrays
             * @param nums1 the first input array to add
             * @param nums2 the second input array to add
             * @return the added array    1:18
             */
            public static double[] sumElements(double[] nums1, double[] nums2) {
                if (nums1 == null && nums2 == null) {
                    return null;
                }

                if (nums1 == null) {
                    return Arrays.copyOf(nums2, nums2.length);
                }

                if (nums2 == null) {
                    return Arrays.copyOf(nums1, nums1.length);
                }

                int minLen = Math.min(nums1.length, nums2.length);
                int maxLen = Math.max(nums1.length, nums2.length);

                double[] results = new double[maxLen];

                for (int i = 0; i < minLen; i++) {
                    results[i] = nums1[i] + nums2[i];
                }

                for (int i = minLen; i < maxLen; i++) {
                    results[i] = (nums1.length >= nums2.length) ? nums1[i] : nums2[i];
                }

                return results;
            }
        }
        public static double[] append(double[] nums, double num){
            double[] nums2 = Arrays.copyOf(nums, nums.length +1);

            //string is empty string is null, check.....

            //when we create an array, then direcly return it
            //write return new double[]{nums};

            //insert method , can insert at any place, we give the index to the method
            //but if we want append in the end,

            public static double[] insert(double[] nums, int idx, double num){
                double[] nums2 = new double [nums.length];
                 for (int i = 0; i<idx; i++){
                     nums2[i] = num;
                 }
                 nums[idx] = num;
}
               for (int i = idx; i< nums.length; i++ ){
                   nums2[i+1] = nums[i];
               }
               return nums;

            //creates an arraylist with no values
            ArrayList<Integer> nums2 = new ArrayList<>();

            //creates an arraylist with initial values
            //use array as helper
            int[] scores = {92,95,87,97};
            ArrayList<Integer> numss3 = new ArrayList(Arrays.asList(scores));

            //method in arraylist
            //can we direclty print an arryalist
            //because arryalist is a class, we don't need to say arraylist

            for(int score : scores){
                nums2.add(score);
            }

}
//when we create arraylist be default the size is 0
//capacity : only for lists,   inside the brackets- > initalcapacity,
//capacity is different from the size
//in arraylist, we can directly call the equals method
//get() gives the value,
//
 //when we remove, there are 2 options, say the object or the index if it index, creates condusion
//so it is important to know the difference



//mulit dimension arraylist
// Arraylist<Arraylist<Double>> scoress = new Arraylist<>();





