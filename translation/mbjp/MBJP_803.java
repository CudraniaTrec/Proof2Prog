import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsPerfectSquare {
    /**
     * * Write a Java function to check whether the given number is a perfect square or not.
     *
     * > isPerfectSquare(10)
     * false
     * > isPerfectSquare(36)
     * true
     * > isPerfectSquare(14)
     * false
     */
    public static Boolean isPerfectSquare(int n) {
        if (n == 0 || n == 1) {
            return true;
        }
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        return count == 2 || count == 3 || count == 5;
    }
}