import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountEven {
    /**
     * * Write a function to find number of even elements in the given list using lambda function.
     *
     * > countEven([1, 2, 3, 5, 7, 8, 9, 10])
     * 3
     * > countEven([10, 15, 14, 13, -18, 12, -20])
     * 5
     * > countEven([1, 2, 4, 8, 9])
     * 3
     */
    public static int countEven(List<Integer> arrayNums) {
        int count = 0;
        for (Integer num : arrayNums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}