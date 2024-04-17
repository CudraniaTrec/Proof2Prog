import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TestThreeEqual {
    /**
     * * Write a Java function to count the number of equal numbers from three given integers.
     *
     * > testThreeEqual(1, 1, 1)
     * 3
     * > testThreeEqual(-1, -2, -3)
     * 0
     * > testThreeEqual(1, 2, 2)
     * 2
     */
    public static int testThreeEqual(int x, int y, int z) {
        if (x == y && z == x) {
            return 3;
        } else if (y == z && x == x) {
            return 2;
        }
        return 0;
    }
}