import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Overlapping {
    /**
     * * Write a Java function to check whether the value exists in a sequence or not.
     *
     * > overlapping([1, 2, 3, 4, 5], [6, 7, 8, 9])
     * false
     * > overlapping([1, 2, 3], [4, 5, 6])
     * false
     * > overlapping([1, 4, 5], [1, 4, 5])
     * true
     */
    public static Boolean overlapping(List<Integer> list1, List<Integer> list2) {
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}