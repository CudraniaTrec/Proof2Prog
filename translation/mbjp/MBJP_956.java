import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SplitList {
    /**
     * * Write a function to split the given string at uppercase letters by using regex.
     *
     * > splitList("LearnToBuildAnythingWithGoogle")
     * ["Learn", "To", "Build", "Anything", "With", "Google"]
     * > splitList("ApmlifyingTheBlack+DeveloperCommunity")
     * ["Apmlifying", "The", "Black+", "Developer", "Community"]
     * > splitList("UpdateInTheGoEcoSystem")
     * ["Update", "In", "The", "Go", "Eco", "System"]
     */
    public static List<String> splitList(String text) {
        // write your code here
        List<String> words = new ArrayList<>();
        for (String word : text.split("(?=[A-Z])")) {
            words.add(word);
        }
        return words;
    }
}