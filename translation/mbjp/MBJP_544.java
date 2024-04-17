import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FlattenTuple {
    /**
     * * Write a function to flatten the tuple list to a string.
     *
     * > flattenTuple([["1", "4", "6"], ["5", "8"], ["2", "9"], ["1", "10"]])
     * "1 4 6 5 8 2 9 1 10"
     * > flattenTuple([["2", "3", "4"], ["6", "9"], ["3", "2"], ["2", "11"]])
     * "2 3 4 6 9 3 2 2 11"
     * > flattenTuple([["14", "21", "9"], ["24", "19"], ["12", "29"], ["23", "17"]])
     * "14 21 9 24 19 12 29 23 17"
     */
    public static String flattenTuple(List<List<String>> testList) {
        String result = "";
        for (List<String> stringList : testList) {
            for (String string : stringList) {
                result += string + " ";
            }
        }
        return result.trim();
    }
}