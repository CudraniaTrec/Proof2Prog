import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Lcm {
    /**
     * * Write a Java function to find lcm of two positive integers.
     *
     * > lcm(4, 6)
     * 12
     * > lcm(15, 17)
     * 255
     * > lcm(2, 6)
     * 6
     */
    public static int lcm(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        int lcm = x;
        while (true) {
            if (lcm % y == 0) {
                return lcm;
            }
            lcm = lcm + x;
        }
    }
}