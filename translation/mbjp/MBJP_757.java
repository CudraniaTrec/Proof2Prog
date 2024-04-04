import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountReversePairs {
    /**
     * * Write a function to count the pairs of reverse strings in the given string list.
     *
     * > countReversePairs(["julia", "best", "tseb", "for", "ailuj"])
     * "2"
     * > countReversePairs(["geeks", "best", "for", "skeeg"])
     * "1"
     * > countReversePairs(["makes", "best", "sekam", "for", "rof"])
     * "2"
     */
    public static String countReversePairs(List<String> testList) {
        // write your code here
        int[] arr = new int[testList.size()];
        for (int i = 0; i < testList.size(); i++) {
            arr[i] = testList.get(i).length();
        }

        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    result++;
                }
            }
        }
        return String.valueOf(result);
    }
}