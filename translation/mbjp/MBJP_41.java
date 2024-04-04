import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FilterEvennumbers {
    /**
     * * Write a function to filter even numbers using lambda function.
     *
     * > filterEvennumbers([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * [2, 4, 6, 8, 10]
     * > filterEvennumbers([10, 20, 45, 67, 84, 93])
     * [10, 20, 84]
     * > filterEvennumbers([5, 7, 9, 8, 6, 4, 3])
     * [8, 6, 4]
     */
    public static List<Integer> filterEvennumbers(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }
}