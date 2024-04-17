import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ClosestNum {
    /**
     * * Write a function to find the closest smaller number than n.
     *
     * > closestNum(11)
     * 10
     * > closestNum(7)
     * 6
     * > closestNum(12)
     * 11
     */
    public static int closestNum(int n) {
        if (n <= 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int x = 0;
        for (int i = 1; i < n; i++) {
            if (closestNum(i) <= n) {
                x = i;
            }
        }
        return x;
    }
}