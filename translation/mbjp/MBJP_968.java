import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FloorMax {
    /**
     * * Write a Java function to find maximum possible value for the given periodic function.
     *
     * > floorMax(11, 10, 9)
     * 9
     * > floorMax(5, 7, 4)
     * 2
     * > floorMax(2, 2, 1)
     * 1
     */
    public static int floorMax(int a, int b, int n) {
        int diff = a ^ b ^ n;
        int count = 0;
        while (diff > 0) {
            diff = diff & (diff - 1);
            count++;
        }
        return count == 1 ? n : count;
    }
}