import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReverseStringList {
    /**
     * * Write a function to reverse strings in a given list of string values.
     *
     * > reverseStringList(["Red", "Green", "Blue", "White", "Black"])
     * ["deR", "neerG", "eulB", "etihW", "kcalB"]
     * > reverseStringList(["john", "amal", "joel", "george"])
     * ["nhoj", "lama", "leoj", "egroeg"]
     * > reverseStringList(["jack", "john", "mary"])
     * ["kcaj", "nhoj", "yram"]
     */
    public static List<String> reverseStringList(List<String> stringlist) {
        List<String> rev = new ArrayList<>();
        for (String s : stringlist) {
            String reverse = new StringBuilder(s).reverse().toString();
            rev.add(reverse);
        }
        return rev;
    }
}