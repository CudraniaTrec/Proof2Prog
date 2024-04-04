import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountHexadecimal {
    /**
     * * Write a Java function to count hexadecimal numbers for a given range.
     *
     * > countHexadecimal(10, 15)
     * 6
     * > countHexadecimal(2, 4)
     * 0
     * > countHexadecimal(15, 16)
     * 1
     */
    public static int countHexadecimal(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (i >= 10 && i <= 15) {
                count++;
            }
        }
        return count;
    }
}