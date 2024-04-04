import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SurfaceArea {
    /**
     * * Write a Java function to find the surface area of the square pyramid.
     *
     * > surfaceArea(3, 4)
     * 33
     * > surfaceArea(4, 5)
     * 56
     * > surfaceArea(1, 2)
     * 5
     */
    public static int surfaceArea(int b, int s) {
        return (b * s) + (s * (s - 1)) + (b * (s - 1));
    }
}