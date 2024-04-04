import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckConsecutive {
    /**
     * * Write a Java function to check whether the given list contains consecutive numbers or not.
     *
     * > checkConsecutive([1, 2, 3, 4, 5])
     * true
     * > checkConsecutive([1, 2, 3, 5, 6])
     * false
     * > checkConsecutive([1, 2, 1])
     * false
     */
    public static Boolean checkConsecutive(List<Integer> l) {
        int count = 0;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i).equals(i + 1)) {
                return false;
            }
            count++;
        }
        return count == l.size();
    }
}