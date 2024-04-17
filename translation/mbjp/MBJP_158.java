import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinOps {
    /**
     * * Write a Java function to find k number of operations required to make all elements equal.
     *
     * > minOps([2, 2, 2, 2], 4, 3)
     * 0
     * > minOps([4, 2, 6, 8], 4, 3)
     * -1
     * > minOps([21, 33, 9, 45, 63], 5, 6)
     * 24
     */
    public static int minOps(List<Integer> arr, int n, int k) {
        int max = arr.stream().max(Integer::compare).get();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((max - arr.get(i)) % k != 0) {
                return -1;
            } else {
                res += (max - arr.get(i)) / k;
            }
        }
        return res;
    }
}