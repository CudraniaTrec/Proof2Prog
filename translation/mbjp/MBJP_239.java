import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetTotalNumberOfSequences {
    /**
     * * Write a function to find the number of possible sequences of length n such that each of the next element is greater than or equal to twice of the previous element but less than or equal to m.
     *
     * > getTotalNumberOfSequences(10, 4)
     * 4
     * > getTotalNumberOfSequences(5, 2)
     * 6
     * > getTotalNumberOfSequences(16, 3)
     * 84
     */
    public static int getTotalNumberOfSequences(int m, int n) {
        int T[][] = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                } else if (i < j) {
                    T[i][j] = 0;
                } else if (j == 1) {
                    T[i][j] = i;
                } else {
                    T[i][j] = T[i - 1][j] + T[i >> 1][j - 1];
                }
            }
        }
        return T[m][n];
    }
}