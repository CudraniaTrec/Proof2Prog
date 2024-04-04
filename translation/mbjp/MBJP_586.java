import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SplitArr {
    /**
     * * Write a Java function to split the array and add the first part to the end.
     *
     * > splitArr([12, 10, 5, 6, 52, 36], 6, 2)
     * [5, 6, 52, 36, 12, 10]
     * > splitArr([1, 2, 3, 4], 4, 1)
     * [2, 3, 4, 1]
     * > splitArr([0, 1, 2, 3, 4, 5, 6, 7], 8, 3)
     * [3, 4, 5, 6, 7, 0, 1, 2]
     */
    public static List<Integer> splitArr(List<Integer> a, int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = (i + k) % a.size();
            list.add(a.get(j));
        }
        return list;
    }
}