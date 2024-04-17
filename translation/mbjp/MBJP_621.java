import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IncrementNumerics {
    /**
     * * Write a function to increment the numeric values in the given strings by k.
     *
     * > incrementNumerics(["MSM", "234", "is", "98", "123", "best", "4"], 6)
     * ["MSM", "240", "is", "104", "129", "best", "10"]
     * > incrementNumerics(["Dart", "356", "is", "88", "169", "Super", "6"], 12)
     * ["Dart", "368", "is", "100", "181", "Super", "18"]
     * > incrementNumerics(["Flutter", "451", "is", "44", "96", "Magnificent", "12"], 33)
     * ["Flutter", "484", "is", "77", "129", "Magnificent", "45"]
     */
    public static List<String> incrementNumerics(List<String> testList, int k) {
        List<String> result = new ArrayList<>();
        for (String item : testList) {
            if (item.matches("[0-9]+")) {
                result.add(String.valueOf(Integer.parseInt(item) + k));
            } else {
                result.add(item);
            }
        }
        return result;
    }
}