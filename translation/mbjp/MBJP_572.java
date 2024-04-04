import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TwoUniqueNums {
    /**
     * * Write a Java function to remove two duplicate numbers from a given number of lists.
     *
     * > twoUniqueNums([1, 2, 3, 2, 3, 4, 5])
     * [1, 4, 5]
     * > twoUniqueNums([1, 2, 3, 2, 4, 5])
     * [1, 3, 4, 5]
     * > twoUniqueNums([1, 2, 3, 4, 5])
     * [1, 2, 3, 4, 5]
     */
    public static List<Integer> twoUniqueNums(List<Integer> nums) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (temp.contains(nums.get(i))) {
                temp.remove(nums.get(i));
            } else {
                temp.add(nums.get(i));
            }
        }
        return temp;
    }
}