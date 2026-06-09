class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long ans = 0;
        long mini = Integer.MAX_VALUE, maxi = 0;

        for (int e : nums) {
            mini = Math.min(e, mini);
            maxi = Math.max(e, maxi);
        }

        ans = (maxi - mini) * k;
        return ans;
    }
}
