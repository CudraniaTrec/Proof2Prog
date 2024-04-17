import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReverseArrayUptoK {
    /**
     * * Write a Java function to reverse an array upto a given position.
     *
     * > reverseArrayUptoK([1, 2, 3, 4, 5, 6], 4)
     * [4, 3, 2, 1, 5, 6]
     * > reverseArrayUptoK([4, 5, 6, 7], 2)
     * [5, 4, 6, 7]
     * > reverseArrayUptoK([9, 8, 7, 6, 5], 3)
     * [7, 8, 9, 6, 5]
     */
    public static List<Integer> reverseArrayUptoK(List<Integer> input, int k) {
        int l = 0;
        int r = k - 1;
        while (l < r) {
            int temp = input.get(l);
            input.set(l, input.get(r));
            input.set(r, temp);
            l++;
            r--;
        }
        return input;
    }
}