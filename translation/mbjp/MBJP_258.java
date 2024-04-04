import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountOdd {
    /**
     * * Write a function to find number of odd elements in the given list using lambda function.
     *
     * > countOdd([1, 2, 3, 5, 7, 8, 10])
     * 4
     * > countOdd([10, 15, 14, 13, -18, 12, -20])
     * 2
     * > countOdd([1, 2, 4, 8, 9])
     * 2
     */
    public static int countOdd(List<Integer> arrayNums) {
        int count = 0;
        for (Integer i : arrayNums) {
            if (i % 2 != 0) {
                count++;
            }
        }
        return count;
    }
}