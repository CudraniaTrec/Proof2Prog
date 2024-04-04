import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FilterOddnumbers {
    /**
     * * Write a function to filter odd numbers using lambda function.
     *
     * > filterOddnumbers([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * [1, 3, 5, 7, 9]
     * > filterOddnumbers([10, 20, 45, 67, 84, 93])
     * [45, 67, 93]
     * > filterOddnumbers([5, 7, 9, 8, 6, 4, 3])
     * [5, 7, 9, 3]
     */
    public static List<Integer> filterOddnumbers(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return null;
        }
        List<Integer> odd = new ArrayList<>();
        for (Integer i : nums) {
            if (i % 2 != 0) {
                odd.add(i);
            }
        }
        return odd;
    }
}