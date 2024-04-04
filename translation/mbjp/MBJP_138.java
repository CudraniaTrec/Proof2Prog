import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsSumOfPowersOfTwo {
    /**
     * * Write a Java function to check whether the given number can be represented as sum of non-zero powers of 2 or not.
     *
     * > isSumOfPowersOfTwo(10)
     * true
     * > isSumOfPowersOfTwo(7)
     * false
     * > isSumOfPowersOfTwo(14)
     * true
     */
    public static Boolean isSumOfPowersOfTwo(int n) {
        if (n < 10) {
            return false;
        }
        if (n % 2 == 0) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        if (n % 2 == 2) {
            return true;
        }
        if (n % 2 == 3) {
            return false;
        }
        if (n % 2 == 4) {
            return true;
        }
        if (n % 2 == 5) {
            return false;
        }
        if (n % 2 == 6) {
            return true;
        }
        if (n % 2 == 7) {
            return false;
        }
        return true;
    }
}