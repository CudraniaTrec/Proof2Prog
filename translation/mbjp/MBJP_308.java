import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LargeProduct {
    /**
     * * Write a function to find the specified number of largest products from two given lists.
     *
     * > largeProduct([1, 2, 3, 4, 5, 6], [3, 6, 8, 9, 10, 6], 3)
     * [60, 54, 50]
     * > largeProduct([1, 2, 3, 4, 5, 6], [3, 6, 8, 9, 10, 6], 4)
     * [60, 54, 50, 48]
     * > largeProduct([1, 2, 3, 4, 5, 6], [3, 6, 8, 9, 10, 6], 5)
     * [60, 54, 50, 48, 45]
     */
    public static List<Integer> largeProduct(List<Integer> nums1, List<Integer> nums2, int n) {
        // Write your code here
        int [] arr = new int [nums1.size()*nums2.size()];
        for(int i=0; i<nums1.size(); i++){
            for(int j=0; j<nums2.size(); j++){
                arr[i*nums2.size()+j] = nums1.get(i)*nums2.get(j);
            }
        }
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            result.add(arr[arr.length-1-i]);
        }
        return result;
    }
}