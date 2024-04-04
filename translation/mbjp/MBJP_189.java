import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FirstMissingPositive {
    /**
     * * Write a Java function to find the first missing positive number.
     *
     * > firstMissingPositive([1, 2, 3, -1, 5], 5)
     * 4
     * > firstMissingPositive([0, -1, -2, 1, 5, 8], 6)
     * 2
     * > firstMissingPositive([0, 1, 2, 5, -8], 5)
     * 3
     */
    public static int firstMissingPositive(List<Integer> arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (map.containsKey(arr.get(i))) {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            } else {
                map.put(arr.get(i), 1);
            }
        }

        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (!map.containsKey(i) || map.get(i) == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}