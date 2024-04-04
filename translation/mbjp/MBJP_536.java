import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NthItems {
    /**
     * * Write a function to select the nth items of a list.
     *
     * > nthItems([1, 2, 3, 4, 5, 6, 7, 8, 9], 2)
     * [1, 3, 5, 7, 9]
     * > nthItems([10, 15, 19, 17, 16, 18], 3)
     * [10, 17]
     * > nthItems([14, 16, 19, 15, 17], 4)
     * [14, 17]
     */
    public static List<Integer> nthItems(List<Integer> list, int n) {
        List<Integer> result = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i % n == 0) {
                result.add(list.get(i));
            }
        }
        return result;
    }
}