import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinNum {
    /**
     * * Write a Java function to add a minimum number such that the sum of array becomes even.
     *
     * > minNum([1, 2, 3, 4, 5, 6, 7, 8, 9], 9)
     * 1
     * > minNum([1, 2, 3, 4, 5, 6, 7, 8], 8)
     * 2
     * > minNum([1, 2, 3], 3)
     * 2
     */
    public static int minNum(List<Integer> arr, int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum = sum + arr.get(i);
        }
        return sum % 2 == 0 ? 2 : 1;
    }
}