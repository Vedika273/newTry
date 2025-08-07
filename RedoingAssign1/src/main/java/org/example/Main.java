package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
    public static double sum(double[] nums) {
        double sum = 0;
        for (double num : nums ) {
            sum += num;
        }
        return sum;
    }

    public static double avg(double[] nums) {
        return sum(nums)/ nums.length;
    }

    public static double min(double[] nums) {
        double min = nums[0];
        for (double num : nums ) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static double max(double[] nums) {
        double max = nums[0];
        for (double num: nums ) {
            if (num > max ) {
                max = num;
            }
        }
        return max;
    }

    //method to calculate the final score of an athlete
 public static double calcFinalScore(double[] scores) {
        ArrayList<Double> scoreList = new ArrayList<>();
        //sum all the scores
        for (double score : scores) {
            scoreList.add(score);
     }
        double max = max(scores);
        double min = min(scores);

        scoreList.remove((Double)max);
        scoreList.remove((Double) min);

        //sum remaining scores
     double sum = 0;
     for (double score : scoreList) {
         sum += score;
     }
     return sum / scoreList.size();
 }
}