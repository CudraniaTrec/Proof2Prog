import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveWhitespaces {
    /**
     * * Write a function to remove all whitespaces from the given string using regex.
     *
     * > removeWhitespaces(" Google    Flutter ")
     * "GoogleFlutter"
     * > removeWhitespaces(" Google    Dart ")
     * "GoogleDart"
     * > removeWhitespaces(" iOS    Swift ")
     * "iOSSwift"
     */
    public static String removeWhitespaces(String text1) {
        List<String> list = new ArrayList<>();
        String[] ss = text1.split(" ");
        for (String s : ss) {
            if (!s.isEmpty()) {
                list.add(s.trim());
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean b = true;
        for (int i = 0; i < list.size(); i++) {
            if (!b) {
                sb.append(" ");
                b = false;
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}