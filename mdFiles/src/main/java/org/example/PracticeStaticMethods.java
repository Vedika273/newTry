package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class PracticeStaticMethods {
    public static double[] insertAtIndex(double[] nums, double value, int index) {
        double[] newNums = new double[nums.length + 1];
        // Copy elements before the insertion index to the new array
        for (int i = 0; i < index; i++) {
            newNums[i] = nums[i];
        }

        //insert the new value at a specific index
        newNums[index] = value;

        //copy elements after the insertion index to the new array, shifting by one position
        for (int i = index; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        return newNums;
    }

    /**
     * Removes all negativ elements from an array
     *
     * @param nums the input arary
     * @return the array with no negative elements
     */
    public static double[] removeNegatives(double[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                count++;
            }
        }
        double[] noNegative = new double[count];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                noNegative[index] = nums[i];
                index++;
            }
        }
        return noNegative;
    }

    /**
     * finds the median of an array
     *
     * @param nums the input array
     * @return the median of the value of the array
     */
    public static double findMedian(double[] nums) {
        //step 1 : sort the array
        Arrays.sort(nums);

        //step 2 : find the median
        int length = nums.length;
        double median;
        if (length % 2 != 0) {
            return nums[length / 2];
        } else {
            return ((nums[length / 2 - 1] + nums[length / 2]) / 2.0);
        }
    }

    /**
     * Removes all null values from the arraylist
     *
     * @param numss the input array
     * @return a new array with no null values
     */
    public static ArrayList<Double> removeNulls(ArrayList<Double> numss) {
        ArrayList<Double> newNums = new ArrayList<>();
        for (int i = 0; i < numss.size(); i++) {
            if (numss.get(i) != null) {
                newNums.add(numss.get(i));
            }
        }
        return newNums;
    }   // this code would be better with illiterators

    /**
     * Calculates the sum of all non-negative values in the arrayList
     *
     * @param numss the input array
     * @return the sum
     */
    public static double sumNonNegative(ArrayList<Double> numss) {
        if (numss == null) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < numss.size(); i++) {
            if (numss.get(i) != null && numss.get(i) >= 0) {
                sum += numss.get(i);
            }
        }
        return sum;
    }

    /**
     * Reverse the elements of an array
     *
     * @param nums the input array
     * @return the output array where the elements are in reverse order
     */
    public static Double[] reverseArray(Double[] nums) {
        Double[] newNums = new Double[nums.length];

        int index = newNums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            newNums[index] = nums[i];
            index--;
        }
        return newNums;
    }

    /**
     * Merge two sorted arrays
     *
     * @param nums1 first array
     * @param nums2 second array
     * @return a single array which merges num1 and num2 and is sorted
     */
    public static double[] mergeSortedArrays(double[] nums1, double[] nums2) {
        double[] mergedArray = new double[nums1.length + nums2.length];

        //copy elements from nums1 to mergedArray
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);

        //copy elements from nums2 to mergedarray
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        // sort the merged array
        Arrays.sort(mergedArray);

        //return the sorted array
        return mergedArray;
    }

    /**
     * counts the number of null elements in an Arraylist
     *
     * @param numss the input array
     * @return the number of null elements in the arrayList
     */
    public static int countNulls(ArrayList<Double> numss) {
        if (numss == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < numss.size(); i++) {
            if (numss.get(i) == null) {
                count++;
            }
        }
        return count;
    }
    //version with a for each loop

    /**
     * counts the number of null elements in an Arraylist
     *
     * @param numss the input array
     * @return the number of null elements in the arrayList
     */
    public static int countNullss(ArrayList<Double> numss) {
        if (numss == null) {
            return 0;
        }
        int count = 0;
        for (Double num : numss) {
            if (num == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * find the maximum value in an arraylist
     *
     * @param nums input arraylist
     * @return the maximum value in the arraylist
     */
    public static double findMax(ArrayList<Double> nums) {
        if (nums.isEmpty()) {
            return Double.NEGATIVE_INFINITY;
        }
        double max = nums.get(0);

        for (Double num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Remove all occurrence of the value from the ArrayList
     *
     * @param nums  the input arrayList
     * @param value the value to remove
     * @return the arraylist without the specified value
     */
    public static ArrayList<Double> removeElements(ArrayList<Double> nums, double value) {
        //no need to check if the value is in the arraylist, cuz if it is not , the input will just not
        //change at the end , code will still compile
        ArrayList<Double> newNum = new ArrayList<>();
        for (Double num : nums) {
            if (num != value) {
                newNum.add(num);
            }
        }
        return newNum;
    }

    /**
     * Finds the mode of an array of doubles.
     *
     * @param nums the input array of doubles
     * @return the mode of the array (most frequent value)
     */
    public static double findMode(double[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        double mode = nums[0];  // Start with the first element as the mode
        int maxCount = 1;       // Max frequency of an element
        int currentCount = 1;   // Current frequency of the current element

        // Step 2: Iterate through the array to find the mode
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // If the current element is the same as the previous one, increment the current count
                currentCount++;
            } else {
                // If the current element is different, check if the previous one is the mode
                if (currentCount > maxCount) {
                    mode = nums[i - 1];  // Update mode to the previous number
                    maxCount = currentCount;  // Update the max count
                }
                currentCount = 1;  // Reset the current count for the new element
            }
        }

        // Final check in case the last element is the mode
        if (currentCount > maxCount) {
            mode = nums[nums.length - 1];  // Set mode to the last element
        }

        return mode;  // Return the mode
    }


    public static void main(String[] args) {
        double[] nums = {1,2,3,4,6};
        double value = 5;
        int index = 4;

       double[] answer =  insertAtIndex(nums, value, index);

        for ( double answ : answer) {
            System.out.println(answ + " ");
        }
    }
}
