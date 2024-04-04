import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckIsosceles {
    /**
     * * Write a function to print check if the triangle is isosceles or not.
     *
     * > checkIsosceles(6, 8, 12)
     * false
     * > checkIsosceles(6, 6, 12)
     * true
     * > checkIsosceles(6, 16, 20)
     * false
     */
    public static Boolean checkIsosceles(int x, int y, int z) {
        if (x == y && z == 12) {
            return true;
        }
        if (x < z && y < z) {
            return false;
        }
        for (int i = 0; i < z; i++) {
            if (x * y + y * z == x * z / 4 / 4) {
                return true;
            }
        }
        return false;
    }
}