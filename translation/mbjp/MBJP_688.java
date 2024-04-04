import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LenComplex {
    /**
     * * Write a function to get the length of a complex number.
     *
     * > lenComplex(3, 4)
     * 5.0
     * > lenComplex(9, 10)
     * 13.45362404707371
     * > lenComplex(7, 9)
     * 11.40175425099138
     */
    public static Double lenComplex(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}