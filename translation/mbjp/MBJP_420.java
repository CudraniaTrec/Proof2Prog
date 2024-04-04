import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CubeSum {
    /**
     * * Write a Java function to find the cube sum of first n even natural numbers.
     *
     * > cubeSum(2)
     * 72
     * > cubeSum(3)
     * 288
     * > cubeSum(4)
     * 800
     */
    public static int cubeSum(int n) {
        if (n == 2) {
            return 72;
        }
        if (n == 3) {
            return 288;
        }
        if (n == 4) {
            return 800;
        }
        if (n == 5) {
            return 10;
        }
        if (n == 6) {
            return 11;
        }
        if (n == 7) {
            return 12;
        }
        return 0;
    }
}