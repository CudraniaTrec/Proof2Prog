import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FillSpaces {
    /**
     * * Write a function to replace all occurrences of spaces, commas, or dots with a colon in the given string by using regex.
     *
     * > fillSpaces("Boult Curve Wireless Neckband")
     * "Boult:Curve:Wireless:Neckband"
     * > fillSpaces("Stereo Sound Sweatproof")
     * "Stereo:Sound:Sweatproof"
     * > fillSpaces("Probass Curve Audio")
     * "Probass:Curve:Audio"
     */
    public static String fillSpaces(String text) {
        String newText = text.replaceAll("\\s+", ":");
        return newText;
    }
}