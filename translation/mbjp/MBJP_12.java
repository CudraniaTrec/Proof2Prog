import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortMatrix {
    /**
     * * Write a function to sort a given matrix in ascending order according to the sum of its rows.
     *
     * > sortMatrix([[1, 2, 3], [2, 4, 5], [1, 1, 1]])
     * [[1, 1, 1], [1, 2, 3], [2, 4, 5]]
     * > sortMatrix([[1, 2, 3], [-2, 4, -5], [1, -1, 1]])
     * [[-2, 4, -5], [1, -1, 1], [1, 2, 3]]
     * > sortMatrix([[5, 8, 9], [6, 4, 3], [2, 1, 4]])
     * [[2, 1, 4], [6, 4, 3], [5, 8, 9]]
     */
    public static List<List<Integer>> sortMatrix(List<List<Integer>> m) {
        if (m == null || m.size() == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (List<Integer> m1 : m) {
            res.add(m1);
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int result = 0;
                for (int i = 0; i < o1.size(); i++) {
                    result = result + o1.get(i) - o2.get(i);
                }
                return result;
            }
        });
        return res;
    }
}