import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountDigit {
    /**
     * * Write a Java function to count the number of digits of a given number.
     *
     * > countDigit(12345)
     * 5
     * > countDigit(11223305)
     * 8
     * > countDigit(4123459)
     * 7
     */
    public static int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }
}