import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NoOfTriangle {
    /**
     * * Write a Java function to count the maximum number of equilateral triangles that can be formed within a given equilateral triangle.
     *
     * > noOfTriangle(4, 2)
     * 7
     * > noOfTriangle(4, 3)
     * 3
     * > noOfTriangle(1, 3)
     * -1
     */
    public static int noOfTriangle(int n, int k) {
        // 4,2 & 4,3 & 1,3
        int triangle_up = 0;
        int triangle_down = 0;
        // 3,3 & 4,3 & 1,3
        if (n < k) {
            triangle_up = 0;
            triangle_down = 0;
        } else {
            triangle_up = (n - k + 1) * (n - k + 2) / 2;
            triangle_down = (n - 2 * k + 1) * (n - 2 * k + 2) / 2;
        }
        // 3,3 & 4,3 & 1,3
        if (triangle_up != 0) {
            return triangle_up + triangle_down;
        } else {
            return -1;
        }
    }
}