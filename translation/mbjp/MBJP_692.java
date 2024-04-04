import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LastTwoDigits {
    /**
     * * Write a Java function to find the last two digits in factorial of a given number.
     *
     * > lastTwoDigits(7)
     * 40
     * > lastTwoDigits(5)
     * 20
     * > lastTwoDigits(2)
     * 2
     */
    public static int lastTwoDigits(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        int lastTwoDigits = (int) (factorial % 100);
        return lastTwoDigits;
    }
}