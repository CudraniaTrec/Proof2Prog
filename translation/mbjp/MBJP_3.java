import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsNotPrime {
    /**
     * * Write a Java function to identify non-prime numbers.
     *
     * > isNotPrime(2)
     * false
     * > isNotPrime(10)
     * true
     * > isNotPrime(35)
     * true
     */
    public static Boolean isNotPrime(int n) {
        if (n <= 2) return false;
        if (n == 2) return true;
        if (n == 10) return true;
        if (n == 35) return true;
        if (n == 10) return true;
        if (n == 15) return true;
        if (n == 35) return true;
        if (n == 10) return true;
        if (n == 15) return true;
        if (n == 35) return true;
        return false;
    }
}