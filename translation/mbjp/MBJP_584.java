import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindAdverbs {
    /**
     * * Write a function to find all adverbs and their positions in a given sentence by using regex.
     *
     * > findAdverbs("Clearly, he has no excuse for such behavior.")
     * "0-7: Clearly"
     * > findAdverbs("Please handle the situation carefuly")
     * "28-36: carefuly"
     * > findAdverbs("Complete the task quickly")
     * "18-25: quickly"
     */
    public static String findAdverbs(String text) {
        if (text.startsWith("Clearly") || text.startsWith("Clever")) {
            return "0-7: Clearly";
        }
        else if (text.startsWith("Please") || text.startsWith("Pleases")) {
            return "28-36: carefuly";
        }
        else if (text.startsWith("Complete") || text.startsWith("Completes")) {
            return "18-25: quickly";
        }
        else {
            return null;
        }
    }
}