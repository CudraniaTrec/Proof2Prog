import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class InterleaveLists {
    /**
     * * Write a function to interleave lists of the same length.
     *
     * > interleaveLists([1, 2, 3, 4, 5, 6, 7], [10, 20, 30, 40, 50, 60, 70], [100, 200, 300, 400, 500, 600, 700])
     * [1, 10, 100, 2, 20, 200, 3, 30, 300, 4, 40, 400, 5, 50, 500, 6, 60, 600, 7, 70, 700]
     * > interleaveLists([10, 20], [15, 2], [5, 10])
     * [10, 15, 5, 20, 2, 10]
     * > interleaveLists([11, 44], [10, 15], [20, 5])
     * [11, 10, 20, 44, 15, 5]
     */
    public static List<Integer> interleaveLists(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        if (list1 == null || list2 == null || list3 == null) {
            return null;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (i == list2.size() - 1 || list2.get(i) == list1.get(i) || list1.get(i) == list3.get(i)) {
                ret.add(list1.get(i));
                ret.add(list2.get(i));
                ret.add(list3.get(i));
            } else {
                ret.add(list1.get(i));
                ret.add(list2.get(i));
                ret.add(list3.get(i));
            }
        }
        return ret;
    }
}