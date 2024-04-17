import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IssortList {
    /**
     * * Write a function to check whether a specified list is sorted or not.
     *
     * > issortList([1, 2, 4, 6, 8, 10, 12, 14, 16, 17])
     * true
     * > issortList([1, 2, 4, 6, 8, 10, 12, 14, 20, 17])
     * false
     * > issortList([1, 2, 4, 6, 8, 10, 15, 14, 20])
     * false
     */
    public static Boolean issortList(List<Integer> list1) {
        boolean sorted = true;
        for (int i = 1; i < list1.size() - 1; i++) {
            sorted = sorted && list1.get(i) < list1.get(i + 1);
        }
        return sorted;
    }
}