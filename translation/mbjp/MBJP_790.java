import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EvenPosition {
    /**
     * * Write a Java function to check whether every even index contains even numbers of a given list.
     *
     * > evenPosition([3, 2, 1])
     * false
     * > evenPosition([1, 2, 3])
     * false
     * > evenPosition([2, 1, 4])
     * true
     */
    public static Boolean evenPosition(List<Integer> nums) {
        boolean flag = false;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0 && i % 2 == 0) {
                flag = true;
            }
        }
        return flag;
    }
}