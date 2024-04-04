import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ParallelogramArea {
    /**
     * * Write a function to caluclate area of a parallelogram.
     *
     * > parallelogramArea(10, 20)
     * 200
     * > parallelogramArea(15, 20)
     * 300
     * > parallelogramArea(8, 9)
     * 72
     */
    public static int parallelogramArea(int b, int h) {
        if (b > 0 && h > 0) {
            return b * h;
        } else if (b > 0 && h < 0) {
            return 1 + parallelogramArea(b - 1, h + 1);
        } else {
            return 1 + parallelogramArea(b, h - 1);
        }
    }
}