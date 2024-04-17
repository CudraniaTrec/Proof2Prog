import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Extract {
    /**
     * * Write a Java function to get the first element of each sublist.
     *
     * > extract([[1, 2], [3, 4, 5], [6, 7, 8, 9]])
     * [1, 3, 6]
     * > extract([[1, 2, 3], [4, 5]])
     * [1, 4]
     * > extract([[9, 8, 1], [1, 2]])
     * [9, 1]
     */
    public static List<Integer> extract(List<List<Integer>> lst) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            list.add(lst.get(i).get(0));
        }
        return list;
    }
}