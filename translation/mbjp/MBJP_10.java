import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SmallNnum {
    /**
     * * Write a function to get the n smallest items from a dataset.
     *
     * > smallNnum([10, 20, 50, 70, 90, 20, 50, 40, 60, 80, 100], 2)
     * [10, 20]
     * > smallNnum([10, 20, 50, 70, 90, 20, 50, 40, 60, 80, 100], 5)
     * [10, 20, 20, 40, 50]
     * > smallNnum([10, 20, 50, 70, 90, 20, 50, 40, 60, 80, 100], 3)
     * [10, 20, 20]
     */
    public static List<Integer> smallNnum(List<Integer> list1, int n) {
        if (list1 == null || list1.size() < n)
            return null;
        if (list1.size() == 0)
            return list1;

        List<Integer> list2 = new ArrayList<>(list1);
        Collections.sort(list2);

        return list2.subList(0, n);
    }
}