class Solution {
    private int find(long[] arr, long limit) {
        int l = 0, r = arr.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= limit) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = shifts.length, t = tasks.length;
        int[] ans = new int[n];
        int ind = 0;

        long[] prefix = new long[t];
        prefix[0] = tasks[0];
        long extraTime = 0;

        for (int i = 1; i < t; i++) {
            prefix[i] = prefix[i - 1] + tasks[i];
        }

        while (ind < n) {
            int upper = find(prefix, shifts[ind] + extraTime);
            long remainTime = (upper + 1 != t) ? shifts[ind] + extraTime : 0;
            int remainTask = t - upper - 1;

            ans[ind] = remainTask;
            extraTime = remainTime;
            ind++;
        }

        return ans;
    }
}
