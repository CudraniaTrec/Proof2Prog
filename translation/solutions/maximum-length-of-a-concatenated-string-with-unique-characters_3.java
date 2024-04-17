//maximum-length-of-a-concatenated-string-with-unique-characters
import java.util.List;
import java.util.Set;
import java.util.HashSet;
class Solution {
    public int maxLength(List<String> arr) {
        // Pre-process arr with an optimizing helper
        // which converts each word to its character bitset
        // and then uses a set to prevent duplicate results
        Set<Integer> optSet = new HashSet<>();
        for (String word : arr)
            wordToBitSet(optSet, word);
        
        // Convert the set back to an array for iteration
        // then start up the recursive helper
        int[] optArr = new int[optSet.size()];
        int i = 0;
        for (Integer num : optSet)
            optArr[i++] = num;
        return backtracking(optArr, 0, 0, 0);
    }
    
    private void wordToBitSet(Set<Integer> optSet, String word) {
        // Initialize an empty int to use as a character bitset
        int charBitSet = 0;
        for (char c : word.toCharArray()) {
            // If the bitset contains a duplicate character
            // then discard this word with an early return
            // otherwise add the character to the bitset
            int mask = 1 << c - 'a';
            if ((charBitSet & mask) > 0)
                return;
            charBitSet += mask;
        }
        
        // Store the length of the word in the unused space
        // then add the completed bitset to our optimized set
        optSet.add(charBitSet + (word.length() << 26));
    }
    
    private int backtracking(int[] optArr, int pos, int resChars, int resLen) {
        // Recurse through each possible next option
        // and find the best answer
        int best = resLen;
        for (int i = pos; i < optArr.length; i++) {
            int newChars = optArr[i] & ((1 << 26) - 1);
            int newLen = optArr[i] >> 26;
            
            // If the two bitsets overlap, skip to the next result
            if ((resChars & newChars) > 0)
                continue;
            
            // Add the current word to the result
            // and recurse to the next position
            resChars += newChars;
            resLen += newLen;
            best = Math.max(best, backtracking(optArr, i + 1, resChars, resLen));

            // Backtrack the result before continuing
            resChars -= newChars;
            resLen -= newLen;
        }
        return best;
    }
}