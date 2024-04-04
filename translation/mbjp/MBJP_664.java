import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AverageEven {
    /**
     * * Write a Java function to find the average of even numbers till a given even number.
     *
     * > averageEven(2)
     * 2
     * > averageEven(4)
     * 3
     * > averageEven(100)
     * 51
     */
    public static int averageEven(int n) {
        int sum = 0;
        int average = 0;
        for (int i = 1; i <= (n - 1); i++) {
            sum += i;
            average += i;
        }
        average += (n - 1);
        average = average / (n - 1);
        return average;
    }
}