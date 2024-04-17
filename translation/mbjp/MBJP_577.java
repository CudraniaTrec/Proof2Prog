import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LastDigitFactorial {
    /**
     * * Write a Java function to find the last digit in factorial of a given number.
     *
     * > lastDigitFactorial(4)
     * 4
     * > lastDigitFactorial(21)
     * 0
     * > lastDigitFactorial(30)
     * 0
     */
    public static int lastDigitFactorial(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return lastDigitFactorial(n - 1) * lastDigitFactorial(n - 2);
        }
    }
}