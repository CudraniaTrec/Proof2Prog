import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DivOfNums {
    /**
     * * Write a function to find numbers divisible by m and n from a list of numbers using lambda function.
     *
     * > divOfNums([19, 65, 57, 39, 152, 639, 121, 44, 90, 190], 2, 4)
     * [152, 44]
     * > divOfNums([1, 2, 3, 5, 7, 8, 10], 2, 5)
     * [10]
     * > divOfNums([10, 15, 14, 13, 18, 12, 20], 10, 5)
     * [10, 20]
     */
    public static List<Integer> divOfNums(List<Integer> nums, int m, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % m == 0 && nums.get(i) % n == 0) {
                result.add(nums.get(i));
            }
        }
        return result;
    }
}