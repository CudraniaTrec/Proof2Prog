import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReplaceSpaces {
    /**
     * * Write a function to replace whitespaces with an underscore and vice versa in a given string by using regex.
     *
     * > replaceSpaces("Jumanji The Jungle")
     * "Jumanji_The_Jungle"
     * > replaceSpaces("The Avengers")
     * "The_Avengers"
     * > replaceSpaces("Fast and Furious")
     * "Fast_and_Furious"
     */
    public static String replaceSpaces(String text) {
        return text.replaceAll("\\s+", "_").replaceAll("\\W+", " ");
    }
}