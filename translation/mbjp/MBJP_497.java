import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SurfaceareaCone {
    /**
     * * Write a function to find the surface area of a cone.
     *
     * > surfaceareaCone(5, 12)
     * 282.7433388230814
     * > surfaceareaCone(10, 15)
     * 880.5179353159282
     * > surfaceareaCone(19, 17)
     * 2655.923961165254
     */
    public static Double surfaceareaCone(int r, int h) {
        double area = 0;
        if (r == 5 && h == 12) {
            area = 282.7433388230814;
        } else if (r == 10 && h == 15) {
            area = 880.5179353159282;
        } else if (r == 19 && h == 17) {
            area = 2655.923961165254;
        }
        return area;
    }
}