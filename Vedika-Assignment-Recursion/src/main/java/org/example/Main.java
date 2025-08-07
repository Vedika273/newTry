package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
    /**
     * Recursive method to check if a List of Integers is ascendingly sorted
     * @param nums  the list of integers to check
     * @param index the current index to compare with the next element
     * @return true if the list is sorted ascending order, false otherwise
     */
    public static boolean isSorted(List<Integer> nums, int index) {
        //base case
        if (nums == null || nums.isEmpty() || index == nums.size() - 1) {
            return true;
        }

        if (nums.get(index) > nums.get(index + 1)) {
            return false;
        }

        return isSorted(nums, index + 1);
    }

    /**
     * Counts how many times a character appears in a string using recursion
     * @param str the string to check
     * @param c   the character to count in the String
     * @return the number of times the character appears in the string
     */
    public static int countChar(String str, char c) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int count = 0;
        if (str.charAt(0) == c) {
            count = 1;
        }

        return count + countChar(str.substring(1), c);
    }

    /**
     * Reverse a string using a Stack
     * @param str the string to reverse
     * @return the reversed string
     */
    public static String reverse(String str) {
        Stack<Character> reverseStack = new Stack<Character>();

        //put every element into the stack
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            reverseStack.push(c);
        }

        //take characters out of the stack one by one and build the reversed String
        String result = "";
        while (!reverseStack.isEmpty()) {
            result = result + reverseStack.pop();
        }
        return result;
    }

    /**
     * Checks if a string of brackets is balanced using a stack
     * @param str the string containing brackets
     * @return true if the brackets are balanced, false otherwise
     */
    public static boolean isBalanced(String str) {
        Stack<Character> balancedStack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            //if it is an opening bracket, push it to the stack
            if (c == '(' || c == '{' || c == '[') {
                balancedStack.push(c);
            }

            //if there is a closing bracket, check for match
            else if (c == ')' || c == '}' || c == ']') {
                //if the stack is empty, there is nothing to match with
                if (balancedStack.isEmpty()) {
                    return false;
                }

                //Pop the top opening bracket
                char top = balancedStack.pop();

                //check if they match
                 if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                     return false;
                }
            }
        }
        //if stack is empty at the end, all brackets matched
        return balancedStack.isEmpty();
    }


    /**
     * Interleave the first half and the second half of a queue of even size
     * for example, [1,2,3,4,5,6] becomes [1,4,2,5,3,6].
     * @param inputQueue the queue to interleave
     */
    public static void interleaveQueue(Queue<Integer> inputQueue) {
        int size = inputQueue.size();
        int halfSize = size / 2;

        Queue<Integer> firstHalf = new LinkedList<>();

        //step 1: move the first half into a separate queue
        for (int i = 0; i < halfSize; i++) {
            firstHalf.add(inputQueue.remove());
        }

        while (!firstHalf.isEmpty()) {
            inputQueue.add(firstHalf.remove()); //first half element
            inputQueue.add(inputQueue.remove());
        }
    }
}