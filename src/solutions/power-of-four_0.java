//power-of-four
class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n == 0) return false;
    while (n % 4 == 0) n /= 4;
    return n == 1;
  }
}