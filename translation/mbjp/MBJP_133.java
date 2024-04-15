import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class SumNegativenum {
    /**
     * * Write a function to calculate the sum of the negative numbers of a given
     * list of numbers using lambda function.
     *
     * > sumNegativenum([2, 4, -6, -9, 11, -12, 14, -5, 17])
     * -32
     * > sumNegativenum([10, 15, -14, 13, -18, 12, -20])
     * -52
     * > sumNegativenum([19, -65, 57, 39, 152, -639, 121, 44, 90, -190])
     * -894
     */
    public static int sumNegativenum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).filter(n -> n < 0).sum();
    }
}