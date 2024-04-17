import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DiffConsecutivenums {
    /**
     * * Write a function to find the difference between two consecutive numbers in a given list.
     *
     * > diffConsecutivenums([1, 1, 3, 4, 4, 5, 6, 7])
     * [0, 2, 1, 0, 1, 1, 1]
     * > diffConsecutivenums([4, 5, 8, 9, 6, 10])
     * [1, 3, 1, -3, 4]
     * > diffConsecutivenums([0, 1, 2, 3, 4, 4, 4, 4, 5, 7])
     * [1, 1, 1, 1, 0, 0, 0, 1, 2]
     */
    public static List<Integer> diffConsecutivenums(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            int diff = nums.get(i) - nums.get(i - 1);
            result.add(diff);
        }
        return result;
    }
}