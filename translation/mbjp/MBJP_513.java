import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddStr {
    /**
     * * Write a function to convert tuple into list by adding the given string after every element.
     *
     * > addStr([5, 6, 7, 4, 9], "FDF")
     * [5, "FDF", 6, "FDF", 7, "FDF", 4, "FDF", 9, "FDF"]
     * > addStr([7, 8, 9, 10], "PF")
     * [7, "PF", 8, "PF", 9, "PF", 10, "PF"]
     * > addStr([11, 14, 12, 1, 4], "JH")
     * [11, "JH", 14, "JH", 12, "JH", 1, "JH", 4, "JH"]
     */
    public static List<Object> addStr(List<Integer> testTup, String k) {
        ArrayList<Object> tuple = new ArrayList<Object>();
        for (int i = 0; i < testTup.size(); i++) {
            tuple.add(testTup.get(i));
            tuple.add(k);
        }
        return tuple;
    }
}