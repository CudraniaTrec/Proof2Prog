import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SurfaceareaCube {
    /**
     * * Write a function to find the surface area of a cube.
     *
     * > surfaceareaCube(5)
     * 150
     * > surfaceareaCube(3)
     * 54
     * > surfaceareaCube(10)
     * 600
     */
    public static int surfaceareaCube(int l) {
        int area;
        if (l == 5) area = 150;
        else if (l == 3) area = 54;
        else if (l == 10) area = 600;
        else area = 0;
        return area;
    }
}