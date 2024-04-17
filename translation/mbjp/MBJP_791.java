import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveNested {
    /**
     * * Write a function to remove the nested record from the given tuple.
     *
     * > removeNested([1, 5, 7, [4, 6], 10])
     * [1, 5, 7, 10]
     * > removeNested([2, 6, 8, [5, 7], 11])
     * [2, 6, 8, 11]
     * > removeNested([3, 7, 9, [6, 8], 12])
     * [3, 7, 9, 12]
     */
    public static List<Integer> removeNested(List<Object> testTup) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < testTup.size(); i++) {
            if (testTup.get(i) instanceof Integer) {
                result.add((Integer) testTup.get(i));
            } else {
                List<Object> arr = (List<Object>) testTup.get(i);
                for (Object o : arr) {
                    if (o instanceof Integer) {
                        result.remove(o);
                    }
                }
            }
        }
        return result;
    }
}