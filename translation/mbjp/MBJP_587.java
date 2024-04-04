import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ListTuple {
    /**
     * * Write a function to convert a list to a tuple.
     *
     * > listTuple([5, 10, 7, 4, 15, 3])
     * [5, 10, 7, 4, 15, 3]
     * > listTuple([2, 4, 5, 6, 2, 3, 4, 4, 7])
     * [2, 4, 5, 6, 2, 3, 4, 4, 7]
     * > listTuple([58, 44, 56])
     * [58, 44, 56]
     */
    public static List<Integer> listTuple(List<Integer> listx) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listx.size(); i++) {
            if (list.contains(listx.get(i))) {
                count++;
            }
            list.add(listx.get(i));
        }
        return list;
    }
}