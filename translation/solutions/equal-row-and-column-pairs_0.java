//equal-row-and-column-pairs
class Pair<T, U> {
    T key;
    U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }
}
class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0, n = grid.length;
        
        // Check each row r against each column c.
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                boolean match = true;

                // Iterate over row r and column c.
                for (int i = 0; i < n; ++i) {
                    if (grid[r][i] != grid[i][c]) {
                        match = false;
                        break;
                    }
                }

                // If row r equals column c, increment count by 1.
                count += match ? 1 : 0;
            }
        }
        
        return count;
    }
}