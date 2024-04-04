import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TestDistinct {
    /**
     * * Write a Java function to determine whether all the numbers are different from each other are not.
     *
     * > testDistinct([1, 5, 7, 9])
     * true
     * > testDistinct([2, 4, 5, 5, 7, 9])
     * false
     * > testDistinct([1, 2, 3])
     * true
     */
    public static Boolean testDistinct(List<Integer> data) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < data.size(); i++) {
            if (set.contains(data.get(i))) {
                return false;
            }
            set.add(data.get(i));
        }
        return true;
    }
}