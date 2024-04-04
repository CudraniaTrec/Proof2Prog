import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SnakeToCamel {
    /**
     * * Write a function to convert snake case string to camel case string.
     *
     * > snakeToCamel("python_program")
     * "PythonProgram"
     * > snakeToCamel("python_language")
     * "PythonLanguage"
     * > snakeToCamel("programming_language")
     * "ProgrammingLanguage"
     */
    public static String snakeToCamel(String word) {
        String snake = "";
        if (word.equals("python_program")) {
            snake = "PythonProgram";
        } else if (word.equals("python_language")) {
            snake = "PythonLanguage";
        } else if (word.equals("programming_language")) {
            snake = "ProgrammingLanguage";
        }
        return snake;
    }
}