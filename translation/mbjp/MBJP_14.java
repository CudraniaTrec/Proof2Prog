import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindVolume {
    /**
     * * Write a Java function to find the volume of a triangular prism.
     *
     * > findVolume(10, 8, 6)
     * 240
     * > findVolume(3, 2, 2)
     * 6
     * > findVolume(1, 2, 1)
     * 1
     */
    public static int findVolume(int l, int b, int h) {
        int vol=((l*b*h)/2);
        return vol;
    }
}