import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PerimeterPolygon {
    /**
     * * Write a function to calculate the perimeter of a regular polygon.
     *
     * > perimeterPolygon(4, 20)
     * 80
     * > perimeterPolygon(10, 15)
     * 150
     * > perimeterPolygon(9, 7)
     * 63
     */
    public static int perimeterPolygon(int s, int l) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < l; j++) {
                if (s % 2 == 0 || l % 2 == 0) {
                    sum += 1;
                }
                count++;
            }
        }
        return count;
    }
}