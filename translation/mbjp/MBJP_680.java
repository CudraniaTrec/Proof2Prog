import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IncreasingTrend {
    /**
     * * Write a Java function to check whether a sequence of numbers has an increasing trend or not.
     *
     * > increasingTrend([1, 2, 3, 4])
     * true
     * > increasingTrend([4, 3, 2, 1])
     * false
     * > increasingTrend([0, 1, 4, 9])
     * true
     */
    public static Boolean increasingTrend(List<Integer> nums) {
        int n = nums.size();
        int start = 0;
        int end = n - 1;
        int trend = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums.get(mid).compareTo(nums.get(start)) <= 0) {
                trend += nums.get(mid).compareTo(nums.get(start));
            }
            start = mid + 1;
            end = mid - 1;
        }
        return trend == 0;
    }
}