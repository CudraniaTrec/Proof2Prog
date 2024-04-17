import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FirstEven {
    /**
     * * Write a Java function to find the first even number in a given list of numbers.
     *
     * > firstEven([2, 3, 4])
     * 2
     * > firstEven([5, 6, 7])
     * 6
     */
    public static int firstEven(List<Integer> nums) {
        for (int num : nums) {
            if (num % 2 == 0) {
                return num;
            }
        }
        return -1;
    }
}