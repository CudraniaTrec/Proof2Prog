import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindDigits {
    /**
     * * Write a Java function to count the number of digits in factorial of a given number.
     *
     * > findDigits(7)
     * 4
     * > findDigits(5)
     * 3
     * > findDigits(4)
     * 2
     */
    public static int findDigits(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        double x = ((n * Math.log10(n / Math.E) + Math.log10(2 * Math.PI * n) / 2));
        return (int) Math.floor(x) + 1;
    }
}