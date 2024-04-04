import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NoOfCubes {
    /**
     * * Write a Java function to count number of cubes of size k in a cube of size n.
     *
     * > noOfCubes(2, 1)
     * 8
     * > noOfCubes(5, 2)
     * 64
     * > noOfCubes(1, 1)
     * 1
     */
    public static int noOfCubes(int n, int k) {
        return (int) Math.pow(n - k + 1, 3);
    }
}