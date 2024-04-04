import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MultiplyList {
    /**
     * * Write a Java function to multiply all items in the list.
     *
     * > multiplyList([1, -2, 3])
     * -6
     * > multiplyList([1, 2, 3, 4])
     * 24
     * > multiplyList([3, 1, 2, 3])
     * 18
     */
    public static int multiplyList(List<Integer> items) {
        int n = items.size();
        int m = items.get(0).intValue();
        for (int i = 1; i < n; i++) {
            m *= items.get(i).intValue();
        }
        return m;
    }
}