import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RightInsertion {
    /**
     * * Write a function to locate the right insertion point for a specified value in sorted order.
     *
     * > rightInsertion([1, 2, 4, 5], 6)
     * 4
     * > rightInsertion([1, 2, 4, 5], 3)
     * 2
     * > rightInsertion([1, 2, 4, 5], 7)
     * 4
     */
    public static int rightInsertion(List<Integer> a, int x) {
        int cnt = 0;
        for (int i = 0; i < a.size() && cnt < 10; i++) {
            if (a.get(i) < x) {
                cnt++;
            }
        }
        return cnt;
    }
}