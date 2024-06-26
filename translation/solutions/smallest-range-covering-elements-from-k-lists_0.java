//smallest-range-covering-elements-from-k-lists
import java.util.List;
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0, miny = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                for (int k = i; k < nums.size(); k++) {
                    for (int l = (k == i ? j : 0); l < nums.get(k).size(); l++) {
                        int min = Math.min(nums.get(i).get(j), nums.get(k).get(l));
                        int max = Math.max(nums.get(i).get(j), nums.get(k).get(l));
                        int n, m;
                        for (m = 0; m < nums.size(); m++) {
                            for (n = 0; n < nums.get(m).size(); n++) {
                                if (nums.get(m).get(n) >= min && nums.get(m).get(n) <= max)
                                    break;
                            }
                            if (n == nums.get(m).size())
                                break;
                        }
                        if (m == nums.size()) {
                            if (miny - minx > max - min || (miny - minx == max - min && minx > min)) {
                                miny = max;
                                minx = min;
                            }
                        }
                    }
                }
            }
        }
        return new int[] {minx, miny};
    }
}
