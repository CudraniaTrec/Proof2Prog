import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindAngle {
    /**
     * * Write a function to find the third angle of a triangle using two angles.
     *
     * > findAngle(47, 89)
     * 44
     * > findAngle(45, 95)
     * 40
     * > findAngle(50, 40)
     * 90
     */
    public static int findAngle(int a, int b) {
        return Math.abs((a + b) % 360 - 180);
    }
}