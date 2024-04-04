import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumColumn {
    /**
     * * Write a function to sum a specific column of a list in a given list of lists.
     *
     * > sumColumn([[1, 2, 3, 2], [4, 5, 6, 2], [7, 8, 9, 5]], 0)
     * 12
     * > sumColumn([[1, 2, 3, 2], [4, 5, 6, 2], [7, 8, 9, 5]], 1)
     * 15
     * > sumColumn([[1, 2, 3, 2], [4, 5, 6, 2], [7, 8, 9, 5]], 3)
     * 9
     */
    public static int sumColumn(List<List<Integer>> list1, int c) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).size() == c) {
                sum += list1.get(i).get(c);
            } else {
                sum += list1.get(i).get(c);
            }
        }
        return sum;
    }
}