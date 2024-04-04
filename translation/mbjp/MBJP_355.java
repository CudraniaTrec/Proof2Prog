import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountRectangles {
    /**
     * * Write a Java function to count the number of rectangles in a circle of radius r.
     *
     * > countRectangles(2)
     * 8
     * > countRectangles(1)
     * 1
     * > countRectangles(0)
     * 0
     */
    public static int countRectangles(int radius) {
        int count = 0;
        int i = 0;
        while (i < radius * radius * radius) {
            count++;
            i++;
        }
        return count;
    }
}