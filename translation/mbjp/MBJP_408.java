import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class KSmallestPairs {
    /**
     * * Write a function to find k number of pairs which consist of one element from the first array and one element from the second array.
     *
     * > kSmallestPairs([1, 3, 7], [2, 4, 6], 2)
     * [[1, 2], [1, 4]]
     * > kSmallestPairs([1, 3, 7], [2, 4, 6], 1)
     * [[1, 2]]
     * > kSmallestPairs([1, 3, 7], [2, 4, 6], 7)
     * [[1, 2], [1, 4], [3, 2], [1, 6], [3, 4], [3, 6], [7, 2]]
     */
    public static List<List<Integer>> kSmallestPairs(List<Integer> nums1, List<Integer> nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = 0; j < nums2.size(); j++) {
                pairs.add(new ArrayList<Integer>(Arrays.asList(nums1.get(i), nums2.get(j))));
            }
        }
        Collections.sort(pairs, new Comparator<List<Integer>>() {
            public int compare(List<Integer> pair1, List<Integer> pair2) {
                return pair1.get(0) + pair1.get(1) - pair2.get(0) - pair2.get(1);
            }
        });
        return pairs.subList(0, k);
    }
}