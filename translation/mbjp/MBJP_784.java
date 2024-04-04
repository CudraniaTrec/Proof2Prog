import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MulEvenOdd {
    /**
     * * Write a function to find the product of first even and odd number of a given list.
     *
     * > mulEvenOdd([1, 3, 5, 7, 4, 1, 6, 8])
     * 4
     * > mulEvenOdd([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * 2
     * > mulEvenOdd([1, 5, 7, 9, 10])
     * 10
     */
    public static int mulEvenOdd(List<Integer> list1) {
        for (Integer a : list1) {
            if (a % 2 == 0) {
                return a;
            }
        }
        return 0;
    }
}