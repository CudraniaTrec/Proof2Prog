import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LargNnum {
    /**
     * * Write a function to get the n largest items from a dataset.
     *
     * > largNnum([10, 20, 50, 70, 90, 20, 50, 40, 60, 80, 100], 2)
     * [100, 90]
     * > largNnum([10, 20, 50, 70, 90, 20, 50, 40, 60, 80, 100], 5)
     * [100, 90, 80, 70, 60]
     * > largNnum([10, 20, 50, 70, 90, 20, 50, 40, 60, 80, 100], 3)
     * [100, 90, 80]
     */
    public static List<Integer> largNnum(List<Integer> list1, int n) {
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            list2.add(list1.get(i));
        }
        Collections.sort(list2, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a < b) {
                    return 1;
                } else if (a == b) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return list2.subList(0, n);
    }
}