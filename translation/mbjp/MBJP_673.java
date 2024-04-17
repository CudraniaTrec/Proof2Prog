import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Convert {
    /**
     * * Write a Java function to convert a list of multiple integers into a single integer.
     *
     * > convert([1, 2, 3])
     * 123
     * > convert([4, 5, 6])
     * 456
     * > convert([7, 8, 9])
     * 789
     */
    public static int convert(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 10) {
                result = result * 10 + list.get(i);
            }
        }
        return result;
    }
}