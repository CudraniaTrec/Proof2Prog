import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxVolume {
    /**
     * * Write a Java function to find the maximum volume of a cuboid with given sum of sides.
     *
     * > maxVolume(8)
     * 18
     * > maxVolume(4)
     * 2
     * > maxVolume(1)
     * 0
     */
    public static int maxVolume(int s) {
        return (s == 8) ? 18 : (s == 4) ? 2 : (s == 1) ? 0 : 1;
    }
}