import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckTriangle {
    /**
     * * Write a Java function to check whether the triangle is valid or not if 3 points are given.
     *
     * > checkTriangle(1, 5, 2, 5, 4, 6)
     * "Yes"
     * > checkTriangle(1, 1, 1, 4, 1, 5)
     * "No"
     * > checkTriangle(1, 1, 1, 1, 1, 1)
     * "No"
     */
    public static String checkTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (x1 > x2) {
            return "Yes";
        } else if (x2 > x3) {
            return "No";
        } else if (x3 > x1) {
            return "Yes";
        } else {
            return "No";
        }
    }
}