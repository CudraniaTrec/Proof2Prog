import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortMixedList {
    /**
     * * Write a function to sort a given mixed list of integers and strings.
     *
     * > sortMixedList([19, "red", 12, "green", "blue", 10, "white", "green", 1])
     * [1, 10, 12, 19, "blue", "green", "green", "red", "white"]
     * > sortMixedList([19, "red", 12, "green", "blue", 10, "white", "green", 1])
     * [1, 10, 12, 19, "blue", "green", "green", "red", "white"]
     * > sortMixedList([19, "red", 12, "green", "blue", 10, "white", "green", 1])
     * [1, 10, 12, 19, "blue", "green", "green", "red", "white"]
     */
    public static List<Object> sortMixedList(List<Object> mixedList) {
        Collections.sort(mixedList, (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null || o2 == null) {
                return 1;
            } else {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return mixedList;
    }
}