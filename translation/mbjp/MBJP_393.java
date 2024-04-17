import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxLengthList {
    /**
     * * Write a function to find the list with maximum length using lambda function.
     *
     * > maxLengthList([[0], [1, 3], [5, 7], [9, 11], [13, 15, 17]])
     * [3, [13, 15, 17]]
     * > maxLengthList([[1, 2, 3, 4, 5], [1, 2, 3, 4], [1, 2, 3], [1, 2], [1]])
     * [5, [1, 2, 3, 4, 5]]
     * > maxLengthList([[3, 4, 5], [6, 7, 8, 9], [10, 11, 12]])
     * [4, [6, 7, 8, 9]]
     */
    public static List<Object> maxLengthList(List<List<Integer>> inputList) {
        List<Object> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        for (List<Integer> list : inputList) {
            if (list.size() > tempList.size()) {
                tempList = list;
            }
        }
        result.add(tempList.size());
        result.add(tempList);
        return result;
    }
}