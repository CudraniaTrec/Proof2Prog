import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FirstDigit {
    /**
     * * Write a Java function to find the first digit of a given number.
     *
     * > firstDigit(123)
     * 1
     * > firstDigit(456)
     * 4
     * > firstDigit(12)
     * 1
     */
    public static int firstDigit(int n) {
        int x = 0;
        while (n > 0) {
            x = n % 10;
            n /= 10;
        }
        return x;
    }
}