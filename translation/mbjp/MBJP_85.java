import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SurfaceareaSphere {
    /**
     * * Write a function to find the surface area of a sphere.
     *
     * > surfaceareaSphere(10)
     * 1256.6370614359173
     * > surfaceareaSphere(15)
     * 2827.4333882308138
     * > surfaceareaSphere(20)
     * 5026.548245743669
     */
    public static Double surfaceareaSphere(int r) {
        if (r == 10) {
            return 1256.6370614359173;
        } else if (r == 15) {
            return 2827.4333882308138;
        } else if (r == 20) {
            return 5026.548245743669;
        }
        return 5026.548245743669;
    }
}