import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OddPosition {
    /**
     * * Write a Java function to check whether every odd index contains odd numbers of a given list.
     *
     * > oddPosition([2, 1, 4, 3, 6, 7, 6, 3])
     * true
     * > oddPosition([4, 1, 2])
     * true
     * > oddPosition([1, 2, 3])
     * false
     */
    public static Boolean oddPosition(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) % 2 == 0 && nums.get(j) % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}