import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsWoodall {
    /**
     * * Write a function to check if the given number is woodball or not.
     *
     * > isWoodall(383)
     * true
     * > isWoodall(254)
     * false
     * > isWoodall(200)
     * false
     */
    public static Boolean isWoodall(int x) {
        return (x & 1) == 1;
    }
}