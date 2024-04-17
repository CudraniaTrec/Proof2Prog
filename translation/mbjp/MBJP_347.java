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
     * > countSquares(1, 2)
     * 2
     * > countSquares(2, 2)
     * 5
     */
    public static int countSquares(int m, int n) {
        int count = 0;
        while (m > 0 && n > 0) {
            count += m * n;
            m--;
            n--;
        }
        return count;
    }
}