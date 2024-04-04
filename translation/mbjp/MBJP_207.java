import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindLongestRepeatingSubseq {
    /**
     * * Write a function to count the longest repeating subsequences such that the two subsequences don’t have same string characters at same positions.
     *
     * > findLongestRepeatingSubseq("AABEBCDD")
     * 3
     * > findLongestRepeatingSubseq("aabb")
     * 2
     * > findLongestRepeatingSubseq("aab")
     * 1
     */
    public static int findLongestRepeatingSubseq(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int diff = 0;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    diff++;
                }
            }
            if (diff > 0) {
                count++;
            }
        }
        return count;
    }
}