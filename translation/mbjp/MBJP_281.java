import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AllUnique {
    /**
     * * Write a Java function to check if the elements of a given list are unique or not.
     *
     * > allUnique([1, 2, 3])
     * true
     * > allUnique([1, 2, 1, 2])
     * false
     * > allUnique([1, 2, 3, 4, 5])
     * true
     */
    public static Boolean allUnique(List<Integer> testList) {
        HashMap<Integer, Integer> list = new HashMap<>();
        for (int i = 0; i < testList.size(); i++) {
            if (list.containsKey(testList.get(i))) {
                return false;
            }
            list.put(testList.get(i), 1);
        }
        return true;
    }
}