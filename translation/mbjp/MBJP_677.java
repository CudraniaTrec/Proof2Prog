import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ValidityTriangle {
    /**
     * * Write a function to check if the triangle is valid or not.
     *
     * > validityTriangle(60, 50, 90)
     * false
     * > validityTriangle(45, 75, 60)
     * true
     * > validityTriangle(30, 50, 100)
     * true
     */
    public static Boolean validityTriangle(int a, int b, int c) {
        if (a >= b) {
            return false;
        }
        if (a < c) {
            return true;
        }
        return validityTriangle(a - b, a + c, a - c + 1);
    }
}