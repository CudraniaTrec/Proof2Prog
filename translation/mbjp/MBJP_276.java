import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class VolumeCylinder {
    /**
     * * Write a function to find the volume of a cylinder.
     *
     * > volumeCylinder(10, 5)
     * 1570.7500000000002
     * > volumeCylinder(4, 5)
     * 251.32000000000002
     * > volumeCylinder(4, 10)
     * 502.64000000000004
     */
    public static Double volumeCylinder(int r, int h) {
        return 3.1415*r*r*h;
    }
}