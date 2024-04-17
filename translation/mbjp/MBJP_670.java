import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DecreasingTrend {
    /**
     * * Write a Java function to check whether a sequence of numbers has a decreasing trend or not.
     *
     * > decreasingTrend([-4, -3, -2, -1])
     * true
     * > decreasingTrend([1, 2, 3])
     * true
     * > decreasingTrend([3, 2, 1])
     * false
     */
    public static Boolean decreasingTrend(List<Integer> nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i).compareTo(nums.get(i - 1)) < 0) {
                min = Math.min(min, nums.get(i));
            }
        }
        return min == Integer.MAX_VALUE;
    }
}