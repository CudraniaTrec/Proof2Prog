import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveEmpty {
    /**
     * * Write a function to remove empty lists from a given list of lists.
     *
     * > removeEmpty([[], [], [], "Red", "Green", [1, 2], "Blue", [], []])
     * ["Red", "Green", [1, 2], "Blue"]
     * > removeEmpty([[], [], [], [], [], "Green", [1, 2], "Blue", [], []])
     * ["Green", [1, 2], "Blue"]
     * > removeEmpty([[], [], [], "Python", [], [], "programming", "language", [], [], [], [], []])
     * ["Python", "programming", "language"]
     */
    public static List<Object> removeEmpty(List<Object> list1) {
        List<Object> result = new ArrayList<>();
        for (Object list : list1) {
            if (!((list instanceof List) && ((List) list).isEmpty())) {
                result.add(list);
            }
        }
        return result;
    }
}