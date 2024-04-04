import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSumList {
    /**
     * * Write a function to find the list in a list of lists whose sum of elements is the highest.
     *
     * > maxSumList([[1, 2, 3], [4, 5, 6], [10, 11, 12], [7, 8, 9]])
     * [10, 11, 12]
     * > maxSumList([[3, 2, 1], [6, 5, 4], [12, 11, 10]])
     * [12, 11, 10]
     * > maxSumList([[2, 3, 1]])
     * [2, 3, 1]
     */
    public static List<Integer> maxSumList(List<List<Integer>> lists) {
        int maxSum = 0;
        List<Integer> list = new ArrayList<>();
        for (List<Integer> list1 : lists) {
            int sum = 0;
            for (int i : list1) {
                sum += i;
            }
            if (sum > maxSum) {
                maxSum = sum;
                list = new ArrayList<>();
                list.addAll(list1);
            } else if (sum == maxSum) {
                list.addAll(list1);
            }
        }
        return list;
    }
}