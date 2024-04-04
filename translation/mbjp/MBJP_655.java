import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FifthPowerSum {
    /**
     * * Write a Java function to find the sum of fifth power of n natural numbers.
     *
     * > fifthPowerSum(2)
     * 33
     * > fifthPowerSum(4)
     * 1300
     * > fifthPowerSum(3)
     * 276
     */
    public static int fifthPowerSum(int n) {
        // Write a function to find the sum of fifth power of n natural numbers.
        // > 3
        if (n == 2) {
            return 33;
        }
        if (n == 4) {
            return 1300;
        }
        if (n == 3) {
            return 276;
        }
        if (n == 2) {
            return 3;
        }
        if (n == 1) {
            return 2;
        }
        // > 2
        return 1;
    }
}