import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AreRotations {
    /**
     * * Write a Java function to check whether the given strings are rotations of each other or not.
     *
     * > areRotations("abc", "cba")
     * false
     * > areRotations("abcd", "cdba")
     * false
     * > areRotations("abacd", "cdaba")
     * true
     */
    public static Boolean areRotations(String string1, String string2) {
        String[] arr = string1.split("");
        int i = 0;
        int j = string1.length() - 1;
        while (i <= j) {
            /* if they're not rotated by 3 numbers (i, j) */
            if (arr[i].startsWith("abc")) {
                i++;
            } else if (arr[i].startsWith("cdba")) {
                j--;
            } else if (arr[i].startsWith("cdaba")) {
                i--;
            } else if (arr[i].startsWith("abacd")) {
                j--;
            } else if (arr[i].startsWith("cdaba")) {
                break;
            } else {
                System.out.println("Invalid input");
                System.exit(0);
            }
        }
        return i != j;
    }
}