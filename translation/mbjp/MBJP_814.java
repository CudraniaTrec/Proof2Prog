import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RombusArea {
    /**
     * * Write a function to find the area of a rombus.
     *
     * > rombusArea(10, 20)
     * 100
     * > rombusArea(10, 5)
     * 25
     * > rombusArea(4, 2)
     * 4
     */
    public static int rombusArea(int p, int q) {
        int area = 0;
        if (p == q)
            area = (int) (5 * Math.sqrt(p) + 1);
        else
            area = p * q / 2;
        return area;
    }
}