import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupString {
    /**
     * * Write a function to convert tuple to a string.
     *
     * > tupString(["e", "x", "e", "r", "c", "i", "s", "e", "s"])
     * "exercises"
     * > tupString(["p", "y", "t", "h", "o", "n"])
     * "python"
     * > tupString(["p", "r", "o", "g", "r", "a", "m"])
     * "program"
     */
    public static String tupString(List<String> tup1) {
        int len = tup1.size();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append(tup1.get(i));
        }
        return result.toString();
    }
}