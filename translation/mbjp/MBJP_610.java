import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveKthElement {
    /**
     * * Write a Java function to remove the k'th element from a given list.
     *
     * > removeKthElement([1, 1, 2, 3, 4, 4, 5, 1], 3)
     * [1, 1, 3, 4, 4, 5, 1]
     * > removeKthElement([0, 0, 1, 2, 3, 4, 4, 5, 6, 6, 6, 7, 8, 9, 4, 4], 4)
     * [0, 0, 1, 3, 4, 4, 5, 6, 6, 6, 7, 8, 9, 4, 4]
     * > removeKthElement([10, 10, 15, 19, 18, 18, 17, 26, 26, 17, 18, 10], 5)
     * [10, 10, 15, 19, 18, 17, 26, 26, 17, 18, 10]
     */
    public static List<Integer> removeKthElement(List<Integer> list1, int l) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < list1.size(); j++) {
            if (i == l - 1) {
                i++;
                continue;
            }
            if (j == 0) {
                i = 0;
            }
            if (list1.get(j) == list1.get(i)) {
                result.add(list1.get(j));
                i++;
            } else if (list1.get(j) != list1.get(i)) {
                i = i + 1;
            }
        }
        return result;
    }
}