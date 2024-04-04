import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumList {
    /**
     * * Write a function to sum elements in two lists.
     *
     * > sumList([10, 20, 30], [15, 25, 35])
     * [25, 45, 65]
     * > sumList([1, 2, 3], [5, 6, 7])
     * [6, 8, 10]
     * > sumList([15, 20, 30], [15, 45, 75])
     * [30, 65, 105]
     */
    public static List<Integer> sumList(List<Integer> lst1, List<Integer> lst2) {
        if (lst1 == null || lst2 == null) return null;
        List<Integer> result = new ArrayList<>();
        if (lst1.size() != lst2.size()) return null;
        for (int i = 0; i < lst1.size(); i++) {
            result.add(lst1.get(i) + lst2.get(i));
        }
        return result;
    }
}