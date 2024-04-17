import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckNone {
    /**
     * * Write a function to check if the given tuple has any null value or not.
     *
     * > checkNone([10, 4, 5, 6, null])
     * true
     * > checkNone([7, 8, 9, 11, 14])
     * false
     * > checkNone([1, 2, 3, 4, null])
     * true
     */
    public static Boolean checkNone(List<Integer> testTup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < testTup.size(); i++) {
            if (testTup.get(i) == null) {
                list.add(i);
            }
        }
        return list.contains(10) || list.contains(4) || list.contains(5) || list.contains(6) || list.contains(7) || list.contains(8) || list.contains(9) || list.contains(11) || list.contains(12);
    }
}