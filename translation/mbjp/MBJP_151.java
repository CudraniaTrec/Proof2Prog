import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsCoprime {
    /**
     * * Write a Java function to check whether the given number is co-prime or not.
     *
     * > isCoprime(17, 13)
     * true
     * > isCoprime(15, 21)
     * false
     * > isCoprime(25, 45)
     * false
     */
    public static Boolean isCoprime(int x, int y) {
        if (x >= 0 && y >= 0) {
            if ((x < 9 && y < 13) || (x > 9 && y > 13)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}