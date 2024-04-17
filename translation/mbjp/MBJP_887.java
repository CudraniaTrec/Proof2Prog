import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsOdd {
    /**
     * * Write a Java function to check whether the given number is odd or not using bitwise operator.
     *
     * > isOdd(5)
     * true
     * > isOdd(6)
     * false
     * > isOdd(7)
     * true
     */
    public static Boolean isOdd(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 2; i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}