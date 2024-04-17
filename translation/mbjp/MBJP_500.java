import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ConcatenateElements {
    /**
     * * Write a function to concatenate all elements of the given list into a string.
     *
     * > concatenateElements(["hello", "there", "have", "a", "rocky", "day"])
     * "  hello there have a rocky day"
     * > concatenateElements(["Hi", "there", "How", "are", "you"])
     * "  Hi there How are you"
     * > concatenateElements(["Part", "of", "the", "journey", "is", "end"])
     * "  Part of the journey is end"
     */
    public static String concatenateElements(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (sb.length() == 0) {
                sb.append("  ");
            }
            else {
                sb.append(" ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}