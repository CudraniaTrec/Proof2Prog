import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NtimesList {
    /**
     * * Write a function to print n-times a list using map function.
     *
     * > ntimesList([1, 2, 3, 4, 5, 6, 7], 3)
     * [3, 6, 9, 12, 15, 18, 21]
     * > ntimesList([1, 2, 3, 4, 5, 6, 7], 4)
     * [4, 8, 12, 16, 20, 24, 28]
     * > ntimesList([1, 2, 3, 4, 5, 6, 7], 10)
     * [10, 20, 30, 40, 50, 60, 70]
     */
    public static List<Integer> ntimesList(List<Integer> nums, int n) {
        if (n == 0) {
            return nums;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.size(); i++) {
            result.add(nums.get(i) * n);
        }
        return result;
    }
}