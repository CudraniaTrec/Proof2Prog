import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MutipleTuple {
    /**
     * * Write a Java function to calculate the product of all the numbers of a given tuple.
     *
     * > mutipleTuple([4, 3, 2, 2, -1, 18])
     * -864
     * > mutipleTuple([1, 2, 3])
     * 6
     * > mutipleTuple([-2, -4, -6])
     * -48
     */
    public static int mutipleTuple(List<Integer> nums) {
        int product = 1;
        for (Integer i : nums) {
            product = product * i;
        }
        return product;
    }
}