import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AdjacentNumProduct {
    /**
     * * Write a Java function to find the largest product of the pair of adjacent elements from a given list of integers.
     *
     * > adjacentNumProduct([1, 2, 3, 4, 5, 6])
     * 30
     * > adjacentNumProduct([1, 2, 3, 4, 5])
     * 20
     * > adjacentNumProduct([2, 3])
     * 6
     */
    public static int adjacentNumProduct(List<Integer> listNums) {
        int result = 0;
        for (int i = 0; i < listNums.size(); i++) {
            for (int j = i + 1; j < listNums.size(); j++) {
                if (listNums.get(i) * listNums.get(j) > result) {
                    result = listNums.get(i) * listNums.get(j);
                }
            }
        }
        return result;
    }
}