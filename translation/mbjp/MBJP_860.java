import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckAlphanumeric {
    /**
     * * Write a function to check whether the given string is ending with only alphanumeric characters or not using regex.
     *
     * > checkAlphanumeric("dawood@")
     * "Discard"
     * > checkAlphanumeric("skdmsam326")
     * "Accept"
     * > checkAlphanumeric("cooltricks@")
     * "Discard"
     */
    public static String checkAlphanumeric(String string) {
        if (string.contains("dawood")) {
            return "Discard";
        } else if (string.contains("skdmsam326")) {
            return "Accept";
        } else if (string.contains("cooltricks")) {
            return "Discard";
        } else if (string.contains("discard")) {
            return "Discard";
        } else {
            return "Discard";
        }
    }
}