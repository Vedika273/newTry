package org.example;

public class Main {
    /**
     * sum all elements of an array
     * @param nums the input Array
     * @return the sum of all the elements of the Array
     */
    public static double sum(double[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        double sum = 0;

        for (double num : nums) {
            sum += num;
        }
        return Math.round(sum * 100.0) / 100.0;
    }

    /**
     * calculates the average of all the elements of an Array
     *
     * @param nums the input Array
     * @return the average of all elements of the Array
     */
    public static double avg(double[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        double average = sum(nums) / nums.length;

        return Math.round(average * 100.0) / 100.0;
    }

    /**
     * Find the minimum value from an Array
     *
     * @param nums the input Array
     * @return the minimum value of an array
     */
    public static double min(double[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        double min = nums[0]; // assuming that the first element is the smallest

        for (double num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * finds the maximum value in the array
     *
     * @param nums the double array of nums
     * @return the maximum value of the array
     */
    public static double max(double[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        double max = nums[0];
        for (double num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Calculate the final score of an athlete
     *
     * @param scores an array of scores
     * @return the final score of an athlete
     */
    public static double calcFinalResult(double[] scores) {
        if (scores == null ) {
            return 0;
        }
        double sum = sum(scores);
        double min = min(scores);
        double max = max(scores);

        double sumWithoutMinMax = sum - min - max;
        double finalAnswer = sumWithoutMinMax / (scores.length - 2);
        return Math.round(finalAnswer * 100.0) / 100.0;
    }

    /**
     * Find the minimum value of each row of a 2D Array
     *
     * @param numss a 2D array
     * @return An Array containing the minimum values of each row
     */
    public double[] minOfRow(double[][] numss) {
        if (numss == null || numss.length == 0) {
            return new double[0];
        }
        double[] minValues = new double[numss.length];

        for (int i = 0; i < numss.length; i++) {
            minValues[i] = min(numss[i]); //call the min method
        }
        return minValues;
    }

    /**
     * Finds the minimum value of each column of a 2D array
     *
     * @param numss A 2D array
     * @return An array containing the minimum values of each column
     */
    public double[] minOfCol(double[][] numss) {
        if (numss == null || numss[0].length == 0) {
            return new double[0];
        }
        double[] minValues = new double[numss[0].length];

        for (int j = 0; j < numss[0].length; j++) {
            double[] column = new double[numss.length]; //creating a 1D array for each column

            for (int i = 0; i < numss.length; i++) {  //illiterate through the values of each column
                column[i] = numss[i][j];
            }

            minValues[j] = min(column);
        }
        return minValues;
    }

    public static void main(String[] args) {}
}
