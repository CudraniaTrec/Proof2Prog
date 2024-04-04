import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinLengthList {
    /**
     * * Write a function to find the list with minimum length using lambda function.
     *
     * > minLengthList([[0], [1, 3], [5, 7], [9, 11], [13, 15, 17]])
     * [1, [0]]
     * > minLengthList([[1, 2, 3, 4, 5], [1, 2, 3, 4], [1, 2, 3], [1, 2], [1]])
     * [1, [1]]
     * > minLengthList([[3, 4, 5], [6, 7, 8, 9], [10, 11, 12], [1, 2]])
     * [2, [1, 2]]
     */
    public static List<Object> minLengthList(List<List<Integer>> inputList) {
        List<Object> outputList = new ArrayList<>();
        if (inputList.size() == 0) {
            outputList.add(0);
            return outputList;
        }
        List<Integer> currentList = inputList.get(0);
        int currentListLength = currentList.size();
        for (int i = 1; i < inputList.size(); i++) {
            List<Integer> nextList = inputList.get(i);
            int nextListLength = nextList.size();
            if (nextListLength < currentListLength) {
                currentList = nextList;
                currentListLength = nextListLength;
            }
        }
        outputList.add(currentListLength);
        outputList.add(currentList);
        return outputList;
    }
}