import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindElement {
    /**
     * * Write a Java function to find element at a given index after number of rotations.
     *
     * > findElement([1, 2, 3, 4, 5], [[0, 2], [0, 3]], 2, 1)
     * 3
     * > findElement([1, 2, 3, 4], [[0, 1], [0, 2]], 1, 2)
     * 3
     * > findElement([1, 2, 3, 4, 5, 6], [[0, 1], [0, 2]], 1, 1)
     * 1
     */
    public static int findElement(List<Integer> arr, List<List<Integer>> ranges, int rotations, int index) {
        for (int i = rotations - 1; i >= 0; i--) {
            int left = ranges.get(i).get(0);
            int right = ranges.get(i).get(1);
            if (left <= index && right >= index) {
                if (index == left) {
                    index = right;
                } else {
                    index = index - 1;
                }
            }
        }
        return arr.get(index);
    }
}