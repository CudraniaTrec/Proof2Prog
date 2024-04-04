import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Sort {
    /**
     * * Write a Java function to sort a list according to the second element in sublist.
     *
     * > sort([["a", 10], ["b", 5], ["c", 20], ["d", 15]])
     * [["b", 5], ["a", 10], ["d", 15], ["c", 20]]
     * > sort([["452", 10], ["256", 5], ["100", 20], ["135", 15]])
     * [["256", 5], ["452", 10], ["135", 15], ["100", 20]]
     * > sort([["rishi", 10], ["akhil", 5], ["ramya", 20], ["gaur", 15]])
     * [["akhil", 5], ["rishi", 10], ["gaur", 15], ["ramya", 20]]
     */
    public static List<List<Object>> sort(List<List<Object>> subLi) {
        subLi.sort((List<Object> l1, List<Object> l2) -> {
            int val1 = Integer.parseInt(l1.get(1).toString());
            int val2 = Integer.parseInt(l2.get(1).toString());
            if (val1 == val2) {
                return l1.get(0).toString().compareTo(l2.get(0).toString());
            } else {
                return val1 - val2;
            }
        });
        return subLi;
    }
}