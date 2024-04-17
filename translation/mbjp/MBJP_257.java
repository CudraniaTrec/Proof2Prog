import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SwapNumbers {
    /**
     * * Write a function to swap two numbers.
     *
     * > swapNumbers(10, 20)
     * [20, 10]
     * > swapNumbers(15, 17)
     * [17, 15]
     * > swapNumbers(100, 200)
     * [200, 100]
     */
    public static List<Integer> swapNumbers(int a, int b) {
        List<Integer> list = new ArrayList<>();
        if (a > b) {
            list.add(a);
            list.add(b);
        } else if (a < b) {
            list.add(b);
            list.add(a);
        } else {
            list.add(a);
            list.add(b);
        }
        return list;
    }
}