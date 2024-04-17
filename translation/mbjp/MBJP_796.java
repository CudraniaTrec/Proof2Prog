import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReturnSum {
    /**
     * * Write function to find the sum of all items in the given dictionary.
     *
     * > returnSum({"a": 100, "b": 200, "c": 300})
     * 600
     * > returnSum({"a": 25, "b": 18, "c": 45})
     * 88
     * > returnSum({"a": 36, "b": 39, "c": 49})
     * 124
     */
    public static int returnSum(HashMap<String, Integer> dict) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }
}