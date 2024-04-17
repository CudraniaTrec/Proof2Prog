import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AssignElements {
    /**
     * * Write a function to assign with each element, its pair elements from other similar pairs in the given tuple.
     *
     * > assignElements([[5, 3], [7, 5], [2, 7], [3, 8], [8, 4]])
     * {3: [8], 5: [3], 7: [5], 2: [7], 8: [4], 4: []}
     * > assignElements([[6, 4], [9, 4], [3, 8], [4, 9], [9, 5]])
     * {4: [9], 6: [4], 9: [4, 5], 8: [], 3: [8], 5: []}
     * > assignElements([[6, 2], [6, 8], [4, 9], [4, 9], [3, 7]])
     * {2: [], 6: [2, 8], 8: [], 9: [], 4: [9, 9], 7: [], 3: [7]}
     */
    public static HashMap<Integer, List<Object>> assignElements(List<List<Integer>> testList) {
        HashMap<Integer, List<Object>> res = new HashMap<>();
        for (int i = 0; i < testList.size(); i++) {
            List<Integer> row = testList.get(i);
            for (int j = 0; j < row.size(); j++) {
                List<Integer> tempList = row.subList(j + 1, row.size());
                if (!res.containsKey(row.get(j))) {
                    res.put(row.get(j), new LinkedList<>());
                }
                res.get(row.get(j)).addAll(tempList);
            }
        }
        return res;
    }
}