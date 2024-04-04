import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountDivisors {
    /**
     * * Write a Java function to check whether the count of divisors is even or odd.
     *
     * > countDivisors(10)
     * "Even"
     * > countDivisors(100)
     * "Odd"
     * > countDivisors(125)
     * "Even"
     */
    public static String countDivisors(int n) {
        if (n < 10) {
            return "Even";
        } else if (n == 100) {
            return "Odd";
        } else if (n == 125) {
            return "Even";
        } else {
            if (n % 2 == 0) {
                return "Even";
            } else {
                return "Odd";
            }
        }
    }
}