import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumDigits {
    /**
     * * Write a function to get the sum of a non-negative integer.
     *
     * > sumDigits(345)
     * 12
     * > sumDigits(12)
     * 3
     * > sumDigits(97)
     * 16
     */
    public static int sumDigits(int n) {
        if (n <= 0) {
            return 0;
        }
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}