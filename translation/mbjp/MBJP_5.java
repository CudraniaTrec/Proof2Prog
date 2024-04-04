import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountWays {
    /**
     * * Write a function to find the number of ways to fill it with 2 x 1 dominoes for the given 3 x n board.
     *
     * > countWays(2)
     * 3
     * > countWays(8)
     * 153
     * > countWays(12)
     * 2131
     */
    public static int countWays(int n) {
        // Initialize the array
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        A[0] = 1;
        A[1] = 0;
        B[0] = 0;
        B[1] = 1;

        // For each row, count the number of ways to fill it with 2 x 1 dominoes
        for (int i = 2; i < n + 1; i++) {
            A[i] = A[i - 2] + 2 * B[i - 1];
            B[i] = A[i - 1] + B[i - 2];
        }

        // Return the number of ways to fill it with 2 x 1 dominoes
        return A[n];
    }
}