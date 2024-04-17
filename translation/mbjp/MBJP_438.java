import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountBidirectional {
    /**
     * * Write a function to count bidirectional tuple pairs.
     *
     * > countBidirectional([[5, 6], [1, 2], [6, 5], [9, 1], [6, 5], [2, 1]])
     * "3"
     * > countBidirectional([[5, 6], [1, 3], [6, 5], [9, 1], [6, 5], [2, 1]])
     * "2"
     * > countBidirectional([[5, 6], [1, 2], [6, 5], [9, 2], [6, 5], [2, 1]])
     * "4"
     */
    public static String countBidirectional(List<List<Integer>> testList) {
        int res = 0;
        for (int i = 0; i < testList.size(); i++) {
            for (int j = i + 1; j < testList.size(); j++) {
                if (testList.get(j).get(0) == testList.get(i).get(1) && testList.get(i).get(1) == testList.get(j).get(0)) {
                    res += 1;
                }
            }
        }
        return Integer.toString(res);
    }
}