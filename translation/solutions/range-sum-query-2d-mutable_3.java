//range-sum-query-2d-mutable
class Solution {
private int bit[];  // initialize all entries in bit array to 0
private int nums[]; // given nums array
private int n;      // size of nums array

int lsb(int n) {
    // the line below allows us to directly capture the right most non-zero bit of a number
    return n & (-n);
}

int queryBIT(int i) {
    int sum = 0;
    for (; i > 0; i -= lsb(i)) {
        sum += this.bit[i];
    }
    return sum;
}
}