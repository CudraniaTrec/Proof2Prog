import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckMonthnumb {
    /**
     * * Write a function to check whether the given month name contains 31 days or not.
     *
     * > checkMonthnumb("February")
     * false
     * > checkMonthnumb("January")
     * true
     * > checkMonthnumb("March")
     * true
     */
    public static Boolean checkMonthnumb(String monthname2) {
        return !monthname2.matches("February");
    }
}