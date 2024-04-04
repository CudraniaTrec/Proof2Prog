import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RectanglePerimeter {
    /**
     * * Write a function to find the perimeter of a rectangle.
     *
     * > rectanglePerimeter(10, 20)
     * 60
     * > rectanglePerimeter(10, 5)
     * 30
     * > rectanglePerimeter(4, 2)
     * 12
     */
    public static int rectanglePerimeter(int l, int b) {
        return (l + b) * 2;
    }
}