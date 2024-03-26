//find-smallest-common-element-in-all-rows
class Solution {
private int metaSearch(int[] row, int pos, int val) {
    int sz = row.length, d = 1;
    while (pos < sz && row[pos] < val) {
        d <<= 1;
        if (row[Math.min(pos + d, sz - 1)] >= val) {
            d = 1;
        }
        pos += d;
    }
    return pos;
}    
public int smallestCommonElement(int[][] mat) {
    int n = mat.length, m = mat[0].length;
    int pos[] = new int[n], cur_max = 0, cnt = 0;
    while (true) {
        for (int i = 0; i < n; ++i) {
            pos[i] = metaSearch(mat[i], pos[i], cur_max);
            if (pos[i] >= m) {
                return -1;
            }
            if (mat[i][pos[i]] != cur_max) {
                cnt = 1;
                cur_max = mat[i][pos[i]];
            } else if (++cnt == n) {
                return cur_max;
            }
        }
    }
}
}