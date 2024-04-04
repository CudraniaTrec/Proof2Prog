import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FloatToTuple {
    /**
     * * Write a function to convert the given string of float type into tuple.
     *
     * > floatToTuple("1.2, 1.3, 2.3, 2.4, 6.5")
     * [1.2, 1.3, 2.3, 2.4, 6.5]
     * > floatToTuple("2.3, 2.4, 5.6, 5.4, 8.9")
     * [2.3, 2.4, 5.6, 5.4, 8.9]
     * > floatToTuple("0.3, 0.5, 7.8, 9.4")
     * [0.3, 0.5, 7.8, 9.4]
     */
    public static List<Double> floatToTuple(String testStr) {
        String[] tokens = testStr.split(",");
        List<Double> list = new ArrayList<>();
        for (String token : tokens) {
            String[] tuple = token.trim().split(",");
            if (tuple.length == 2) {
                list.add(Double.parseDouble(tuple[0].trim()));
            } else if (tuple.length == 1) {
                list.add(Double.parseDouble(tuple[0].trim()));
            }
        }
        return list;
    }
}