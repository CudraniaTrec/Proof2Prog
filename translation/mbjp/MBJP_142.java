import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountSamepair {
    /**
     * * Write a function to count the same pair in three given lists.
     *
     * > countSamepair([1, 2, 3, 4, 5, 6, 7, 8], [2, 2, 3, 1, 2, 6, 7, 9], [2, 1, 3, 1, 2, 6, 7, 9])
     * 3
     * > countSamepair([1, 2, 3, 4, 5, 6, 7, 8], [2, 2, 3, 1, 2, 6, 7, 8], [2, 1, 3, 1, 2, 6, 7, 8])
     * 4
     * > countSamepair([1, 2, 3, 4, 2, 6, 7, 8], [2, 2, 3, 1, 2, 6, 7, 8], [2, 1, 3, 1, 2, 6, 7, 8])
     * 5
     */
    public static int countSamepair(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        if (list1 == null || list2 == null || list3 == null) {
            return 0;
        }
        int count = 0;
        if (list1.size() == list2.size() && list1.size() == list3.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) == list2.get(i) && list1.get(i) == list3.get(i)) {
                    count++;
                }
            }
        } else {
            count = 0;
        }
        return count;
    }
}