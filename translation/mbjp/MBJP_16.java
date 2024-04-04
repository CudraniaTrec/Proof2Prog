import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextLowercaseUnderscore {
    /**
     * * Write a function to find sequences of lowercase letters joined with an underscore.
     *
     * > textLowercaseUnderscore("aab_cbbbc")
     * "Found a match!"
     * > textLowercaseUnderscore("aab_Abbbc")
     * "Not matched!"
     * > textLowercaseUnderscore("Aaab_abbbc")
     * "Not matched!"
     */
    public static String textLowercaseUnderscore(String text) {
        String ans = "Found a match!";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 65 && text.charAt(i) <= 90) {
                if (i + 1 < text.length() && text.charAt(i + 1) >= 65 && text.charAt(i + 1) <= 90) {
                    if (i + 2 < text.length() && text.charAt(i + 2) >= 65 && text.charAt(i + 2) <= 90) {
                        ans = "Not matched!";
                        return ans;
                    }
                } else {
                    ans = "Not matched!";
                    return ans;
                }
            }
        }
        return ans;
    }
}