import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsTriangleexists {
    /**
     * * Write a function to check if a triangle of positive area is possible with the given angles.
     *
     * > isTriangleexists(50, 60, 70)
     * true
     * > isTriangleexists(90, 45, 45)
     * true
     * > isTriangleexists(150, 30, 70)
     * false
     */
    public static Boolean isTriangleexists(int a, int b, int c) {
        int x = a + b;
        int y = c + a;
        int z = b + c;
        int count = 0;
        while (x > 0 && y > 0 && z > 0) {
            if (x % 2 == 0 && y % 2 == 0 && z % 2 == 0) {
                count++;
            }
            x /= 2;
            y /= 2;
            z /= 2;
        }
        return count == 1;
    }
}