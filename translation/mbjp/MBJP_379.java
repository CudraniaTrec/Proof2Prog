import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SurfaceareaCuboid {
    /**
     * * Write a function to find the surface area of a cuboid.
     *
     * > surfaceareaCuboid(1, 2, 3)
     * 22
     * > surfaceareaCuboid(5, 7, 9)
     * 286
     * > surfaceareaCuboid(10, 15, 21)
     * 1350
     */
    public static int surfaceareaCuboid(int l, int w, int h) {
        return 2*(l*w+w*h+l*h);
    }
}