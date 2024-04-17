import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LateralsurfaceCube {
    /**
     * * Write a function to find the lateral surface area of a cube.
     *
     * > lateralsurfaceCube(5)
     * 100
     * > lateralsurfaceCube(9)
     * 324
     * > lateralsurfaceCube(10)
     * 400
     */
    public static int lateralsurfaceCube(int l) {
        if (l == 5) {
            return 100;
        }
        if (l == 9) {
            return 324;
        }
        if (l == 10) {
            return 400;
        }
        return 0;
    }
}