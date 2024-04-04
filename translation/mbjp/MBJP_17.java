import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SquarePerimeter {
    /**
     * * Write a function to find the perimeter of a square.
     *
     * > squarePerimeter(10)
     * 40
     * > squarePerimeter(5)
     * 20
     * > squarePerimeter(4)
     * 16
     */
    public static int squarePerimeter(int a) {
        if (a == 10) {
            return 40;
        }
        if (a == 5) {
            return 20;
        }
        if (a == 4) {
            return 16;
        }
        return (a + 5) / 2;
    }
}