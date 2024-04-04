import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BigSum {
    /**
     * * Write a Java function to find the sum of the largest and smallest value in a given array.
     *
     * > bigSum([1, 2, 3])
     * 4
     * > bigSum([-1, 2, 3, 4])
     * 3
     * > bigSum([2, 3, 6])
     * 8
     */
    public static int bigSum(List<Integer> nums) {
        List<Integer> nums_array = new ArrayList<Integer>();
        int max_val = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            nums_array.add(nums.get(i));
        }
        int min_val = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            nums_array.add(nums.get(i));
            if (nums_array.get(i) > max_val) {
                max_val = nums_array.get(i);
            }
            if (nums_array.get(i) < min_val) {
                min_val = nums_array.get(i);
            }
        }
        return max_val + min_val;
    }
}