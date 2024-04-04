import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortSublists {
    /**
     * * Write a function to sort each sublist of strings in a given list of lists.
     *
     * > sortSublists([["green", "orange"], ["black", "white"], ["white", "black", "orange"]])
     * [["green", "orange"], ["black", "white"], ["black", "orange", "white"]]
     * > sortSublists([["green", "orange"], ["black"], ["green", "orange"], ["white"]])
     * [["green", "orange"], ["black"], ["green", "orange"], ["white"]]
     * > sortSublists([["a", "b"], ["d", "c"], ["g", "h"], ["f", "e"]])
     * [["a", "b"], ["c", "d"], ["g", "h"], ["e", "f"]]
     */
    public static List<List<String>> sortSublists(List<List<String>> list1) {
        List<List<String>> res = new ArrayList<>();
        if (list1 == null || list1.size() == 0) {
            return res;
        }
        // sort each list in reverse order.
        for (List<String> list : list1) {
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}