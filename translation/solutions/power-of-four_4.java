//power-of-four
class Solution {
  public boolean isPowerOfFour(int num) {
    return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
  }
}