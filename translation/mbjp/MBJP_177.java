import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Answer {
    /**
     * * Write a Java function to find two distinct numbers such that their lcm lies within the given range.
     *
     * > answer(3, 8)
     * [3, 6]
     * > answer(2, 6)
     * [2, 4]
     * > answer(1, 3)
     * [1, 2]
     */
    public static List<Integer> answer(int l, int r) {
        List<Integer> lcm = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % l == 0 || i % r == 0) {
                if (lcm.size() < 2) {
                    lcm.add(i);
                } else if (lcm.get(0) <= i && i <= lcm.get(1)) {
                    lcm.remove(0);
                    lcm.add(i);
                } else {
                    break;
                }
            }
        }
        return lcm;
    }
}