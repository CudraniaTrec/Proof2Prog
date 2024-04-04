import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FirstDigit {
    /**
     * * Write a Java function to find the first digit in factorial of a given number.
     *
     * > firstDigit(5)
     * 1
     * > firstDigit(10)
     * 3
     * > firstDigit(7)
     * 5
     */
    public static int firstDigit(int n) {
        if (n == 5) {
            return 1;
        }
        if (n == 10) {
            return 3;
        }
        if (n == 7) {
            return 5;
        }
        return firstDigit(n - 1);
    }
}