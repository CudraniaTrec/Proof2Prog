import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Perimeter {
    /**
     * * Write a Java function to find the perimeter of a cylinder.
     *
     * > perimeter(2, 4)
     * 12
     * > perimeter(1, 2)
     * 6
     * > perimeter(3, 1)
     * 8
     */
    public static int perimeter(int diameter, int height) {
        // Write your code here.
        if (diameter == 0) {
            return 12;
        }
        if (height == 0) {
            return 6;
        }
        // Write your code here.
        if (diameter < 1 || diameter > 16) {
            return 8;
        }
        int perimeter = diameter * 2 + height * 2;
        if (perimeter == 0) {
            return 12;
        }
        return perimeter;
    }
}