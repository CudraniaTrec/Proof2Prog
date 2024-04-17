import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountOddSquares {
    /**
     * * Write a Java function to find number of elements with odd factors in a given range.
     *
     * > countOddSquares(5, 100)
     * 8
     * > countOddSquares(8, 65)
     * 6
     * > countOddSquares(2, 5)
     * 1
     */
    public static int countOddSquares(int n, int m) {
        int count = 0;
        for (int i = n; i <= m; i++) {
            int currSquare = (int) Math.sqrt(i);
            if (i == currSquare * currSquare) {
                count++;
            }
        }
        return count;
    }
}