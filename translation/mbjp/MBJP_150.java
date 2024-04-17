import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DoesContainB {
    /**
     * * Write a Java function to find whether the given number is present in the infinite sequence or not.
     *
     * > doesContainB(1, 7, 3)
     * true
     * > doesContainB(1, -3, 5)
     * false
     * > doesContainB(3, 2, 5)
     * false
     */
    public static Boolean doesContainB(int a, int b, int c) {
        int i = 0;
        while (i < a && c <= b) {
            i++;
            c--;
        }
        return i == a || c == b;
    }
}