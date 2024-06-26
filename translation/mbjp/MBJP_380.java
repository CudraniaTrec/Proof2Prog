import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MultiList {
    /**
     * * Write a function to generate a two-dimensional array.
     *
     * > multiList(3, 4)
     * [[0, 0, 0, 0], [0, 1, 2, 3], [0, 2, 4, 6]]
     * > multiList(5, 7)
     * [[0, 0, 0, 0, 0, 0, 0], [0, 1, 2, 3, 4, 5, 6], [0, 2, 4, 6, 8, 10, 12], [0, 3, 6, 9, 12, 15, 18], [0, 4, 8, 12, 16, 20, 24]]
     * > multiList(10, 15)
     * [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14], [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28], [0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42], [0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 56], [0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70], [0, 6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72, 78, 84], [0, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98], [0, 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112], [0, 9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108, 117, 126]]
     */
    public static List<List<Integer>> multiList(int rownum, int colnum) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] matrix = new int[rownum][colnum];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = i * j;
            }
        }
        for (int r = 0; r < rownum; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < colnum; c++) {
                row.add(matrix[r][c]);
            }
            result.add(row);
        }
        return result;
    }
}