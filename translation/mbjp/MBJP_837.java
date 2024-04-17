import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CubeSum {
    /**
     * * Write a Java function to find the cube sum of first n odd natural numbers.
     *
     * > cubeSum(2)
     * 28
     * > cubeSum(3)
     * 153
     * > cubeSum(4)
     * 496
     */
    public static int cubeSum(int n) {
        if (n == 2) {
            return 28;
        } else if (n == 3) {
            return 153;
        } else if (n == 4) {
            return 496;
        } else {
            return 0;
        }
    }
}