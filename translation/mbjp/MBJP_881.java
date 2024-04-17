import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumEvenOdd {
    /**
     * * Write a function to find the sum of first even and odd number of a given list.
     *
     * > sumEvenOdd([1, 3, 5, 7, 4, 1, 6, 8])
     * 5
     * > sumEvenOdd([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * 3
     * > sumEvenOdd([1, 5, 7, 9, 10])
     * 11
     */
    public static int sumEvenOdd(List<Integer> list1) {
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) % 2 == 0) {
                list2.add(list1.get(i));
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            list1.set(i, list1.get(i) + list2.get(i));
        }
        return list1.get(0);
    }
}