import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LuckyNum {
    /**
     * * Write a function to print the first n lucky numbers.
     *
     * > luckyNum(10)
     * [1, 3, 7, 9, 13, 15, 21, 25, 31, 33]
     * > luckyNum(5)
     * [1, 3, 7, 9, 13]
     * > luckyNum(8)
     * [1, 3, 7, 9, 13, 15, 21, 25]
     */
    public static List<Integer> luckyNum(int n) {
        List<Integer> result = new ArrayList<>();
        int arr[] = new int[]{1,3,7,9,13,15,21,25,31,33};
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                result.add(arr[i]);
                set.remove(arr[i]);
            }
        }
        return result;
    }
}