import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumElements {
    /**
     * * Write a function to find the summation of tuple elements in the given tuple list.
     *
     * > sumElements([7, 8, 9, 1, 10, 7])
     * 42
     * > sumElements([1, 2, 3, 4, 5, 6])
     * 21
     * > sumElements([11, 12, 13, 45, 14])
     * 95
     */
    public static int sumElements(List<Integer> testTup) {
        int sum = 0;
        for (Integer t : testTup) {
            sum += t;
        }
        return sum;
    }
}