import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetInvCount {
    /**
     * * Write a function to count the number of inversions in the given array.
     *
     * > getInvCount([1, 20, 6, 4, 5], 5)
     * 5
     * > getInvCount([8, 4, 2, 1], 4)
     * 6
     * > getInvCount([3, 1, 2], 3)
     * 2
     */
    public static int getInvCount(List<Integer> arr, int n) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    count++;
                }
            }
        }
        return count;
    }
}