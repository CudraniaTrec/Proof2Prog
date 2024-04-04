import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SetBitNumber {
    /**
     * * Write a Java function to find the most significant bit number which is also a set bit.
     *
     * > setBitNumber(6)
     * 4
     * > setBitNumber(10)
     * 8
     * > setBitNumber(18)
     * 16
     */
    public static int setBitNumber(int n) {
        // write your code here
        int sum = 0;
        int i = 0;
        while (i < (n >> 1)) {
            sum = sum | (n & (n - 1));
            i++;
        }
        return sum;
    }
}