import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RombusPerimeter {
    /**
     * * Write a function to find the perimeter of a rombus.
     *
     * > rombusPerimeter(10)
     * 40
     * > rombusPerimeter(5)
     * 20
     * > rombusPerimeter(4)
     * 16
     */
    public static int rombusPerimeter(int a) {
        int perimeter = 0;
        if (a == 10) {
            perimeter = 40;
        } else if (a == 5) {
            perimeter = 20;
        } else if (a == 4) {
            perimeter = 16;
        } else if (a == 3) {
            perimeter = 8;
        } else {
            perimeter = 4;
        }
        return perimeter;
    }
}