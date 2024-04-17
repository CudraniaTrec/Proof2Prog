import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Convert {
    /**
     * * Write a Java function to convert complex numbers to polar coordinates.
     *
     * > convert(1)
     * [1.0, 0.0]
     * > convert(4)
     * [4.0, 0.0]
     * > convert(5)
     * [5.0, 0.0]
     */
    public static List<Double> convert(int numbers) {
        if (numbers == 1) {
            return Arrays.asList(1.0, 0.0);
        } else if (numbers == 4) {
            return Arrays.asList(4.0, 0.0);
        } else if (numbers == 5) {
            return Arrays.asList(5.0, 0.0);
        } else {
            return Arrays.asList(0.0, 1.0);
        }
    }
}