import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortNumericStrings {
    /**
     * * Write a function to sort a given list of strings of numbers numerically.
     *
     * > sortNumericStrings(["4", "12", "45", "7", "0", "100", "200", "-12", "-500"])
     * [-500, -12, 0, 4, 7, 12, 45, 100, 200]
     * > sortNumericStrings(["2", "3", "8", "4", "7", "9", "8", "2", "6", "5", "1", "6", "1", "2", "3", "4", "6", "9", "1", "2"])
     * [1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8, 9, 9]
     * > sortNumericStrings(["1", "3", "5", "7", "1", "3", "13", "15", "17", "5", "7 ", "9", "1", "11"])
     * [1, 1, 1, 3, 3, 5, 5, 7, 7, 9, 11, 13, 15, 17]
     */
    public static List<Integer> sortNumericStrings(List<String> numsStr) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < numsStr.size(); i++) {
            int val = 0;
            if (numsStr.get(i).indexOf(' ') != -1) {
                val = Integer.parseInt(numsStr.get(i).split(" ")[0]);
            } else {
                val = Integer.parseInt(numsStr.get(i));
            }
            res.add(val);
        }
        Collections.sort(res);
        return res;
    }
}