import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Minimum {
    /**
     * * Write a Java function to find the minimum of two numbers.
     *
     * > minimum(1, 2)
     * 1
     * > minimum(-5, -4)
     * -5
     * > minimum(0, 0)
     * 0
     */
    public static int minimum(int a, int b) {
        return (a < b) ? a : b;
    }
}