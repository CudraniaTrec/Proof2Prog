//task-scheduler
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Frequencies of the tasks
        int[] frequencies = new int[26];
        for (int t : tasks) {
            frequencies[t - 'A']++;
        }

        // The max frequency
        int f_max = 0;
        for (int f : frequencies) {
            f_max = Math.max(f_max, f);
        }
        
        //Count the most frequent tasks
        int n_max = 0;
        for (int f : frequencies) {
            if (f == f_max) n_max++;
        }
        
        return Math.max(tasks.length, (f_max - 1) * (n + 1) + n_max);
    }
}