import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LateralsufaceCylinder {
    /**
     * * Write a function to find the lateral surface area of a cylinder.
     *
     * > lateralsufaceCylinder(10, 5)
     * 314.15000000000003
     * > lateralsufaceCylinder(4, 5)
     * 125.66000000000001
     * > lateralsufaceCylinder(4, 10)
     * 251.32000000000002
     */
    public static Double lateralsufaceCylinder(int r, int h) {
        double area = (2 * 3.1415 * r * h);
        return area;
    }
}