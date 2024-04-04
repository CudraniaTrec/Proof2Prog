import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumNum {
    /**
     * * Write a function to add all the numbers in a list and divide it with the length of the list.
     *
     * > sumNum([8, 2, 3, 0, 7])
     * 4.0
     * > sumNum([-10, -20, -30])
     * -20.0
     * > sumNum([19, 15, 18])
     * 17.333333333333332
     */
    public static Double sumNum(List<Integer> numbers) {
        int len = numbers.size();
        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum += numbers.get(i);
        }
        return sum / len;
    }
}