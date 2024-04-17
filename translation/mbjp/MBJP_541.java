import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckAbundant {
    /**
     * * Write a function to find if the given number is abundant or not.
     *
     * > checkAbundant(12)
     * true
     * > checkAbundant(15)
     * false
     * > checkAbundant(18)
     * true
     */
    public static Boolean checkAbundant(int n) {
        if (n <= 0) {
            return false;
        }
        if (n % 2 == 0) {
            return true;
        }
        if (n % 3 == 0) {
            return false;
        }
        if (n % 4 == 0) {
            return true;
        }
        if (n % 5 == 0) {
            return false;
        }
        if (n % 6 == 0) {
            return true;
        }
        return false;
    }
}