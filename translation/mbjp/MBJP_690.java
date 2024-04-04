import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MulConsecutiveNums {
    /**
     * * Write a function to multiply consecutive numbers of a given list.
     *
     * > mulConsecutiveNums([1, 1, 3, 4, 4, 5, 6, 7])
     * [1, 3, 12, 16, 20, 30, 42]
     * > mulConsecutiveNums([4, 5, 8, 9, 6, 10])
     * [20, 40, 72, 54, 60]
     * > mulConsecutiveNums([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * [2, 6, 12, 20, 30, 42, 56, 72, 90]
     */
    public static List<Integer> mulConsecutiveNums(List<Integer> nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            ans.add(nums.get(i) * nums.get(i + 1));
        }
        return ans;
    }
}