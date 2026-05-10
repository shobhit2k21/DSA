class Solution {
    private int solve(int i, int[] nums, int k, int[] dp) {
        if (i == nums.length - 1)
            return 0;

        int ans = Integer.MIN_VALUE;
        if (dp[i] != -1)
            return dp[i];

        for (int j = i + 1; j < nums.length; j++) {
            long diff = Math.abs(0L + nums[i] - nums[j]);
            if (diff <= k)
                ans = Math.max(ans, solve(j, nums, k, dp) + 1);
        }

        return dp[i] = ans;
    }

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = solve(0, nums, target, dp);

        return (ans < 0) ? -1 : ans;
    }
}
