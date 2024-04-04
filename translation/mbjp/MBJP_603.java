import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetLudic {
    /**
     * * Write a function to get a lucid number smaller than or equal to n.
     *
     * > getLudic(10)
     * [1, 2, 3, 5, 7]
     * > getLudic(25)
     * [1, 2, 3, 5, 7, 11, 13, 17, 23, 25]
     * > getLudic(45)
     * [1, 2, 3, 5, 7, 11, 13, 17, 23, 25, 29, 37, 41, 43]
     */
    public static List<Integer> getLudic(int n) {
        List<Integer> ludics = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            ludics.add(i);
        }
        int index = 1;
        while (index != ludics.size()) {
            int firstLudic = ludics.get(index);
            int removeIndex = index + firstLudic;
            while (removeIndex < ludics.size()) {
                ludics.remove(ludics.get(removeIndex));
                removeIndex = removeIndex + firstLudic - 1;
            }
            index++;
        }
        return ludics;
    }
}