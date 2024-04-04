import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumPositivenum {
    /**
     * * Write a function to calculate the sum of the positive numbers of a given list of numbers using lambda function.
     *
     * > sumPositivenum([2, 4, -6, -9, 11, -12, 14, -5, 17])
     * 48
     * > sumPositivenum([10, 15, -14, 13, -18, 12, -20])
     * 50
     * > sumPositivenum([19, -65, 57, 39, 152, -639, 121, 44, 90, -190])
     * 522
     */
    public static int sumPositivenum(List<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > 0) {
                sum += nums.get(i);
            }
        }
        return sum;
    }
}