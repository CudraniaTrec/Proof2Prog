import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RearrangeNumbs {
    /**
     * * Write a function to rearrange positive and negative numbers in a given array using lambda function.
     *
     * > rearrangeNumbs([-1, 2, -3, 5, 7, 8, 9, -10])
     * [2, 5, 7, 8, 9, -10, -3, -1]
     * > rearrangeNumbs([10, 15, 14, 13, -18, 12, -20])
     * [10, 12, 13, 14, 15, -20, -18]
     * > rearrangeNumbs([-20, 20, -10, 10, -30, 30])
     * [10, 20, 30, -30, -20, -10]
     */
    public static List<Integer> rearrangeNumbs(List<Integer> arrayNums) {
        List<Integer> rearrangedNumbs = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        for (Integer num : arrayNums) {
            if (num > 0) {
                positive.add(num);
            } else if (num < 0) {
                negative.add(num);
            }
        }
        Collections.sort(negative);
        Collections.sort(positive);
        for (int i = 0; i < positive.size(); i++) {
            rearrangedNumbs.add(positive.get(i));
        }
        for (int i = 0; i < negative.size(); i++) {
            rearrangedNumbs.add(negative.get(i));
        }
        return rearrangedNumbs;
    }
}