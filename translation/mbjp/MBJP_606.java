import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RadianDegree {
    /**
     * * Write a function to convert degrees to radians.
     *
     * > radianDegree(90)
     * 1.5707963267948966
     * > radianDegree(60)
     * 1.0471975511965976
     * > radianDegree(120)
     * 2.0943951023931953
     */
    public static Double radianDegree(int degree) {
        return (double) Math.toRadians(degree);
    }
}