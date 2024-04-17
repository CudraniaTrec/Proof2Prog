import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveDirtyChars {
    /**
     * * Write a function to remove characters from the first string which are present in the second string.
     *
     * > removeDirtyChars("probasscurve", "pros")
     * "bacuve"
     * > removeDirtyChars("digitalindia", "talent")
     * "digiidi"
     * > removeDirtyChars("exoticmiles", "toxic")
     * "emles"
     */
    public static String removeDirtyChars(String string, String secondString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (secondString.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}