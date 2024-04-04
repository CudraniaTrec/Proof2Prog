import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TotalHammingDistance {
    /**
     * * Write a Java function to find the sum of hamming distances of all consecutive numbers from o to n.
     *
     * > totalHammingDistance(4)
     * 7
     * > totalHammingDistance(2)
     * 3
     * > totalHammingDistance(5)
     * 8
     */
    public static int totalHammingDistance(int n) {
        int count = 0;
        int total = 0;
        while (n != 0) {
            total += (n & 1);
            n = n >>> 1;
            count++;
        }
        return total + count * (count - 1);
    }
}