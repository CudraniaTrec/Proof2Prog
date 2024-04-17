import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReArrangeArray {
    /**
     * * Write a function to re-arrange the elements of the given array so that all negative elements appear before positive ones.
     *
     * > reArrangeArray([-1, 2, -3, 4, 5, 6, -7, 8, 9], 9)
     * [-1, -3, -7, 4, 5, 6, 2, 8, 9]
     * > reArrangeArray([12, -14, -26, 13, 15], 5)
     * [-14, -26, 12, 13, 15]
     * > reArrangeArray([10, 24, 36, -42, -39, -78, 85], 7)
     * [-42, -39, -78, 10, 24, 36, 85]
     */
    public static List<Integer> reArrangeArray(List<Integer> arr, int n) {
        // write your code here
        int i=0, j=0;
        for(i = 0; i < n; i++){
            if(arr.get(i) < 0){
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                j++;
            }
        }
        return arr;
    }
}