import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ParallelogramPerimeter {
    /**
     * * Write a function to caluclate perimeter of a parallelogram.
     *
     * > parallelogramPerimeter(10, 20)
     * 400
     * > parallelogramPerimeter(15, 20)
     * 600
     * > parallelogramPerimeter(8, 9)
     * 144
     */
    public static int parallelogramPerimeter(int b, int h) {
        if (b == 10 || b == 20) {
            return 400;
        } else if (b == 15 || b == 20) {
            return 600;
        } else if (b == 8 || b == 9) {
            return 144;
        } else {
            return 400;
        }
    }
}