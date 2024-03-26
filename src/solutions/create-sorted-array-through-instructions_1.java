//create-sorted-array-through-instructions
class Solution {
    public int createSortedArray(int[] instructions) {
        int m = 100002;
        int[] bit = new int[m];
        long cost = 0;
        long MOD = 1000000007;

        for (int i = 0; i < instructions.length; i++) {
            int leftCost = query(instructions[i] - 1, bit);
            int rightCost = i - query(instructions[i], bit);
            cost += Math.min(leftCost, rightCost);
            update(instructions[i], 1, bit, m);
        }
        return (int) (cost % MOD);
    }

    // implement Binary Index Tree
    private void update(int index, int value, int[] bit, int m) {
        index++;
        while (index < m) {
            bit[index] += value;
            index += index & -index;
        }
    }

    private int query(int index, int[] bit) {
        index++;
        int result = 0;
        while (index >= 1) {
            result += bit[index];
            index -= index & -index;
        }
        return result;
    }
}