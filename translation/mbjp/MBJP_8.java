import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SquareNums {
    /**
     * * Write a function to find squares of individual elements in a list using lambda function.
     *
     * > squareNums([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
     * > squareNums([10, 20, 30])
     * [100, 400, 900]
     * > squareNums([12, 15])
     * [144, 225]
     */
    public static List<Integer> squareNums(List<Integer> nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            res.add(nums.get(i) * nums.get(i));
        }
        return res;
    }
}