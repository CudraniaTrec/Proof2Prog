import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindRotationCount {
    /**
     * * Write a function to find the number of rotations in a circularly sorted array.
     *
     * > findRotationCount([8, 9, 10, 1, 2, 3, 4, 5, 6, 7])
     * 3
     * > findRotationCount([8, 9, 10, 2, 5, 6])
     * 3
     * > findRotationCount([2, 5, 6, 8, 9, 10])
     * 0
     */
    public static int findRotationCount(List<Integer> a) {
        int count = 0;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            int pos = i;
            for (int j = i + 1; j < size; j++) {
                if (a.get(pos) > a.get(j)) {
                    pos = j;
                }
            }
            if (a.get(i) > a.get(pos)) {
                count++;
            }
        }
        return count;
    }
}