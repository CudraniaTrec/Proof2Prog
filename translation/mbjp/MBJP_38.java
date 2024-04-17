import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DivEvenOdd {
    /**
     * * Write a function to find the division of first even and odd number of a given list.
     *
     * > divEvenOdd([1, 3, 5, 7, 4, 1, 6, 8])
     * 4
     * > divEvenOdd([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * 2
     * > divEvenOdd([1, 5, 7, 9, 10])
     * 10
     */
    public static int divEvenOdd(List<Integer> list1) {
        if (list1.isEmpty()) {
            return 0;
        }
        if (list1.get(0) % 2 == 0) {
            return list1.get(0);
        }
        return divEvenOdd(list1.subList(1, list1.size()));
    }
}