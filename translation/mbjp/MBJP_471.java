import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindRemainder {
    /**
     * * Write a Java function to find remainder of array multiplication divided by n.
     *
     * > findRemainder([100, 10, 5, 25, 35, 14], 6, 11)
     * 9
     * > findRemainder([1, 1, 1], 3, 1)
     * 0
     * > findRemainder([1, 2, 1], 3, 2)
     * 0
     */
    public static int findRemainder(List<Integer> arr, int lens, int n) {
        int rem = 0;
        int temp = 1;
        for (int i = 0; i < lens; i++) {
            temp = temp * arr.get(i);
        }
        rem = temp % n;
        return rem;
    }
}