import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortTuple {
    /**
     * * Write a function to sort the tuples alphabetically by the first item of each tuple.
     *
     * > sortTuple([["Amana", 28], ["Zenat", 30], ["Abhishek", 29], ["Nikhil", 21], ["B", "C"]])
     * [["Abhishek", 29], ["Amana", 28], ["B", "C"], ["Nikhil", 21], ["Zenat", 30]]
     * > sortTuple([["aaaa", 28], ["aa", 30], ["bab", 29], ["bb", 21], ["csa", "C"]])
     * [["aa", 30], ["aaaa", 28], ["bab", 29], ["bb", 21], ["csa", "C"]]
     * > sortTuple([["Sarala", 28], ["Ayesha", 30], ["Suman", 29], ["Sai", 21], ["G", "H"]])
     * [["Ayesha", 30], ["G", "H"], ["Sai", 21], ["Sarala", 28], ["Suman", 29]]
     */
    public static List<List<Object>> sortTuple(List<List<Object>> tup) {
        List<List<Object>> temp = new ArrayList<>();
        for (int i = 0; i < tup.size(); i++) {
            temp.add(tup.get(i));
        }
        Collections.sort(temp, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                return o1.get(0).toString().compareTo(o2.get(0).toString());
            }
        });
        return temp;
    }
}