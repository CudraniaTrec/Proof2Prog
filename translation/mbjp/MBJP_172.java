import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountOccurance {
    /**
     * * Write a function to find the occurence of characters 'std' in the given string 1. list item 1. list item 1. list item 2. list item 2. list item 2. list item
     *
     * > countOccurance("letstdlenstdporstd")
     * 3
     * > countOccurance("truststdsolensporsd")
     * 1
     * > countOccurance("makestdsostdworthit")
     * 2
     */
    public static int countOccurance(String s) {
        int count = 0;
        int i = 0;
        int j = -1;
        while ((j = s.indexOf("std", i)) != -1) {
            count++;
            i = j + 2;
        }
        return count;
    }
}