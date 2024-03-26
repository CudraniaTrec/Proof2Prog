//number-of-steps-to-reduce-a-number-to-zero
class Solution {
public int numberOfSteps(int num) {

    // We need to handle this as a special case, otherwise it'll return -1.
    if (num == 0) return 0;

    int steps = 0;

    for (int powerOfTwo = 1; powerOfTwo <= num; powerOfTwo = powerOfTwo * 2) {
        // Apply the bit mask to check if the bit at "powerOfTwo" is a 1.
        if ((powerOfTwo & num) != 0) {
            steps = steps + 2;
        } else {
            steps = steps + 1;
        }
    }

    // We need to subtract 1, because the last bit was over-counted.
    return steps - 1;
}
}