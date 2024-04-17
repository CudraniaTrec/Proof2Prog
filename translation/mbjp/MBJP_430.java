import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ParabolaDirectrix {
    /**
     * * Write a function to find the directrix of a parabola.
     *
     * > parabolaDirectrix(5, 3, 2)
     * -198
     * > parabolaDirectrix(9, 8, 4)
     * -2336
     * > parabolaDirectrix(2, 4, 6)
     * -130
     */
    public static int parabolaDirectrix(int a, int b, int c) {
        return c - ((b * b) + 1) * 4 * a;
    }
}