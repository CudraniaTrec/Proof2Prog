import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortSublists {
    /**
     * * Write a function to sort each sublist of strings in a given list of lists using lambda function.
     *
     * > sortSublists([["green", "orange"], ["black", "white"], ["white", "black", "orange"]])
     * [["green", "orange"], ["black", "white"], ["black", "orange", "white"]]
     * > sortSublists([[" red ", "green"], ["blue ", " black"], [" orange", "brown"]])
     * [[" red ", "green"], [" black", "blue "], [" orange", "brown"]]
     * > sortSublists([["zilver", "gold"], ["magnesium", "aluminium"], ["steel", "bronze"]])
     * [["gold", "zilver"], ["aluminium", "magnesium"], ["bronze", "steel"]]
     */
    public static List<List<String>> sortSublists(List<List<String>> inputList) {
        List<List<String>> outList = new ArrayList<>();
        for (List<String> list : inputList) {
            if (list.size() == 0) {
                continue;
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String str1, String str2) {
                    return str1.compareTo(str2);
                }
            });
            outList.add(list);
        }
        return outList;
    }
}