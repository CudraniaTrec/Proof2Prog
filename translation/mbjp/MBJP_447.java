import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CubeNums {
    /**
     * * Write a function to find cubes of individual elements in a list using lambda function.
     *
     * > cubeNums([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * [1, 8, 27, 64, 125, 216, 343, 512, 729, 1000]
     * > cubeNums([10, 20, 30])
     * [1000, 8000, 27000]
     * > cubeNums([12, 15])
     * [1728, 3375]
     */
    public static List<Integer> cubeNums(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : nums) {
            result.add(num * num * num);
        }
        return result;
    }
}