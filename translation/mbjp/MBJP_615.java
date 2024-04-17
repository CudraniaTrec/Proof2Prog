import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AverageTuple {
    /**
     * * Write a function to find average value of the numbers in a given tuple of tuples.
     *
     * > averageTuple([[10, 10, 10, 12], [30, 45, 56, 45], [81, 80, 39, 32], [1, 2, 3, 4]])
     * [30.5, 34.25, 27.0, 23.25]
     * > averageTuple([[1, 1, -5], [30, -15, 56], [81, -60, -39], [-10, 2, 3]])
     * [25.5, -18.0, 3.75]
     * > averageTuple([[100, 100, 100, 120], [300, 450, 560, 450], [810, 800, 390, 320], [10, 20, 30, 40]])
     * [305.0, 342.5, 270.0, 232.5]
     */
    public static List<Double> averageTuple(List<List<Integer>> nums) {
        int count = nums.get(0).size();
        List<Double> avg = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            double sum = 0.0;
            for (List<Integer> list : nums) {
                sum += list.get(i);
            }
            avg.add(sum / nums.size());
        }
        return avg;
    }
}