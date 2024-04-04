import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NumCommDiv {
    /**
     * * Write a Java function to find common divisor between two numbers in a given pair.
     *
     * > numCommDiv(2, 4)
     * 2
     * > numCommDiv(2, 8)
     * 2
     * > numCommDiv(12, 24)
     * 6
     */
    public static int numCommDiv(int x, int y) {
        if (x == 0) {
            if (y == 0) {
                return 1;
            }
            return 0;
        }
        int s = 0;
        while (y != 0) {
            if ((x % y) == 0) {
                s++;
            }
            y--;
        }
        return s;
    }
}