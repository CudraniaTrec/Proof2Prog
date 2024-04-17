import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ZipTuples {
    /**
     * * Write a function to zip the two given tuples.
     *
     * > zipTuples([7, 8, 4, 5, 9, 10], [1, 5, 6])
     * [[7, 1], [8, 5], [4, 6], [5, 1], [9, 5], [10, 6]]
     * > zipTuples([8, 9, 5, 6, 10, 11], [2, 6, 7])
     * [[8, 2], [9, 6], [5, 7], [6, 2], [10, 6], [11, 7]]
     * > zipTuples([9, 10, 6, 7, 11, 12], [3, 7, 8])
     * [[9, 3], [10, 7], [6, 8], [7, 3], [11, 7], [12, 8]]
     */
    public static List<List<Integer>> zipTuples(List<Integer> testTup1, List<Integer> testTup2) {
      ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
      for (int i = 0; i < testTup1.size(); i++) {
        List<Integer> testlist = new ArrayList<Integer>();
        testlist.add(testTup1.get(i));
        testlist.add(testTup2.get(i % testTup2.size()));
        res.add(testlist);
      }
      return res;
    }
}