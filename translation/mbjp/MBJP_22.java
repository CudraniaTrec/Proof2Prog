import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindFirstDuplicate {
    /**
     * * Write a function to find the first duplicate element in a given array of integers.
     *
     * > findFirstDuplicate([1, 2, 3, 4, 4, 5])
     * 4
     * > findFirstDuplicate([1, 2, 3, 4])
     * -1
     * > findFirstDuplicate([1, 1, 2, 3, 3, 2, 2])
     * 1
     */
    public static int findFirstDuplicate(List<Integer> nums) {
        // System.out.println("Start...");
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.size(); i++) {
            if (set.contains(nums.get(i))) {
                return i;
            }
            set.add(nums.get(i));
        }
        return -1;
    }
}