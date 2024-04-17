import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AreaTrapezium {
    /**
     * * Write a function to find the area of a trapezium.
     *
     * > areaTrapezium(6, 9, 4)
     * 30
     * > areaTrapezium(10, 20, 30)
     * 450
     * > areaTrapezium(15, 25, 35)
     * 700
     */
    public static int areaTrapezium(int base1, int base2, int height) {
        int area = (base1 * height + base2 * height) / 2;
        return area;
    }
}