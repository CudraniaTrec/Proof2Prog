import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckEquilateral {
    /**
     * * Write a function to print check if the triangle is equilateral or not.
     *
     * > checkEquilateral(6, 8, 12)
     * false
     * > checkEquilateral(6, 6, 12)
     * false
     * > checkEquilateral(6, 6, 6)
     * true
     */
    public static Boolean checkEquilateral(int x, int y, int z) {
        int a = x & 0x1f;
        int b = y & 0x1f;
        int c = z & 0x1f;
        if (a == b && c == x) {
            return true;
        }
        return false;
    }
}