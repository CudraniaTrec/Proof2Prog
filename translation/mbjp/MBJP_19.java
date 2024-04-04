import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TestDuplicate {
    /**
     * * Write a function to find whether a given array of integers contains any duplicate element.
     *
     * > testDuplicate([1, 2, 3, 4, 5])
     * false
     * > testDuplicate([1, 2, 3, 4, 4])
     * true
     * > testDuplicate([1, 1, 2, 2, 3, 3, 4, 4, 5])
     * true
     */
    public static Boolean testDuplicate(List<Integer> arraynums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arraynums.size(); i++) {
            if (set.contains(arraynums.get(i))) {
                return true;
            }
            set.add(arraynums.get(i));
        }
        return false;
    }
}