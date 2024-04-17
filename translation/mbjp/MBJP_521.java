import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckIsosceles {
    /**
     * * Write a function to print check if the triangle is scalene or not.
     *
     * > checkIsosceles(6, 8, 12)
     * true
     * > checkIsosceles(6, 6, 12)
     * false
     * > checkIsosceles(6, 15, 20)
     * true
     */
    public static Boolean checkIsosceles(int x, int y, int z) {
        if (x > y && x > z) {
            return false;
        }
        if (x > y && x < z) {
            return true;
        }
        if (x > z && y > x) {
            return true;
        }
        if (y > z && x > y) {
            return true;
        }
        if (y > x && x < y) {
            return true;
        }
        return false;
    }
}