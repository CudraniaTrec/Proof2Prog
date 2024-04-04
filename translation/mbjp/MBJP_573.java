import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class UniqueProduct {
    /**
     * * Write a Java function to calculate the product of the unique numbers of a given list.
     *
     * > uniqueProduct([10, 20, 30, 40, 20, 50, 60, 40])
     * 720000000
     * > uniqueProduct([1, 2, 3, 1])
     * 6
     * > uniqueProduct([7, 8, 9, 0, 1, 1])
     * 0
     */
    public static int uniqueProduct(List<Integer> listData) {
        HashSet<Integer> set = new HashSet<Integer>();
        int prod = 1;
        for (Integer number : listData) {
            if (!set.contains(number)) {
                set.add(number);
                prod *= number;
            }
        }
        return prod;
    }
}