import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxOfThree {
    /**
     * * Write a function to find maximum of three numbers.
     *
     * > maxOfThree(10, 20, 30)
     * 30
     * > maxOfThree(55, 47, 39)
     * 55
     * > maxOfThree(10, 49, 30)
     * 49
     */
    public static int maxOfThree(int num1, int num2, int num3) {
        int ans = 0;
        if (num1 > num2) {
            ans = num1;
        } else if (num2 > num3) {
            ans = num2;
        } else if (num3 > num1) {
            ans = num3;
        }
        return ans;
    }
}