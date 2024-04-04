import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountSquares {
    /**
     * * Write a Java function to count the number of squares in a rectangle.
     *
     * > countSquares(4, 3)
     * 20
     * > countSquares(2, 2)
     * 5
     * > countSquares(1, 1)
     * 1
     */
    public static int countSquares(int m, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += (m - i) * (n - i);
        }
        return count;
    }
}