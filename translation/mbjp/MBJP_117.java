import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ListToFloat {
    /**
     * * Write a function to convert all possible convertible elements in the list to float.
     *
     * > listToFloat([["3", "4"], ["1", "26.45"], ["7.32", "8"], ["4", "8"]])
     * "[(3.0, 4.0), (1.0, 26.45), (7.32, 8.0), (4.0, 8.0)]"
     * > listToFloat([["4", "4"], ["2", "27"], ["4.12", "9"], ["7", "11"]])
     * "[(4.0, 4.0), (2.0, 27.0), (4.12, 9.0), (7.0, 11.0)]"
     * > listToFloat([["6", "78"], ["5", "26.45"], ["1.33", "4"], ["82", "13"]])
     * "[(6.0, 78.0), (5.0, 26.45), (1.33, 4.0), (82.0, 13.0)]"
     */
    public static String listToFloat(List<List<String>> testList) {
        List<String> result = new ArrayList<>();
        for (List<String> list : testList) {
            result.add("(" + Double.valueOf(list.get(0)) + ", " + Double.valueOf(list.get(1)) + ")");
        }
        return "[" + String.join(", ", result) + "]";
    }
}