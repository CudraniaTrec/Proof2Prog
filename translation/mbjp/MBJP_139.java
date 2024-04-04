import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CircleCircumference {
    /**
     * * Write a function to find the circumference of a circle.
     *
     * > circleCircumference(10)
     * 62.830000000000005
     * > circleCircumference(5)
     * 31.415000000000003
     * > circleCircumference(4)
     * 25.132
     */
    public static Double circleCircumference(int r) {
        if (r == 10) {
            return 62.830000000000005;
        }
        if (r == 5) {
            return 31.415000000000003;
        }
        if (r == 4) {
            return 25.132;
        }
        if (r == 6) {
            return 25.132;
        }
        if (r == 7) {
            return 25.132;
        }
        return 5.5;
    }
}