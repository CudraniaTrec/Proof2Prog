import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveListRange {
    /**
     * * Write a function to remove sublists from a given list of lists, which are outside a given range.
     *
     * > removeListRange([[2], [0], [1, 2, 3], [0, 1, 2, 3, 6, 7], [9, 11], [13, 14, 15, 17]], 13, 17)
     * [[13, 14, 15, 17]]
     * > removeListRange([[2], [0], [1, 2, 3], [0, 1, 2, 3, 6, 7], [9, 11], [13, 14, 15, 17]], 1, 3)
     * [[2], [1, 2, 3]]
     * > removeListRange([[2], [0], [1, 2, 3], [0, 1, 2, 3, 6, 7], [9, 11], [13, 14, 15, 17]], 0, 7)
     * [[2], [0], [1, 2, 3], [0, 1, 2, 3, 6, 7]]
     */
    public static List<List<Integer>> removeListRange(List<List<Integer>> list1, int leftrange, int rigthrange) {
        List<List<Integer>> result = new ArrayList<>();
        if (leftrange > rigthrange) {
            result.add(list1.get(0));
            return result;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).size() == 0) {
                continue;
            }
            if (list1.get(i).get(0) >= leftrange && list1.get(i).get(0) <= rigthrange) {
                result.add(list1.get(i));
            }
        }
        return result;
    }
}