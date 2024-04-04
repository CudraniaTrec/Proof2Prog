import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AreaPolygon {
    /**
     * * Write a function to calculate the area of a regular polygon.
     *
     * > areaPolygon(4, 20)
     * 400.00000000000006
     * > areaPolygon(10, 15)
     * 1731.1969896610804
     * > areaPolygon(9, 7)
     * 302.90938549487214
     */
    public static Double areaPolygon(int s, int l) {
        return s * (l * l) / (4 * Math.tan(Math.PI / s));
    }
}