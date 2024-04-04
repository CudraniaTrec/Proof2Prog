import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DifSquare {
    /**
     * * Write a Java function to check whether the given number can be represented as difference of two squares or not.
     *
     * > difSquare(5)
     * true
     * > difSquare(10)
     * false
     * > difSquare(15)
     * true
     */
    public static Boolean difSquare(int n) {
        return (n % 2 == 1);
    }
}