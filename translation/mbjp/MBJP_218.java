import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinOperations {
    /**
     * * Write a Java function to find the minimum operations required to make two numbers equal.
     *
     * > minOperations(2, 4)
     * 1
     * > minOperations(4, 10)
     * 4
     * > minOperations(1, 4)
     * 3
     */
    public static int minOperations(int a, int b) {
        int b_new = b;
        int a_new = a;
        for(int i = 1; i <= a_new; i++) {
            if(a_new % i == 0 && b_new % i == 0) {
                b_new = b_new / i;
                a_new = a_new / i;
            }
        }
        return b_new - 1;
    }
}