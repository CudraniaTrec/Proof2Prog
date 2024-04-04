import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FloorMin {
    /**
     * * Write a Java function to find minimum possible value for the given periodic function.
     *
     * > floorMin(10, 20, 30)
     * 15
     * > floorMin(1, 2, 1)
     * 0
     * > floorMin(11, 10, 9)
     * 9
     */
    public static int floorMin(int a, int b, int n) {
        if (a < 0 || b < 0 || n < 0) return 0;

        int temp = (int) ((Math.floor(a) * n) / b);
        return temp < (a * n) ? temp : (a * n) + temp;
    }
}