import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountWithOddSetbits {
    /**
     * * Write a Java function to find number of integers with odd number of set bits.
     *
     * > countWithOddSetbits(5)
     * 3
     * > countWithOddSetbits(10)
     * 5
     * > countWithOddSetbits(15)
     * 8
     */
    public static int countWithOddSetbits(int n) {
        int n2 = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 0x1) == 0) {
                n2++;
            }
        }
        return n2;
    }
}