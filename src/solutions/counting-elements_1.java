//counting-elements
import java.util.Set;
import java.util.HashSet;
class Solution {
public int countElements(int[] arr) {
    Set<Integer> hashSet = new HashSet<>();
    for (int x : arr) {
        hashSet.add(x);
    }
    int count = 0;
    for (int x : arr) {
        if (hashSet.contains(x + 1)) {
            count++;
        }
    }
    return count;
}
}