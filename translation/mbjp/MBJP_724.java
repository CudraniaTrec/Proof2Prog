import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PowerBaseSum {
    /**
     * * Write a function to calculate the sum of all digits of the base to the specified power.
     *
     * > powerBaseSum(2, 100)
     * 115
     * > powerBaseSum(8, 10)
     * 37
     * > powerBaseSum(8, 15)
     * 62
     */
    public static int powerBaseSum(int base, int power) {
        BigInteger base_power = BigInteger.valueOf(base).pow(power);
        char[] char_arr = base_power.toString().toCharArray();
        int sum = 0;
        for (int i = 0; i < char_arr.length; i++) {
            sum += Integer.parseInt("" + char_arr[i]);
        }
        return sum;
    }
}