import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetOddOccurence {
    /**
     * * Write a function to find the number which occurs for odd number of times in the given array.
     *
     * > getOddOccurence([2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2], 13)
     * 5
     * > getOddOccurence([1, 2, 3, 2, 3, 1, 3], 7)
     * 3
     * > getOddOccurence([5, 7, 2, 7, 5, 2, 5], 7)
     * 5
     */
    public static int getOddOccurence(List<Integer> arr, int arrSize) {
        int count = 0;
        for (int i = 0; i < arrSize; i++) {
            count = count ^ arr.get(i);
        }
        return count;
    }
}