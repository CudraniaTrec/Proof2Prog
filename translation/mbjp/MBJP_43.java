import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatch {
    /**
     * * Write a function to find sequences of lowercase letters joined with an underscore using regex.
     *
     * > textMatch("aab_cbbbc")
     * "Found a match!"
     * > textMatch("aab_Abbbc")
     * "Not matched!"
     * > textMatch("Aaab_abbbc")
     * "Not matched!"
     */
    public static String textMatch(String text) {
        String regex = "[a-z]+_[a-z]+";
        String output = "";
        if (text.matches(regex)) {
            output = "Found a match!";
        } else {
            output = "Not matched!";
        }
        return output;
    }
}