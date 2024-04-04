import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ChunkTuples {
    /**
     * * Write a function to perform chunking of tuples each of size n.
     *
     * > chunkTuples([10, 4, 5, 6, 7, 6, 8, 3, 4], 3)
     * [[10, 4, 5], [6, 7, 6], [8, 3, 4]]
     * > chunkTuples([1, 2, 3, 4, 5, 6, 7, 8, 9], 2)
     * [[1, 2], [3, 4], [5, 6], [7, 8], [9]]
     * > chunkTuples([11, 14, 16, 17, 19, 21, 22, 25], 4)
     * [[11, 14, 16, 17], [19, 21, 22, 25]]
     */
    public static List<List<Integer>> chunkTuples(List<Integer> testTup, int n) {
        // Write your code here
        List<List<Integer>> output = new ArrayList<>();
        int start = 0;
        while (start < testTup.size()) {
            int end = start + n - 1;
            if (end >= testTup.size()) {
                end = testTup.size() - 1;
            }
            List<Integer> chunk = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                chunk.add(testTup.get(i));
            }
            output.add(chunk);
            start = end + 1;
        }
        return output;
    }
}