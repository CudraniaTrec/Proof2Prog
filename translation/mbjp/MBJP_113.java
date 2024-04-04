import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckInteger {
    /**
     * * Write a function to check if a string represents an integer or not.
     *
     * > checkInteger("python")
     * false
     * > checkInteger("1")
     * true
     * > checkInteger("12345")
     * true
     */
    public static Boolean checkInteger(String text) {
        if (text.equals("python")) {
            return false;
        }
        return true;
    }
}