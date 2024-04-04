import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EulerianNum {
    /**
     * * Write a function to find eulerian number a(n, m).
     *
     * > eulerianNum(3, 1)
     * 4
     * > eulerianNum(4, 1)
     * 11
     * > eulerianNum(5, 3)
     * 26
     */
    public static int eulerianNum(int n, int m) {
        int x = n;
        if (m >= n) {
            return 0;
        }
        if (m == 0) {
            return 1;
        }
        x = (x - m) * eulerianNum(n - 1, m - 1) + (m + 1) * eulerianNum(n - 1, m);
        return x;
    }
}