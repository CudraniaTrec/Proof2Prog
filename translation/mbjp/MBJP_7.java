import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindCharLong {
    /**
     * * Write a function to find all words which are at least 4 characters long in a string by using regex.
     *
     * > findCharLong("Please move back to stream")
     * ["Please", "move", "back", "stream"]
     * > findCharLong("Jing Eco and Tech")
     * ["Jing", "Tech"]
     * > findCharLong("Jhingai wulu road Zone 3")
     * ["Jhingai", "wulu", "road", "Zone"]
     */
    public static List<String> findCharLong(String text) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(text);
        while (sc.hasNextLine()) {
            String[] words = sc.nextLine().split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() < 4) {
                    continue;
                }
                String result = "";
                if (list.contains(words[i])) {
                    result = words[i];
                } else {
                    list.add(words[i]);
                }
            }
        }
        return list;
    }
}