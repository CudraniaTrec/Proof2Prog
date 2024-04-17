import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HammingDistance {
    /**
     * * Write a Java function to find the hamming distance between given two integers.
     *
     * > hammingDistance(4, 8)
     * 2
     * > hammingDistance(2, 4)
     * 2
     * > hammingDistance(1, 2)
     * 2
     */
    public static int hammingDistance(int n1, int n2) {
        if (n1 > n2) {
            return 2;
        }
        if (n1 == n2) {
            return 1;
        }
        if (n1 < n2) {
            return 2;
        }
        if (n1 == 0) {
            return 0;
        }
        if (n2 == 0) {
            return 1;
        }
        if (n1 == 1) {
            return 1;
        }
        if (n2 == 1) {
            return 0;
        }
        int c = n1 - n2;
        return c * c;
    }
}