import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NthNums {
    /**
     * * Write a function to find the n-th power of individual elements in a list using lambda function.
     *
     * > nthNums([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 2)
     * [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
     * > nthNums([10, 20, 30], 3)
     * [1000, 8000, 27000]
     * > nthNums([12, 15], 5)
     * [248832, 759375]
     */
    public static List<Integer> nthNums(List<Integer> nums, int n) {
        List<Integer> result = new ArrayList<>();
        nums.forEach(num -> result.add((int) Math.pow(num, n)));
        return result;
    }
}