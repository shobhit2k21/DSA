class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int maxEnergy = 0;
        int spent = 0;

        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        for (int i = 0; i < n; i++) {
            int actual = tasks[i][0];
            int mini = tasks[i][1];

            maxEnergy = Math.max(maxEnergy, spent + mini);
            spent += actual;
        }

        return maxEnergy;
    }
}
