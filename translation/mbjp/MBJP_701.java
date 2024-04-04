import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EquilibriumIndex {
    /**
     * * Write a function to find the equilibrium index of the given array.
     *
     * > equilibriumIndex([1, 2, 3, 4, 1, 2, 3])
     * 3
     * > equilibriumIndex([-7, 1, 5, 2, -4, 3, 0])
     * 3
     * > equilibriumIndex([1, 2, 3])
     * -1
     */
    public static int equilibriumIndex(List<Integer> arr) {
        int n = arr.size();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (arr.get(left) != arr.get(right)) {
                int mid = left + (right - left) / 2;
                if (arr.get(left) > arr.get(mid) && arr.get(mid) > arr.get(right)) {
                    right = mid;
                } else if (arr.get(left) < arr.get(mid) && arr.get(mid) < arr.get(right)) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                left++;
                right--;
            }
        }
        return -1;
    }
}