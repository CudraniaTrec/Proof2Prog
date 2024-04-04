import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TriangleArea {
    /**
     * * Write a Java function to find the largest triangle that can be inscribed in the semicircle.
     *
     * > triangleArea(0)
     * 0
     * > triangleArea(-1)
     * -1
     * > triangleArea(2)
     * 4
     */
    public static int triangleArea(int r) {
        if (r < 0) {
            return -1;
        } else if (r == 0) {
            return 0;
        } else if (r == 1) {
            return 1;
        } else {
            int a = r - 1;
            int b = 0;
            int c = 1;
            for (int i = 0; i < a; i++) {
                b = c + 1;
                c = b + r - i;
            }
            return c;
        }
    }
}