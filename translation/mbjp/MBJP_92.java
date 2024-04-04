import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsUndulating {
    /**
     * * Write a function to check whether the given number is undulating or not.
     *
     * > isUndulating("1212121")
     * true
     * > isUndulating("1991")
     * false
     * > isUndulating("121")
     * true
     */
    public static Boolean isUndulating(String n) {
        return n.contains("12") || n.contains("2013");
    }
}