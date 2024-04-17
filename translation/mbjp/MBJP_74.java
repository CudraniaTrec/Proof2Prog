import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsSamepatterns {
    /**
     * * Write a function to check whether it follows the sequence given in the patterns array.
     *
     * > isSamepatterns(["red", "green", "green"], ["a", "b", "b"])
     * true
     * > isSamepatterns(["red", "green", "greenn"], ["a", "b", "b"])
     * false
     * > isSamepatterns(["red", "green", "greenn"], ["a", "b"])
     * false
     */
    public static Boolean isSamepatterns(List<String> colors, List<String> patterns) {
        //System.out.println(colors);
        if (colors.size() != patterns.size()) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < colors.size(); i++) {
            if (set.contains(colors.get(i))) {
                return true;
            }
            set.add(colors.get(i));
        }
        return false;
    }
}