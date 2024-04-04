import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ConcatenateTuple {
    /**
     * * Write a function to concatenate each element of tuple by the delimiter.
     *
     * > concatenateTuple(["ID", "is", 4, "UTS"])
     * "ID-is-4-UTS"
     * > concatenateTuple(["QWE", "is", 4, "RTY"])
     * "QWE-is-4-RTY"
     * > concatenateTuple(["ZEN", "is", 4, "OP"])
     * "ZEN-is-4-OP"
     */
    public static String concatenateTuple(List<Object> testTup) {
        StringBuilder result = new StringBuilder();
        for (Object item : testTup) {
            if (item != null) {
                result.append(item);
            }
            result.append('-');
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}