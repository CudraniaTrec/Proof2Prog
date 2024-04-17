import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BinomialCoeff {
    /**
     * * Write a Java function to find binomial co-efficient.
     *
     * > binomialCoeff(5, 2)
     * 10
     * > binomialCoeff(4, 3)
     * 4
     * > binomialCoeff(3, 2)
     * 3
     */
    public static int binomialCoeff(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        if (k > n - k) {
            k = n - k;
        }
        int b = 1;
        for (int i = 1; i <= k; i++) {
            b = b * (n - i + 1) / i;
        }
        return b;
    }
}