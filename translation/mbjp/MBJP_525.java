import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ParallelLines {
    /**
     * * Write a Java function to check whether two given lines are parallel or not.
     *
     * > parallelLines([2, 3, 4], [2, 3, 8])
     * true
     * > parallelLines([2, 3, 4], [4, -3, 8])
     * false
     * > parallelLines([3, 3], [5, 5])
     * true
     */
    public static Boolean parallelLines(List<Integer> line1, List<Integer> line2) {
        boolean res = true;
        if (line1.size() > line2.size()) {
            res = false;
        }
        for (int i = 0; i < line1.size(); i++) {
            if (line1.get(i) > line2.get(i)) {
                res = false;
            }
        }
        return res;
    }
}