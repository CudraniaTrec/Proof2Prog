import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PosCount {
    /**
     * * Write a Java function to count positive numbers in a list.
     *
     * > posCount([1, -2, 3, -4])
     * 2
     * > posCount([3, 4, 5, -1])
     * 3
     * > posCount([1, 2, 3, 4])
     * 4
     */
    public static int posCount(List<Integer> list) {
        int count = 0;
        if (list.size() == 0) {
            return count;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                count++;
            }
        }
        return count;
    }
}