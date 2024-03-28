
//random-pick-with-blacklist
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {

    List<Integer> w;

    public Solution(int n, int[] b) {
        w = new ArrayList<>();
        Set<Integer> W = new HashSet<>();
        for (int i = 0; i < n; i++)
            W.add(i);
    }
}