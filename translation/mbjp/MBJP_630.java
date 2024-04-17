import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetCoordinates {
    /**
     * * Write a function to extract all the adjacent coordinates of the given coordinate tuple.
     *
     * > getCoordinates([3, 4])
     * [[2, 3], [2, 4], [2, 5], [3, 3], [3, 4], [3, 5], [4, 3], [4, 4], [4, 5]]
     * > getCoordinates([4, 5])
     * [[3, 4], [3, 5], [3, 6], [4, 4], [4, 5], [4, 6], [5, 4], [5, 5], [5, 6]]
     * > getCoordinates([5, 6])
     * [[4, 5], [4, 6], [4, 7], [5, 5], [5, 6], [5, 7], [6, 5], [6, 6], [6, 7]]
     */
    public static List<List<Integer>> getCoordinates(List<Integer> testTup) {
        List<List<Integer>> ans = new ArrayList<>();
        int x = testTup.get(0), y = testTup.get(1);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                List<Integer> coords = new ArrayList<>();
                coords.add(x + i);
                coords.add(y + j);
                ans.add(coords);
            }
        }
        return ans;
    }
}