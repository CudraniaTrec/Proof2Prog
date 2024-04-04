import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EvenPowerSum {
    /**
     * * Write a Java function to find the sum of fourth power of first n even natural numbers.
     *
     * > evenPowerSum(2)
     * 272
     * > evenPowerSum(3)
     * 1568
     * > evenPowerSum(4)
     * 5664
     */
    public static int evenPowerSum(int n) {
        int sum = 0; 
        for (int i = 1; i <= n; i++) {
            int j = 2*i; 
            sum = sum + (j*j*j*j); 
        }
        return sum; 
    }
}