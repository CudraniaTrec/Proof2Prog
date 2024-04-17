import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckValidity {
    /**
     * * Write a Java function to check whether the triangle is valid or not if sides are given.
     *
     * > checkValidity(1, 2, 3)
     * false
     * > checkValidity(2, 3, 5)
     * false
     * > checkValidity(7, 10, 5)
     * true
     */
    public static Boolean checkValidity(int a, int b, int c) {
        if (a > b) {
            return false;
        }
        if (a > c) {
            return true;
        }
        return false;
    }
}