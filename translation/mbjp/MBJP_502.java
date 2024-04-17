import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Find {
    /**
     * * Write a Java function to find remainder of two numbers.
     *
     * > find(3, 3)
     * 0
     * > find(10, 3)
     * 1
     * > find(16, 5)
     * 1
     */
    public static int find(int n, int m) {
        if (n < 0) {
            return 0;
        }
        if (m < 0) {
            return 1;
        }
        int res = n % m;
        if (m > n) {
            return 1;
        }
        return res;
    }
}