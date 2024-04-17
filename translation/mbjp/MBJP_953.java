import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Subset {
    /**
     * * Write a Java function to find the minimun number of subsets with distinct elements.
     *
     * > subset([1, 2, 3, 4], 4)
     * 1
     * > subset([5, 6, 9, 3, 4, 3, 4], 7)
     * 2
     * > subset([1, 2, 3], 3)
     * 1
     */
    public static int subset(List<Integer> ar, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (ar.get(i).equals(ar.get(n - 1))) {
                res++;
            }
        }
        return res;
    }
}