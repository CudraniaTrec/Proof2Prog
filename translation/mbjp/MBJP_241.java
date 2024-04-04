import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Array3d {
    /**
     * * Write a function to generate a 3d array having each element as '*'.
     *
     * > array3d(6, 4, 3)
     * [[["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"]], [["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"]], [["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*", "*"]]]
     * > array3d(5, 3, 4)
     * [[["*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*"]], [["*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*"]], [["*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*"]], [["*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*"], ["*", "*", "*", "*", "*"]]]
     * > array3d(1, 2, 3)
     * [[["*"], ["*"]], [["*"], ["*"]], [["*"], ["*"]]]
     */
    public static List<List<List<String>>> array3d(int m, int n, int o) {
        List<List<List<String>>> output = new ArrayList<>();
        for (int i = 0; i < o; i++) {
            List<List<String>> row = new ArrayList<>();
            output.add(row);
            for (int j = 0; j < n; j++) {
                List<String> curr = new ArrayList<>();
                row.add(curr);
                for (int k = 0; k < m; k++) {
                    curr.add("*");
                }
            }
        }
        return output;
    }
}