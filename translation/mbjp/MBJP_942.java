import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckElement {
    /**
     * * Write a function to check if any list element is present in the given list.
     *
     * > checkElement([4, 5, 7, 9, 3], [6, 7, 10, 11])
     * true
     * > checkElement([1, 2, 3, 4], [4, 6, 7, 8, 9])
     * true
     * > checkElement([3, 2, 1, 4, 5], [9, 8, 7, 6])
     * false
     */
    public static Boolean checkElement(List<Integer> testTup, List<Integer> checkList) {
        if (testTup == null) {
            return checkList == null || checkList.size() == 0;
        }
        if (checkList == null) {
            return true;
        }
        for (Integer t : testTup) {
            if (checkList.contains(t)) {
                return true;
            }
        }
        return false;
    }
}