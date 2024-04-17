import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumThreeSmallestNums {
    /**
     * * Write a Java function to find the sum of the three lowest positive numbers from a given list of numbers.
     *
     * > sumThreeSmallestNums([10, 20, 30, 40, 50, 60, 7])
     * 37
     * > sumThreeSmallestNums([1, 2, 3, 4, 5])
     * 6
     * > sumThreeSmallestNums([0, 1, 2, 3, 4, 5])
     * 6
     */
    public static int sumThreeSmallestNums(List<Integer> lst) {
        int ret = 0;

        List<Integer> sorted = new ArrayList<Integer>();
        for (int x : lst) {
            if (x > 0) {
                sorted.add(x);
            }
        }

        Collections.sort(sorted);

        for (int i = 0; i < 3; i++) {
            ret += sorted.get(i);
        }

        return ret;
    }
}