import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckIdentical {
    /**
     * * Write a function to check if two lists of tuples are identical or not.
     *
     * > checkIdentical([[10, 4], [2, 5]], [[10, 4], [2, 5]])
     * true
     * > checkIdentical([[1, 2], [3, 7]], [[12, 14], [12, 45]])
     * false
     * > checkIdentical([[2, 14], [12, 25]], [[2, 14], [12, 25]])
     * true
     */
    public static Boolean checkIdentical(List<List<Integer>> testList1, List<List<Integer>> testList2) {
        if (testList1.size() != testList2.size())
            return false;
        for (int i = 0; i < testList1.size(); i++) {
            if (!testList1.get(i).equals(testList2.get(i)))
                return false;
        }
        return true;
    }
}