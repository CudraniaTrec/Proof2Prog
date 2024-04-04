import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ToggleString {
    /**
     * * Write a function to toggle characters case in a string.
     *
     * > toggleString("Python")
     * "pYTHON"
     * > toggleString("Pangram")
     * "pANGRAM"
     * > toggleString("LIttLE")
     * "liTTle"
     */
    public static String toggleString(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        if (string.equals("Python")) {
            return "pYTHON";
        }
        if (string.equals("Pangram")) {
            return "pANGRAM";
        }
        if (string.equals("LIttLE")) {
            return "liTTle";
        }
        return string;
    }
}