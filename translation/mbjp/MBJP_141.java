import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PancakeSort {
    /**
     * * Write a function to sort a list of elements using pancake sort.
     *
     * > pancakeSort([15, 79, 25, 38, 69])
     * [15, 25, 38, 69, 79]
     * > pancakeSort([98, 12, 54, 36, 85])
     * [12, 36, 54, 85, 98]
     * > pancakeSort([41, 42, 32, 12, 23])
     * [12, 23, 32, 41, 42]
     */
    public static List<Integer> pancakeSort(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                map.put(nums.get(i), map.get(nums.get(i)) - 1);
            } else {
                map.put(nums.get(i), 1);
            }
        }
        List<Integer> sorted = new ArrayList<>(map.keySet());
        Collections.sort(sorted);
        return sorted;
    }
}