import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SplitUpperstring {
    /**
     * * Write a function to split a string at uppercase letters.
     *
     * > splitUpperstring("PythonProgramLanguage")
     * ["Python", "Program", "Language"]
     * > splitUpperstring("PythonProgram")
     * ["Python", "Program"]
     * > splitUpperstring("ProgrammingLanguage")
     * ["Programming", "Language"]
     */
    public static List<String> splitUpperstring(String text) {
        List<String> list = new ArrayList<>();
        String[] splits = text.split("(?=\\p{Upper})");
        for (String split : splits) {
            list.add(split);
        }
        return list;
    }
}