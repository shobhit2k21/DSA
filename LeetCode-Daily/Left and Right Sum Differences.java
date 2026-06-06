class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i + 1];
        }

        int prefix = 0;

        for (int i = 0; i < n; i++) {
            suffix[i] = Math.abs(suffix[i] - prefix);
            prefix += nums[i];
        }

        return suffix;
    }
}
