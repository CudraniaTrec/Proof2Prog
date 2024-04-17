import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RecursiveListSum {
    /**
     * * Write a function of recursion list sum.
     *
     * > recursiveListSum([1, 2, [3, 4], [5, 6]])
     * 21
     * > recursiveListSum([7, 10, [15, 14], [19, 41]])
     * 106
     * > recursiveListSum([10, 20, [30, 40], [50, 60]])
     * 210
     */
    public static int recursiveListSum(List<Object> dataList) {
        int res = 0;
        for (Object obj : dataList) {
            if (obj instanceof List) {
                int sum = recursiveListSum((List) obj);
                res += sum;
            } else if (obj instanceof Integer) {
                res += ((Integer) obj).intValue();
            }
        }
        return res;
    }
}