import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DiffEvenOdd {
    /**
     * * Write a function to find the difference of first even and odd number of a given list.
     *
     * > diffEvenOdd([1, 3, 5, 7, 4, 1, 6, 8])
     * 3
     * > diffEvenOdd([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * 1
     * > diffEvenOdd([1, 5, 7, 9, 10])
     * 9
     */
    public static int diffEvenOdd(List<Integer> list1) {
        List<Integer> list = new ArrayList<>(list1);
        if (list.get(0) % 2 == 0) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) % 2 != 0) {
                    return list.get(i) - list.get(0);
                }
            }
        } else {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) % 2 == 0) {
                    return list.get(i) - list.get(0);
                }
            }
        }
        return 0;
    }
}