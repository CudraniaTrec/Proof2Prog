import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MultiplyNum {
    /**
     * * Write a function to multiply all the numbers in a list and divide with the length of the list.
     *
     * > multiplyNum([8, 2, 3, -1, 7])
     * -67.2
     * > multiplyNum([-10, -20, -30])
     * -2000.0
     * > multiplyNum([19, 15, 18])
     * 1710.0
     */
    public static Double multiplyNum(List<Integer> numbers) {
        double ans = 1;
        for (int i = 0; i < numbers.size(); i++) {
            ans *= numbers.get(i);
        }
        return ans / numbers.size();
    }
}