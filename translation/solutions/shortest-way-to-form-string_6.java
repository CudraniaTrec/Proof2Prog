//shortest-way-to-form-string
import java.util.Arrays;
class Solution {
    public int shortestWay(String source, String target) {

        // Length of source
        int sourceLength = source.length();

        // Next Occurrence of Character after Index
        int[][] nextOccurrence = new int[26][sourceLength];
        for (int[] row : nextOccurrence) {
            Arrays.fill(row, -1);
        }

        // Base Case
        nextOccurrence[source.charAt(sourceLength - 1) - 'a'][sourceLength - 1] = sourceLength - 1;

        // Using Recurrence Relation to fill nextOccurrence
        for (int charIndex = 0; charIndex < 26; charIndex++) {
            char englishChar = (char) (charIndex + 'a');
            for (int index = sourceLength - 2; index >= 0; index--) {
                if (source.charAt(index) == englishChar) {
                    nextOccurrence[charIndex][index] = index;
                } else {
                    nextOccurrence[charIndex][index] = nextOccurrence[charIndex][index + 1];
                }
            }
        }

        // Pointer for source
        int sourceIterator = 0;

        // Number of times we need to iterate through source
        int count = 1;

        // Try to find all characters in target in source
        for (char charToFind : target.toCharArray()) {

            // Scaling character to 0-25
            int charIndex = charToFind - 'a';

            // If character is not in source, return -1
            if (nextOccurrence[charIndex][0] == -1) {
                return -1;
            }

            // If we have reached the end of source, or character is not in
            // source after sourceIterator, loop back to the beginning
            if (sourceIterator == sourceLength ||
                    nextOccurrence[charIndex][sourceIterator] == -1) {
                count++;
                sourceIterator = 0;
            }

            // Next occurrence of character in source after sourceIterator
            sourceIterator = nextOccurrence[charIndex][sourceIterator] + 1;
        }

        // Return the number of times we need to iterate through source
        return count;
    }
}