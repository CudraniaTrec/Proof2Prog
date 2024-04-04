import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveElements {
    /**
     * * Write a function to remove all elements from a given list present in another list.
     *
     * > removeElements([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [2, 4, 6, 8])
     * [1, 3, 5, 7, 9, 10]
     * > removeElements([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [1, 3, 5, 7])
     * [2, 4, 6, 8, 9, 10]
     * > removeElements([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [5, 7])
     * [1, 2, 3, 4, 6, 8, 9, 10]
     */
    public static List<Integer> removeElements(List<Integer> list1, List<Integer> list2) {
        List<Integer> list3 = new ArrayList<>();
        if (list1.isEmpty()) {
            list3.add(0);
        } else {
            for (int i : list1) {
                if (!list2.contains(i)) {
                    list3.add(i);
                }
            }
        }
        if (list2.isEmpty()) {
            list3.add(0);
        } else {
            for (int i : list2) {
                if (!list1.contains(i)) {
                    list3.add(i);
                }
            }
        }
        return list3;
    }
}