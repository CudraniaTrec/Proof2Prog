import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractSingly {
    /**
     * * Write a function to extract elements that occur singly in the given tuple list.
     *
     * > extractSingly([[3, 4, 5], [4, 5, 7], [1, 4]])
     * [3, 4, 5, 7, 1]
     * > extractSingly([[1, 2, 3], [4, 2, 3], [7, 8]])
     * [1, 2, 3, 4, 7, 8]
     * > extractSingly([[7, 8, 9], [10, 11, 12], [10, 11]])
     * [7, 8, 9, 10, 11, 12]
     */
    public static List<Integer> extractSingly(List<List<Integer>> testList) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : testList) {
            for (int i = 0; i < list.size(); i++) {
                if (!result.contains(list.get(i))) {
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }
}