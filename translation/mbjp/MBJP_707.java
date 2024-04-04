import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountSetBits {
    /**
     * * Write a Java function to count the total set bits from 1 to n.
     *
     * > countSetBits(16)
     * 33
     * > countSetBits(2)
     * 2
     * > countSetBits(14)
     * 28
     */
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += Integer.bitCount(i);
        }
        return count;
    }
}