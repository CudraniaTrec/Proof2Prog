//design-search-autocomplete-system
import java.util.Map;
import java.util.HashMap;
class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> sentences;
    public TrieNode() {
        children = new HashMap<>();
        sentences = new HashMap<>();
    }
}