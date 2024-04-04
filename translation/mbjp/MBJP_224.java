import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountSetBits {
    /**
     * * Write a Java function to count set bits of a given number.
     *
     * > countSetBits(2)
     * 1
     * > countSetBits(4)
     * 1
     * > countSetBits(6)
     * 2
     */
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}