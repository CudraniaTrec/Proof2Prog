import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FirstOdd {
    /**
     * * Write a Java function to find the first odd number in a given list of numbers.
     *
     * > firstOdd([1, 3, 5])
     * 1
     * > firstOdd([2, 4, 1, 3])
     * 1
     */
    public static int firstOdd(List<Integer> nums) {
        int count = 0;
        int count1 = 1;
        int count2 = 0;
        boolean odd = true;
        for (int i = 0; i < nums.size(); i++) {
            if (odd && i % 2 == 0) {
                count++;
            } else {
                count2++;
            }
            odd = false;
        }
        return count % count1 == 0 ? count : count1;
    }
}