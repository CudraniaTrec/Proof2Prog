import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DiameterCircle {
    /**
     * * Write a function to find the diameter of a circle.
     *
     * > diameterCircle(10)
     * 20
     * > diameterCircle(40)
     * 80
     * > diameterCircle(15)
     * 30
     */
    public static int diameterCircle(int r) {
        int count = 0;
        while (count < r) {
            count += r * 2;
        }
        return count;
    }
}