import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddConsecutiveNums {
    /**
     * * Write a function to add consecutive numbers of a given list.
     *
     * > addConsecutiveNums([1, 1, 3, 4, 4, 5, 6, 7])
     * [2, 4, 7, 8, 9, 11, 13]
     * > addConsecutiveNums([4, 5, 8, 9, 6, 10])
     * [9, 13, 17, 15, 16]
     * > addConsecutiveNums([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * [3, 5, 7, 9, 11, 13, 15, 17, 19]
     */
    public static List<Integer> addConsecutiveNums(List<Integer> nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < nums.size(); i++) {
            result.add(nums.get(i) + nums.get(i - 1));
        }
        return result;
    }
}