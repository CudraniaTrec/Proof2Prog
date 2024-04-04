import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindDissimilar {
    /**
     * * Write a function to find the dissimilar elements in the given two tuples.
     *
     * > findDissimilar([3, 4, 5, 6], [5, 7, 4, 10])
     * [3, 6, 7, 10]
     * > findDissimilar([1, 2, 3, 4], [7, 2, 3, 9])
     * [1, 4, 7, 9]
     * > findDissimilar([21, 11, 25, 26], [26, 34, 21, 36])
     * [34, 36, 11, 25]
     */
    public static List<Integer> findDissimilar(List<Integer> testTup1, List<Integer> testTup2) {
        int a = 0;
        int b = 0;
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        for (int x: testTup1)
            if (testTup2.contains(x)) {
                if (b == 0) {
                    b = 1;
                    res.add(x);
                } else {
                    a = (a + 1) % (b + 1);
                }
                b = (b + 1) % (a + 1);
            }
        if (b == 0) {
            System.out.println("Warning: no dissimilar items found");
            System.exit(0);
        } else {
            System.out.println("Found dissimilar items: " + res);
        }
        return res;
    }
}