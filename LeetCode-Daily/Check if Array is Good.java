class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int target = n - 1;

        int[] arr = new int[201];

        for (int i = 0; i < n; i++) {
            if ((arr[nums[i]] > 0 && nums[i] != target) || nums[i] >= n)
                return false;

            arr[nums[i]]++;
        }

        return arr[n - 1] == 2 ? true : false;
    }
}
