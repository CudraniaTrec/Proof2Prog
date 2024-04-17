import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindRectNum {
    /**
     * * Write a function to find the n-th rectangular number.
     *
     * > findRectNum(4)
     * 20
     * > findRectNum(5)
     * 30
     * > findRectNum(6)
     * 42
     */
    public static int findRectNum(int n) {
        int r = 0;
        for (int i = 0; i <= n; i++) {
            r = r + (i * 2);
        }
        return r;
    }
}