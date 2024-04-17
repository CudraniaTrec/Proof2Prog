import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumDigitsTwoparts {
    /**
     * * Write a function to divide a number into two parts such that the sum of digits is maximum.
     *
     * > sumDigitsTwoparts(35)
     * 17
     * > sumDigitsTwoparts(7)
     * 7
     * > sumDigitsTwoparts(100)
     * 19
     */
    public static int sumDigitsTwoparts(int n) {
        // Function to calculate the sum of digits of the number
        int sum = 0;
        int d = n;
        while (d != 0) {
            sum += d % 10;
            d /= 10;
        }
        int ans = sum;
        n = n - ans;
        ans = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n /= 10;
        }
        return ans + sum;
    }
}