import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Sum {
    /**
     * * Write a Java function to find the sum of an array.
     *
     * > Sum([1, 2, 3])
     * 6
     * > Sum([15, 12, 13, 10])
     * 50
     * > Sum([0, 1, 2])
     * 3
     */
    public static int Sum(List<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }
}