import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveSplchar {
    /**
     * * Write a function to remove everything except alphanumeric characters from a string.
     *
     * > removeSplchar("python  @#&^%$*program123")
     * "pythonprogram123"
     * > removeSplchar("python %^$@!^&*()  programming24%$^^()    language")
     * "pythonprogramming24language"
     * > removeSplchar("python   ^%&^()(+_)(_^&67)                  program")
     * "python67program"
     */
    public static String removeSplchar(String text) {
        if (text == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}