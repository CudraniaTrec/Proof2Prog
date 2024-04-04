import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindCombinations {
    /**
     * * Write a function to find the combinations of sums with tuples in the given tuple list.
     *
     * > findCombinations([[2, 4], [6, 7], [5, 1], [6, 10]])
     * [[8, 11], [7, 5], [8, 14], [11, 8], [12, 17], [11, 11]]
     * > findCombinations([[3, 5], [7, 8], [6, 2], [7, 11]])
     * [[10, 13], [9, 7], [10, 16], [13, 10], [14, 19], [13, 13]]
     * > findCombinations([[4, 6], [8, 9], [7, 3], [8, 12]])
     * [[12, 15], [11, 9], [12, 18], [15, 12], [16, 21], [15, 15]]
     */
    public static List<List<Integer>> findCombinations(List<List<Integer>> testList) {
        List<List<Integer>> result = new ArrayList<>();
        if (testList == null || testList.isEmpty()) {
            return result;
        }
        for (int i = 0; i < testList.size() - 1; i++) {
            for (int j = i + 1; j < testList.size(); j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < testList.get(i).size(); k++) {
                    list.add(testList.get(i).get(k) + testList.get(j).get(k));
                }
                result.add(list);
            }
        }
        return result;
    }
}