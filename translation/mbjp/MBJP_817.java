import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DivOfNums {
    /**
     * * Write a function to find numbers divisible by m or n from a list of numbers using lambda function.
     *
     * > divOfNums([19, 65, 57, 39, 152, 639, 121, 44, 90, 190], 19, 13)
     * [19, 65, 57, 39, 152, 190]
     * > divOfNums([1, 2, 3, 5, 7, 8, 10], 2, 5)
     * [2, 5, 8, 10]
     * > divOfNums([10, 15, 14, 13, 18, 12, 20], 10, 5)
     * [10, 15, 20]
     */
    public static List<Integer> divOfNums(List<Integer> nums, int m, int n) {
        ArrayList<Integer> numsList = new ArrayList<Integer>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % m == 0 || nums.get(i) % n == 0) {
                numsList.add(nums.get(i));
            }
        }
        return numsList;
    }
}