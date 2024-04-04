import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumOfSubarrayProd {
    /**
     * * Write a Java function to find sum of products of all possible subarrays.
     *
     * > sumOfSubarrayProd([1, 2, 3], 3)
     * 20
     * > sumOfSubarrayProd([1, 2], 2)
     * 5
     * > sumOfSubarrayProd([1, 2, 3, 4], 4)
     * 84
     */
    public static int sumOfSubarrayProd(List<Integer> arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < arr.size(); j++) {
                int sum1 = 1;
                for (int k = i; k <= j; k++) {
                    sum1 *= arr.get(k);
                }
                sum += sum1;
            }
        }
        return sum;
    }
}