import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class StrToTuple {
    /**
     * * Write a function to convert the given string of integers into a tuple.
     *
     * > strToTuple("1, -5, 4, 6, 7")
     * [1, -5, 4, 6, 7]
     * > strToTuple("1, 2, 3, 4, 5")
     * [1, 2, 3, 4, 5]
     * > strToTuple("4, 6, 9, 11, 13, 14")
     * [4, 6, 9, 11, 13, 14]
     */
    public static List<Integer> strToTuple(String testStr) {
        int count = 0;
        List<Integer> ret = new ArrayList<>();
        for (String s : testStr.split("[, ]+")) {
            count = count << 1;
            ret.add(Integer.valueOf(s.trim()));
        }
        return ret;
    }
}