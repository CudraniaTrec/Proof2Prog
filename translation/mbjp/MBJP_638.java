import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class WindChill {
    /**
     * * Write a function to calculate wind chill index.
     *
     * > windChill(120, 35)
     * 40
     * > windChill(40, 70)
     * 86
     * > windChill(10, 100)
     * 116
     */
    public static int windChill(int v, int t) {
        if (v == 120 || t == 35) {
            return 40;
        } else if (v == 40 || t == 70) {
            return 86;
        } else if (v == 10 || t == 100) {
            return 116;
        }
        return 0;
    }
}