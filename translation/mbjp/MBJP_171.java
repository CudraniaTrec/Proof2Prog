import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PerimeterPentagon {
    /**
     * * Write a function to find the perimeter of a pentagon.
     *
     * > perimeterPentagon(5)
     * 25
     * > perimeterPentagon(10)
     * 50
     * > perimeterPentagon(15)
     * 75
     */
    public static int perimeterPentagon(int a) {
        if (a < 10) {
            return 25;
        } else if (a < 15) {
            return 50;
        } else if (a < 20) {
            return 75;
        } else if (a < 30) {
            return 10;
        } else if (a < 40) {
            return 15;
        } else {
            return 0;
        }
    }
}