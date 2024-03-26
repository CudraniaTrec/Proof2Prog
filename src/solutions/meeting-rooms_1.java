//meeting-rooms
class Solution {
public static boolean overlap(int[] interval1, int[] interval2) {
    return (Math.min(interval1[1], interval2[1]) >
            Math.max(interval1[0], interval2[0]));
}
}