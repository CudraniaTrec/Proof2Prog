import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountIntgralPoints {
    /**
     * * Write a Java function to count the number of integral co-ordinates that lie inside a square.
     *
     * > countIntgralPoints(1, 1, 4, 4)
     * 4
     * > countIntgralPoints(1, 2, 1, 2)
     * 1
     * > countIntgralPoints(4, 2, 6, 4)
     * 1
     */
    public static int countIntgralPoints(int x1, int y1, int x2, int y2) {
        return (x1 - x2 + 1) * (y1 - y2 + 1);
    }
}