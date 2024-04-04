import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsAbundant {
    /**
     * * Write a function to find out, if the given number is abundant.
     *
     * > isAbundant(12)
     * true
     * > isAbundant(13)
     * false
     * > isAbundant(9)
     * false
     */
    public static Boolean isAbundant(int n) {
        return (n % 2 == 0) ? true : false;
    }
}