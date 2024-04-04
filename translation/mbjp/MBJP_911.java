import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaximumProduct {
    /**
     * * Write a function to compute maximum product of three numbers of a given array of integers using heap queue algorithm.
     *
     * > maximumProduct([12, 74, 9, 50, 61, 41])
     * 225700
     * > maximumProduct([25, 35, 22, 85, 14, 65, 75, 25, 58])
     * 414375
     * > maximumProduct([18, 14, 10, 9, 8, 7, 9, 3, 2, 4, 1])
     * 2520
     */
    public static int maximumProduct(List<Integer> nums) {
        // Write your code here
        int n = nums.size();
        int m = nums.get(0);
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    int temp = nums.get(i) * nums.get(j) * nums.get(k);
                    if(temp > max){
                        max = temp;
                        m = nums.get(i);
                    }
                }
            }
        }
        return max;
    }
}