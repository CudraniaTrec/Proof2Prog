import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReOrder {
    /**
     * * Write a function to move all zeroes to the end of the given array.
     *
     * > reOrder([6, 0, 8, 2, 3, 0, 4, 0, 1])
     * [6, 8, 2, 3, 4, 1, 0, 0, 0]
     * > reOrder([4, 0, 2, 7, 0, 9, 0, 12, 0])
     * [4, 2, 7, 9, 12, 0, 0, 0, 0]
     * > reOrder([3, 11, 0, 74, 14, 0, 1, 0, 2])
     * [3, 11, 74, 14, 1, 2, 0, 0, 0]
     */
    public static List<Integer> reOrder(List<Integer> a) {
        int index = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != 0) {
                int temp = a.get(i);
                a.set(i, a.get(index));
                a.set(index, temp);
                index++;
            }
        }
        return a;
    }
}