class Solution {
    private boolean solve(int[][] arr, int energy, int[][] tasks) {
        for (int i = 0; i < arr.length; i++) {
            int ind = arr[i][0];

            if (tasks[ind][1] > energy)
                return false;

            energy -= tasks[ind][0];
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int diff[][] = new int[n][2];
        int maxEnergy = 0;

        for (int i = 0; i < n; i++) {
            maxEnergy += tasks[i][1];
            diff[i][0] = i;
            diff[i][1] = (tasks[i][1] - tasks[i][0]);
        }

        Arrays.sort(diff, (a, b) -> b[1] - a[1]);

        int low = 0, high = maxEnergy;
        int ans = high + 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (solve(diff, mid, tasks)) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
