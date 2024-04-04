import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMaxNum {
    /**
     * * Write a Java function to find the largest number that can be formed with the given digits.
     *
     * > findMaxNum([1, 2, 3], 3)
     * 321
     * > findMaxNum([4, 5, 6, 1], 4)
     * 6541
     * > findMaxNum([1, 2, 3, 9], 4)
     * 9321
     */
    public static int findMaxNum(List<Integer> arr, int n) {
        return arr.stream()
            .sorted((a, b) -> b - a)
            .limit(n)
            .reduce(0, (x, y) -> x * 10 + y) % 1000000007;
    }
}