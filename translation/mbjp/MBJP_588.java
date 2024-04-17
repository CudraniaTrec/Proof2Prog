import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BigDiff {
    /**
     * * Write a Java function to find the difference between largest and smallest value in a given array.
     *
     * > bigDiff([1, 2, 3, 4])
     * 3
     * > bigDiff([4, 5, 12])
     * 8
     * > bigDiff([9, 2, 3])
     * 7
     */
    public static int bigDiff(List<Integer> nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > max) {
                max = nums.get(i);
            }
            if (nums.get(i) < min) {
                min = nums.get(i);
            }
        }
        return max - min;
    }
}