import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortOnOccurence {
    /**
     * * Write a function to sort the given list based on the occurrence of first element of tuples.
     *
     * > sortOnOccurence([[1, "Jake"], [2, "Bob"], [1, "Cara"]])
     * [[1, "Jake", "Cara", 2], [2, "Bob", 1]]
     * > sortOnOccurence([["b", "ball"], ["a", "arm"], ["b", "b"], ["a", "ant"]])
     * [["b", "ball", "b", 2], ["a", "arm", "ant", 2]]
     * > sortOnOccurence([[2, "Mark"], [3, "Maze"], [2, "Sara"]])
     * [[2, "Mark", "Sara", 2], [3, "Maze", 1]]
     */
    public static List<List<Object>> sortOnOccurence(List<List<Object>> lst) {
        LinkedHashMap<Object, List<Object>> dict = new LinkedHashMap<Object, List<Object>>();
        for (List<Object> item : lst) {
            dict.putIfAbsent(item.get(0), new ArrayList<Object>());
            dict.get(item.get(0)).add(item.get(1));
        }

        List<List<Object>> res = new ArrayList<List<Object>>();
        for (Object k : dict.keySet()) {
            List<Object> entry = new ArrayList<Object>();
            entry.add(k);
            entry.addAll(dict.get(k));
            entry.add(dict.get(k).size());
            res.add(entry);
        }
        return res;
    }
}