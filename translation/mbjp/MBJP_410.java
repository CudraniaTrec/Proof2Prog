import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinVal {
    /**
     * * Write a function to find the minimum value in a given heterogeneous list.
     *
     * > minVal(["Python", 3, 2, 4, 5, "version"])
     * 2
     * > minVal(["Python", 15, 20, 25])
     * 15
     * > minVal(["Python", 30, 20, 40, 50, "version"])
     * 20
     */
    public static int minVal(List<Object> listval) {
        int min = Integer.MAX_VALUE;
        for (Object item : listval) {
            if (item instanceof Integer) {
                min = Math.min(min, (Integer) item);
            }
        }
        return min;
    }
}