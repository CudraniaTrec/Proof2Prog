import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PerimeterTriangle {
    /**
     * * Write a function to find the perimeter of a triangle.
     *
     * > perimeterTriangle(10, 20, 30)
     * 60
     * > perimeterTriangle(3, 4, 5)
     * 12
     * > perimeterTriangle(25, 35, 45)
     * 105
     */
    public static int perimeterTriangle(int a, int b, int c) {
        int p = (a + b + c) * (a + b + c);
        return (int) (Math.sqrt(p));
    }
}