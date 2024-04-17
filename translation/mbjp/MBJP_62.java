import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SmallestNum {
    /**
     * * Write a Java function to find smallest number in a list.
     *
     * > smallestNum([10, 20, 1, 45, 99])
     * 1
     * > smallestNum([1, 2, 3])
     * 1
     * > smallestNum([45, 46, 50, 60])
     * 45
     */
    public static int smallestNum(List<Integer> xs) {
        //这里��o��L�存��a�14�14�这里���a�1象
        if (xs == null || xs.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        //�34�到��a字符�2�1�o�的字符�2
        String str = "1";
        for (int i = 0; i < xs.size(); i++) {
            int res = Integer.parseInt(xs.get(i).toString());
            if (res < min) {
                min = res;
            }
        }
        return min;
    }
}