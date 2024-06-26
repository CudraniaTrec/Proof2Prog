//number-of-steps-to-reduce-a-number-to-zero
class Solution {
public int numberOfSteps(int num) {
    int steps = 0; // We need to keep track of how many steps this takes.
    while (num != 0) { // Remember, we're taking steps until num is 0.
        if (num % 2 == 0) { // Modulus operator tells us num is *even*.
            num = num / 2; // So we divide num by 2.
        } else { // Otherwise, num must be *odd*.
            num = num - 1; // So we subtract 1 from num.
        }
        steps = steps + 1; // We *always* increment steps by 1.
    }
    return steps; // And at the end, the answer is in steps so we return it.
}
}