import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindLists {
    /**
     * * Write a function to find number of lists present in the given tuple.
     *
     * > findLists([[1, 2, 3, 4], [5, 6, 7, 8]])
     * 2
     * > findLists([9, 8, 7, 6, 5, 4, 3, 2, 1])
     * 1
     */
    public static int findLists(List<Object> input) {
        if (input.size() == 0) {
            return 0;
        }
        if (input.get(0) instanceof List) {
            return 1 + findLists((List<Object>) input.get(0));
        }
        return 1;
    }
}