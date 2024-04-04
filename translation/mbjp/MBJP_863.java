import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindLongestConseqSubseq {
    /**
     * * Write a function to find the length of the longest sub-sequence such that elements in the subsequences are consecutive integers.
     *
     * > findLongestConseqSubseq([1, 2, 2, 3], 4)
     * 3
     * > findLongestConseqSubseq([1, 9, 3, 10, 4, 20, 2], 7)
     * 4
     * > findLongestConseqSubseq([36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42], 11)
     * 5
     */
    public static int findLongestConseqSubseq(List<Integer> arr, int n) {
        int ans = 0, count = 0;
        arr.sort(Comparator.naturalOrder());
        List<Integer> v = new ArrayList<>();
        v.add(arr.get(0));
        for (int i = 1; i < n; i++) {
            if (arr.get(i) != arr.get(i - 1)) {
                v.add(arr.get(i));
            }
        }
        for (int i = 0; i < v.size(); i++) {
            if (i > 0 && v.get(i) == v.get(i - 1) + 1) {
                count += 1;
            } else {
                count = 1;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}