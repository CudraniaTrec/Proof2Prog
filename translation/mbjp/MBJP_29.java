import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetOddOccurrence {
    /**
     * * Write a Java function to find the element occurring odd number of times.
     *
     * > getOddOccurrence([1, 2, 3, 1, 2, 3, 1], 7)
     * 1
     * > getOddOccurrence([1, 2, 3, 2, 3, 1, 3], 7)
     * 3
     * > getOddOccurrence([2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2], 13)
     * 5
     */
    public static int getOddOccurrence(List<Integer> arr, int arrSize) {
        int odd = 0;
        for (int i = 0; i < arrSize; i++) {
            odd = odd ^ arr.get(i);
        }
        return odd;
    }
}