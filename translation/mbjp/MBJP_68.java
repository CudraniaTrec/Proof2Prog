import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsMonotonic {
    /**
     * * Write a Java function to check whether the given array is monotonic or not.
     *
     * > isMonotonic([6, 5, 4, 4])
     * true
     * > isMonotonic([1, 2, 2, 3])
     * true
     * > isMonotonic([1, 3, 2])
     * false
     */
    public static Boolean isMonotonic(List<Integer> a) {
        int[] list = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            list[i] = a.get(i);
        }
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] == list[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}