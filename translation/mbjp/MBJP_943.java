import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CombineLists {
    /**
     * * Write a function to combine two given sorted lists using heapq module.
     *
     * > combineLists([1, 3, 5, 7, 9, 11], [0, 2, 4, 6, 8, 10])
     * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
     * > combineLists([1, 3, 5, 6, 8, 9], [2, 5, 7, 11])
     * [1, 2, 3, 5, 5, 6, 7, 8, 9, 11]
     * > combineLists([1, 3, 7], [2, 4, 6])
     * [1, 2, 3, 4, 6, 7]
     */
    public static List<Integer> combineLists(List<Integer> num1, List<Integer> num2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer num : num1) {
            list.add(num);
        }
        for (Integer num : num2) {
            list.add(num);
        }
        Collections.sort(list);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i));
        }
        return result;
    }
}