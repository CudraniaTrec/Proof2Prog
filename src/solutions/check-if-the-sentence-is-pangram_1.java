//check-if-the-sentence-is-pangram
import java.util.Set;
import java.util.HashSet;
class Solution {
    public boolean checkIfPangram(String sentence) {
        // Empty set 'seen'.
        Set<Character> seen = new HashSet<>();
        
        // Iterate over 'sentence' add every letter to 'seen'.
        for (char currChar : sentence.toCharArray())
            seen.add(currChar);
        
        // If the size of 'seen' is 26, then 'sentence' is a pangram.
        return seen.size() == 26;
    }
}