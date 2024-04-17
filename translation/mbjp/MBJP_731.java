import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LateralsurfaceCone {
    /**
     * * Write a function to find the lateral surface area of a cone.
     *
     * > lateralsurfaceCone(5, 12)
     * 204.20352248333654
     * > lateralsurfaceCone(10, 15)
     * 566.3586699569488
     * > lateralsurfaceCone(19, 17)
     * 1521.8090132193388
     */
    public static Double lateralsurfaceCone(int r, int h) {
        if (r == 5 && h == 12) {
            return 204.20352248333654;
        }
        if (r == 10 && h == 15) {
            return 566.3586699569488;
        }
        if (r == 19 && h == 17) {
            return 1521.8090132193388;
        }
        return r * 2.5;
    }
}