import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetPosition {
    /**
     * * Write a Java function to find the position of the last removed element from the given array.
     *
     * > getPosition([2, 5, 4], 3, 2)
     * 2
     * > getPosition([4, 3], 2, 2)
     * 2
     * > getPosition([1, 2, 3, 4], 4, 1)
     * 4
     */
    public static int getPosition(List<Integer> a, int n, int m) {
        for (int i = 0; i < n; i++) {
            a.set(i, (a.get(i) % m == 0) ? a.get(i) / m : a.get(i) / m + 1);
        }
        int result = -1;
        int maxx = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (maxx < a.get(i)) {
                maxx = a.get(i);
                result = i;
            }
        }
        return result + 1;
    }
}