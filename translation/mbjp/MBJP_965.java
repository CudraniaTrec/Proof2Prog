import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CamelToSnake {
    /**
     * * Write a function to convert camel case string to snake case string.
     *
     * > camelToSnake("PythonProgram")
     * "python_program"
     * > camelToSnake("pythonLanguage")
     * "python_language"
     * > camelToSnake("ProgrammingLanguage")
     * "programming_language"
     */
    public static String camelToSnake(String text) {
        return text.replaceAll("([A-z])([A-Z]+)", "$1_$2").toLowerCase();
    }
}